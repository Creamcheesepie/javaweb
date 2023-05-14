<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctp" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>회원 목록</title>
	<jsp:include page="/include/bs4.jsp"/>
	<script >
		function pageCheck(){
		let pageSize = document.getElementById("pageSize").value;
		location.href="${ctp}/AdminMemberList.ad?nowPage=${nowPage}&pageSize="+pageSize;
	}
		
		function levelChange(e){
			let ans = confirm("선택한 회원의 등급을 변경함?")
			if(!ans) return false;
			
			let items = e.value.split("/");
			let query = {
					idx : items[1],
					level : items[0]
			}
			
			$.ajax({
					type : "post",
					url : "${ctp}/AdminMemberLevelChange.ad",
					data : query,
					success : function(res){
						if(res=="1"){
							alert("등급 수정 완료!!");
						}
						else alert("등급 수정 실패.");
					},
					error : function(){
						alert("전송오류");
					}
			})
		}
		
		
		function memberDelete(idx){
			let ans = confirm("선택한 회원을 삭제합니까?")
			if(!ans) return false;
			
			
			$.ajax({
					type : "post",
					url : "${ctp}/AdminMemberDelete.ad",
					data : {idx : idx},
					success : function(){
							alert("회원 삭제 완료");
							location.reload();
						
					},
					error : function(){
						alert("전송오류");
					}
			})
		}
		
		function oneClickChange(){
			let ans = confirm("선택하신 내용으로 일괄변경 하시겠습니까?");
			if(!ans) return false;
			
			let stridx ='';
			let clickCnt = 0;
			document.querySelectorAll(".MCS").forEach(function(v,i){
				if(v.checked === true){
					stridx += v.value+"/";
					clickCnt++;
				}
			})
			
			if(clickCnt==0){
				alert("변경할 회원의 번호를 체크해주세요.");
				return false;
			}
			
			let level = document.getElementById("multilevelchange").value;
			
			$.ajax({
				type : "post",
				url : "${ctp}/AdminOneClickChange.ad",
				data : {stridx:stridx,level:level},
				success : function(){
					alert("작업완료")
					location.reload();
				},
				error : function(){
					alert("작업실패, 잠시 후 재시도하시거나 \n 현상이 반복되면 서비스 관리자에게 문의 주십시오.")
				}
			})
			
		}
		
		/*  */
		
		function totalSelect(e){
			if(e.target.checked){
				document.querySelectorAll(".MCS").forEach(function(v,i){
					v.checked=true;
				})
			}
			else{
				document.querySelectorAll(".MCS").forEach(function(v,i){
					v.checked=false;
				})
			}
		}
		
		function eachClickChange(e){
			let checkCount = 0;
			document.querySelectorAll(".MCS").forEach(function(v,i){
				if(v.checked === false){
				checkCount++;
				}
			});
			if(checkCount>0) {
				document.getElementById("totalSelect").checked = false;
			} else if(checkCount === 0) {
				document.getElementById("totalSelect").checked = true;
			}
		}
		
		
		
		
		
	</script>
