<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctp" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>title</title>
	<jsp:include page="/include/bs4.jsp"/>
	<jsp:include page="/include/memberCheck.jsp"/>
	<script>
	'use strict';
	function fCheck(){
		let title = myform.title.value;
		let content = myform.content.value;
		
		if(title.trim()==""){
			alert("게시글 제목을 입력하세요");
			myform.title.focus();
		}
		else if(content.trim()==""){
			alert("게시글 내용을 입력하세요");
			myform.title.focus();
		}
		else{
		myform.submit();
		}
	}
	</script>
</head>
<body>
<jsp:include page="/include/header.jsp"/>
<p><br/></p>	
	<div class="container">
		<h2>게시판 글 수정</h2>
		<form name="myform" method="post" action="${ctp}/BoardUpdateOk.bo">
			<table class="table table-bordered">
				<tr>
				<th>글쓴이</th>
				<td>${sNickName}</td>
				</tr>
				<tr>
				<th>글 제목</th>
				<td><input type="text" name="title" id="title" value="${vo.title}" required class="form-control"></td>
				</tr>
				<tr>
				<th>이메일</th>
				<td><input type="text" name="email" id="email" value="${vo.email}" class="form-control"></td>
				</tr>
				<tr>
				<th>홈페이지</th>
				<td><input type="text" name="homePage" id="homePage" value="${vo.homePage}" value="https://" class="form-control"></td>
				</tr>
				<tr>
				<th>글 내용</th>
				<td><textarea rows="8" name="content" id="content"  class="form-control" required>${vo.content}</textarea> </td>
				</tr>
				<tr>
				<th>공개여부</th>
				<td>
				<input type="radio" name="openSw" id="openSw" value="ok" checked <c:if test="${vo.openSw=='ok'}">checked</c:if>/>공개
				<input type="radio" name="openSw" id="openSw"  value="no" <c:if test="${vo.openSw=='no'}">checked</c:if>/>비공개
				</td>
				</tr>
				<tr>
					<td colspan="2" class="text-center">
						<input type="button" value="글 수정하기" onclick="fCheck()" class="btn btn-secondary;">
						<input type="reset" value="다시입력" class="btn btn-secondary;">
						<input type="button" value="돌아가기" onclick="location.href='${ctp}/BoardContent.bo?idx=${vo.idx}&nowPage=${nowPage}&pageSize=pageSize'" class="btn btn-secondary;">
					</td>
				</tr>
			</table>
			<input type="hidden" name="idx" value="${vo.idx}"/>
			<input type="hidden" name="nowPage" value="${nowPage}"/>
			<input type="hidden" name="pageSize" value="${pageSize}"/>
			<input type="hidden" name="hostIp" value="<%=request.getRemoteAddr()%>"/>
		</form>
	</div>
<p><br/></p>
<jsp:include page="/include/footer.jsp"/>
</body>
</html>