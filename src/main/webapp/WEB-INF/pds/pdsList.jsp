<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:set var="ctp" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>pdsList.jps</title>
	<jsp:include page="/include/bs4.jsp"/>
	<script>
		'use strict';
		
		//파트 선택시 해당 part만 불러오기
		function partCheck(){
			let part = partForm.part.value;
			location.href="${ctp}/PdsList.pds?part="+part;
		}
		
		//다운로드 횟수 증가처리(ajax)
		function downNumCheck(idx){
			$.ajax({
				type:"post",
				url : "${ctp}/PdsDownNumCheck.pds",
				data:{idx : idx},
				success : function(){
					location.reload();
				},
				error : function(){
					alert("오류발생");
				}
			})
		}
		
		//삭제처리 (ajax)
		function pdsDeleteCheck(idx,fSName){
			let ans = confirm("선택된 자료파일을 지우겠습니까?");
			if(!ans) return false;
			
			let pwd = prompt("비밀번호를 입력하세요.");
			let query={
					idx :idx,
					fSName : fSName,
					pwd : pwd
			}
			$.ajax({
				type : "post",
				url : "${ctp}/PdsDeleteCheck.pds",
				data : query,
				success : function(res){
					if(res=='1'){
						alert("삭제완료하였습니다.")
						location.reload();
					}
					else{
						alert("오류가 발생하여 제대로 삭제되지 않았습니다.")
					}
				},
				error : function(){
					alert("오류가 발생하여 값을 전송하지 못하였습니다.")
				}
				
			})
			
		}
		
		let t_idx = "";
		let t_fSName="";
		//모달 삭제 전 데이터 뿌려주기
		function setDeleteModalInfo(idx,fSName){
			t_idx = "";
			t_fSName=""; //값 초기화 후 세팅
			document.getElementById("deleteModalTitle").innerHTML = idx+"번"+fSName+"자료를 삭제합니다."; //제목 출력
			t_idx = idx;
			t_fSName= fSName;
		}
		
		
		//삭제처리(모달)
		function pdsDeleteCheck2(){
			let pwd = document.getElementById("deletePwd").value;
			let query={
					idx :t_idx,
					fSName : t_fSName,
					pwd : pwd
			}
			
			t_idx = "";
			t_fSName="";
			$.ajax({
				type : "post",
				url : "${ctp}/PdsDeleteCheck.pds",
				data : query,
				success : function(res){
					if(res=='1'){
						alert("삭제완료하였습니다.")
						location.reload();
					}
					else{
						alert("오류가 발생하여 제대로 삭제되지 않았습니다.")
					}
				},
				error : function(){
					alert("오류가 발생하여 값을 전송하지 못하였습니다.")
				}
				
			})
			
		}
		
	</script>
</head>
<body>
<jsp:include page="/include/header.jsp"/>
<p><br/></p>	
	<div class="container">
	<h2 class="text-center">자료실 리스트(${part})</h2>
	<br/>
	<table class="table table-bordered">
		<tr>
			<td style="width:20%" class="text-left">
				<form name="partForm">
					<select name="part" onchange="partCheck()" class="form-control">
						<option ${part=="전체"?"selected" :""}>전체</option>
						<option ${part=="학습"?"selected" :""}>학습</option>
						<option ${part=="여행"?"selected" :""}>여행</option>
						<option ${part=="음식"?"selected" :""}>음식</option>
						<option ${part=="음악"?"selected" :""}>음악</option>
						<option ${part=="영상"?"selected" :""}>영상</option>
					</select>
				</form>
			</td>
			<td class="text-right">
				<a href="${ctp}/PdsInput.pds?part=${part}" class="btn btn-success">자료 올리기</a>
			</td>
		</tr>
	</table>
	<table class="table table-hover table-bordered">
		<tr class="table-dark text-dark">
			<th>번호</th>
			<th>제목</th>
			<th>올린이</th>
			<th>업로드시간</th>
			<th>분류</th>
			<th>파일명</th>
			<th>다운로드수</th>
			<th>비고</th>
			<th>삭제</th>
		</tr>
		<c:forEach var="vo" items="${vos}" varStatus="st">
			<tr>
				<td>${vo.idx}</td>
				<td>${vo.title}</td> <!-- 게시판이랑 똑같이 new 표시. 타이틀에 달린 링크 클릭시 새창으로 표시(새 창에 내용을 멋지게 띄우기)>>이거 가능하면 mordal창에 띄우기 -->
				<td>${vo.nickName}</td>
				<td>${vo.fDate}</td>
				<td>${vo.part}</td>
				<td>
					<c:set var="fNames" value="${fn:split(vo.fName,'/')}"/>
					<c:set var="fSNames" value="${fn:split(vo.fSName,'/')}"/>
					<c:forEach var="fName" items="${fNames}" varStatus="st">
						<a href="${ctp}/images/pds/${fSNames[st.index]}" download="${fName}" onclick="downNumCheck(${vo.idx})">${fName}</a><br/>
					</c:forEach>
					(<fmt:formatNumber value="${vo.fSize/1024}" pattern="#,##0"/>KByte)
				</td>
				<td>${vo.downNum}</td>
				<td>${vo.fSName}</td>
				<td>
				<a href="${ctp}/PdsTotalDown.pds?idx=${vo.idx}" class="badge badge-info">전체다운로드</a><br/>
				<a href="javascript:pdsDeleteCheck('${vo.idx}','${vo.fSName}')" class="badge badge-danger">삭제</a>
				<button type="button" class="badge badge-warning" data-toggle="modal" data-target="#deleteModal" onclick="setDeleteModalInfo('${vo.idx}','${vo.fSName}')">삭제2</button>
				</td>
			</tr>
		</c:forEach>
		<tr><td colspan="8" class="m-0 p-0"></td></tr>
	</table>
	</div>
				<!-- 패스워드 모달로 받기 -->
				<!-- The Modal -->
					<div class="modal fade" id="deleteModal" name="deleteModal">
					  <div class="modal-dialog">
					    <div class="modal-content">
					      <!-- Modal Header -->
					      <div class="modal-header">
					        <h4 class="modal-title"><span name="deleteModalTitle" id="deleteModalTitle"></span></h4>
					        <button type="button" class="close" data-dismiss="modal">&times;</button>
					      </div>
					      <!-- Modal body -->
					      <div class="modal-body">
					        비밀번호 : 
					        <input type="password" name="deletePwd" id="deletePwd" placeholder="비밀번호를 입력해주세요." class="form-control"/>
					      </div>
					      <!-- Modal footer -->
					      <div class="modal-footer">
					        <button type="button" class="btn btn-success" onclick="pdsDeleteCheck2()" data-dismiss="modal">삭제</button>
					        <button type="button" class="btn btn-danger" data-dismiss="modal">취소</button>
					      </div>
					    </div>
					  </div>
					</div>
				 <!-- 모달 끝 -->
<p><br/></p>
<jsp:include page="/include/footer.jsp"/>
</body>
</html>