</head>
<body>
<p><br/></p>	
	<div class="container">
		<h2>전체 회원 목록</h2>
		<br/>
		<select name="pageSize" id="pageSize" onchange="pageCheck()">
						<option <c:if test="${pageSize==1}">selected</c:if>>1</option>
						<option <c:if test="${pageSize==5}">selected</c:if>>5</option>
						<option <c:if test="${pageSize==10}">selected</c:if>>10</option>
					</select>건 표시
		<table class="table table-hover text-center">
			<tr class="table">
				<th>
				일괄체크
			  <input type="checkbox" name="totalSelect" id="totalSelect" onclick="totalSelect(event)"/>
				</th>
				<th></th>
				<th></th>
				<th></th>
				<th>비공개 여부
				<select name="userInfoSwChange" id="userInfoSwChange">
					<option value="선택">선택</option>
					<option value="공개">공개</option>
					<option value="비공개">비공개</option>
				</select>
				</th>
				<th></th>
				<th></th>
				<th>
				등급
					<select name="multilevelchange" id="multilevelchange" >	
						<option value="0" >관리자</option>
						<option value="1" >준회원</option>
						<option value="2" selected>정회원</option>
						<option value="3" >우수회원</option>
						<option value="4" >운영자</option>
					</select>	
				</th>
				<th><input type="button" value="일괄변경" name="oneClickChange" class="btn btn-success" onclick="oneClickChange()"/></th>
			</tr>
			<tr class="table-dark text-dark">
				<th>번호</th>
				<th>아이디</th>
				<th>별명</th>
				<th>성명</th>
				<th>비공개 여부</th>
				<th>최초가입일</th>
				<th>마지막 접속일</th>
				<th>등급</th>
				<th>탈퇴유무</th>
			</tr>
			<c:forEach var="vo" items="${vos}" varStatus="se">
				<tr>
					<td>
					${vo.idx}
					<input type="checkbox" name="multiChangeSelect" id="MCS${vo.idx}" class="MCS" onclick="eachClickChange()" value="${vo.idx}"/>
					</td>
					<td><a href="${ctp}/AdminMemberInfor.ad?mid=${vo.mid}&nowPage=${nowPage}&pageSize=${pageSize}">${vo.mid}</a></td>
					<td>${vo.nickName}</td>
					<td>${vo.name}</td>
					<td>${vo.userInfoSw}</td>
					<td>${vo.singInDate}</td>
					<td>${vo.lastDate}</td>
					<td> <!-- 개별회원 레벨(등급) 관리 -->
							<form name="levelform">
								<select name="level" onchange="levelChange(this)">
									<option value="0/${vo.idx}" ${vo.level==0?"selected":""}>관리자</option>
									<option value="1/${vo.idx}" ${vo.level==1?"selected":""}>준회원</option>
									<option value="2/${vo.idx}" ${vo.level==2?"selected":""}>정회원</option>
									<option value="3/${vo.idx}" ${vo.level==3?"selected":""}>우수회원</option>
									<option value="4/${vo.idx}" ${vo.level==4?"selected":""}>운영자</option>
								</select>
							</form>
					</td>
					<td>
						<c:if test="${vo.userDel=='OK'}">
							<font color="red"><b>탈퇴신청</b></font>
							(${vo.deleteDiff})
							<c:if test="${vo.deleteDiff >=30}"><a href="javascript:memberDelete(${vo.idx})">삭제</a></c:if>
						</c:if>
						<c:if test="${vo.userDel=='no'}">활동중</c:if>
					</td>
				</tr>
			</c:forEach>
			<tr><td colspan="5"></td></tr>
		</table>
		<ul class="pagination text-center justify-content-center border-secondary pagination-sm">	
				<c:if test="${nowPage>1}"><li class="page-item"><a class="page-link text-secondary" href="${ctp}/AdminMemberList.ad?pageSize=${pageSize}&nowPage=1">첫페이지</a></li></c:if>
				<c:if test="${curBlock>0}"><li class="page-item"><a class="page-link text-secondary" href="${ctp}/AdminMemberList.ad?pageSize=${pageSize}&nowPage=${(curBlock-1)*blockSize+1}">이전블록</a></li></c:if>
				<c:forEach var="i" begin="${curBlock*blockSize+1}" end="${curBlock*blockSize + blockSize}" varStatus="st">
					<c:if test="${i<=totalPage && i== nowPage}"><li class="page-item active bg-secondary"><a class="page-link bg-secondary" href="#">${i}</a></li></c:if>
					<c:if test="${i<=totalPage && i!= nowPage}"><li class="page-item"><a class="page-link text-secondary" href="${ctp}/AdminMemberList.ad?pageSize=${pageSize}&nowPage=${i}">${i}</a></li></c:if>
				</c:forEach>
				<c:if test="${curBlock<lastBlock}"><li class="page-item"><a class="page-link text-secondary" href="${ctp}/AdminMemberList.ad?pageSize=${pageSize}&nowPage=${(curBlock+1)*blockSize+1}">다음블록</a></li></c:if>
				<c:if test="${nowPage<totalPage}"><li class="page-item"><a class="page-link  text-secondary" href="${ctp}/AdminMemberList.ad?pageSize=${pageSize}&nowPage=${totalPage}">마지막페이지</a></li></c:if>
			</ul>
		
	</div>
<p><br/></p>
</body>
</html>