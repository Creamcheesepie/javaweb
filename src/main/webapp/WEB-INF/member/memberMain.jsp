<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:set var="ctp" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>title</title>
	<jsp:include page="/include/bs4.jsp"/>
	<script>
		if(${sLevel == 1 }) alert("준회원입니다. 운영자 및 관리자의 승인이 있거나, 방명록에 게시글 5개 이상 작성하고 10번 이상 방문해주시면 자동으로 등업됩니다.")
		
		function chatInput(){
			let chat = $("#chat").val();
			
			if(chat.trim() != ""){
				$.ajax({
					type:"post",
					url:"${ctp}/MemberMessageInput.mem",
					data:{chat:chat},
					error : function(){
						alert("전송오류!");
					}
				});
			}
		}
		
		$(function(){
			$("#chat").on("keydown",function(e){
				if(e.keyCode == 13){
					chatInput();
				}
			})
		});
		
		
	</script>
</head>
<body>
<jsp:include page="/include/header.jsp"/>
<p><br/></p>	
	<div class="container">
	<h2>회원 전용방</h2>
	<hr/>
	<div class="row">
		<div class="col-sm-3">
			<p>${sNickName}님(${level}) 로그인 중이십니다.</p>
			<p>누적 포인트 : ${point}</p>
			<p>총 방문횟수 : ${visitCnt}</p>
			<p>오늘 방문 횟수 : ${todatCnt}</p>
			<p>회원사진 : <img src="${ctp}/images/member/${photo}" width="200px"></p>
		</div>
		<div class="col-sm-9">
		 	<h2 class="text-center">내 방명록 리스트</h2>
				<table class="table table-borderless mb-0 p-0">
						<tr>
							<td>
							<c:if test="${sAdmin != 'adminOk'}">
								<a href="${ctp}/AdminLogin.gu" class="btn btn-secondary btn-sm">관리자</a>
							</c:if>
							</td>
							<td style="text-align:right;"><a href="${ctp}/GuestInput.gu" class="btn btn-primary btn-sm">글쓰기</a></td>
						</tr>	
					</table>
					<table class="table table-borderless mb-0 p-0">
						<tr>
							<td class="text-left">
								<select name="pageSize" id="pageSize" onchange="pageCheck()">
									<option <c:if test="${pageSize==1}">selected</c:if>>1</option>
									<option <c:if test="${pageSize==3}">selected</c:if>>3</option>
									<option <c:if test="${pageSize==5}">selected</c:if>>5</option>
									<option <c:if test="${pageSize==10}">selected</c:if>>10</option>
								</select>건
							</td>
							<td class="text-right">
								<!--첫페이지 /이전페이지/현재페이지번호/총페이지수/다음페이지/마지막페이지 -->
								<c:if test="${pag>1}">
									<a href="${ctp}/MemberMain.mem?pageSize=${pageSize}&pag=${1}">◁◁</a>
									<a href="${ctp}/MemberMain.mem?pageSize=${pageSize}&pag=${pag-1}">◀</a>
								</c:if>
								${pag}/${totalPage}
								<c:if test="${pag<totalPage}">
									<a href="${ctp}/MemberMain.mem?pageSize=${pageSize}&pag=${pag+1}">▶</a>  
									<a href="${ctp}/MemberMain.mem?pageSize=${pageSize}&pag=${totalPage}">▷▷</a>
								</c:if>						
							</td>
						</tr>
					</table>
					
				<c:forEach var="vo" items="${vos}" varStatus="st">
					<table class="table table-borderless mb-0">
						<tr>
							<td>
							번호 : ${curScrStartNo}
							<c:set var="curScrStartNo" value="${curScrStartNo-1}"/>
							<c:if test="${sAdmin == 'adminOk'}"><a href="javascript:delCheck(${vo.idx})" class="btn btn-danger">삭제</a></c:if>
							
							</td>
							<td style="text-align:right;">방문IP : ${vo.hostIp}</td>
						</tr>
					</table>
					<table class="table bordered mt-0">
						<tr>
							<th style="20%">성명</th>
							<td style="25%">${vo.name}</td>
							<th style="20%">방문일자</th>
							<td style="35%">${fn:substring(vo.visitDate,0,19)}</td>
						</tr>
						<tr>
							<th>메일주소</th>
							<td colspan="3">
				        <c:if test="${empty vo.email || fn:length(vo.email)<5 || fn:indexOf(vo.email,'@')==-1 || fn:indexOf(vo.email,'.')==-1}">- 없음 -</c:if>
				        <c:if test="${!empty vo.email && fn:length(vo.email)>=5 && fn:indexOf(vo.email,'@')!=-1 && fn:indexOf(vo.email,'.')!=-1}">${vo.email}</c:if>
			      	</td>
						</tr>
						<tr>
							<th>홈페이지</th>
							<td colspan="3">
								<c:if test="${empty vo.homePage || fn:length(vo.homePage)<10 || fn:indexOf(vo.homePage,'https://')==-1 || fn:indexOf(vo.homePage,'.')==-1}">- 없음 -</c:if>
								<c:if test="${!empty vo.homePage && fn:length(vo.homePage)>=10 && fn:indexOf(vo.homePage,'hppts://')!=-1 && fn:indexOf(vo.homePage,'.')!=-1}">${vo.homePage}</c:if>
							</td>
						</tr>
						<tr>
							<th>방문소감</th>
							<td colspan="3">${fn:replace(vo.content,newLine,'<br/>')}</td>
						</tr>
					</table>
				</c:forEach>
				<br/>
				<!-- 처음 페이지 < 이전블록 < 1(4) 2(5) 3(6) > 다음블록 > 마지막 페이지 -->
				<div class="text-center">
					<ul class="pagination text-center justify-content-center border-secondary">	
						<c:if test="${pag>1}"><li class="page-item"><a class="page-link text-secondary" href="${ctp}/MemberMain.mem?pageSize=${pageSize}&pag=1">첫페이지</a></li></c:if>
						<c:if test="${curBlock>0}"><li class="page-item"><a class="page-link text-secondary" href="${ctp}/MemberMain.mem?pageSize=${pageSize}&pag=${(curBlock-1)*blockSize+1}">이전블록</a></li></c:if>
						<c:forEach var="i" begin="${curBlock*blockSize+1}" end="${curBlock*blockSize + blockSize}" varStatus="st">
							<c:if test="${i<=totalPage && i== pag}"><li class="page-item active bg-secondary"><a class="page-link bg-secondary" href="#">${i}</a></li></c:if>
							<c:if test="${i<=totalPage && i!= pag}"><li class="page-item"><a class="page-link text-secondary" href="${ctp}/MemberMain.mem?pageSize=${pageSize}&pag=${i}">${i}</a></li></c:if>
						</c:forEach>
						<c:if test="${curBlock<lastBlock}"><li class="page-item"><a class="page-link text-secondary" href="${ctp}/MemberMain.mem?pageSize=${pageSize}&pag=${(curBlock+1)*blockSize+1}">다음블록</a></li></c:if>
						<c:if test="${pag<totalPage}"><li class="page-item"><a class="page-link  text-secondary" href="${ctp}/MemberMain.mem?pageSize=${pageSize}&pag=${totalPage}">마지막페이지</a></li></c:if>
					</ul>
				</div>
		</div>	
		<!-- 실시간 대화내용 확인하기 -->
		<div style="width:460px">
			<form name="shatform">
				<label for="chat"><b>실시간 대화방</b></label>
				<iframe src="${ctp}/include/memberMessage.jsp" class="border" width="100%" height="200px">
				</iframe>
				<div class="input-group mb-1">
					<input type="text" class="form-control" name="chat" id="chat"  placeholder="내용을 입력하세요">
					<div class="input-group-append">
						<input type="button" value="글 등록" onclick="chatInput()" class="btn btn-success">
					</div>
				</div>
			</form>
		</div>
		
	</div>
		
	</div>
<p><br/></p>
<jsp:include page="/include/footer.jsp"/>
</body>
</html>