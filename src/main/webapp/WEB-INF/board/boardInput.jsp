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
			alert("게시글 제목을 입력하세요");
			myform.title.focus();
		}
		myform.submit();
	}
	</script>
</head>
<body>
<jsp:include page="/include/header.jsp"/>
<p><br/></p>	
	<div class="container">
		<h2>게시판 글쓰기</h2>
		<form name="myform" method="post" action="${ctp}/BoardInputOk.bo">
			<table class="table table-bordered">
				<tr>
				<th>글쓴이</th>
				<td>${sMid}</td>
				</tr>
				<tr>
				<th>글 제목</th>
				<td><input type="text" name="title" id="title" placeholder="글제목을 입력하세요." required class="form-control"></td>
				</tr>
				<tr>
				<th>이메일</th>
				<td><input type="text" name="email" id="email" placeholder="이메일을 입력하세요." class="form-control"></td>
				</tr>
				<tr>
				<th>홈페이지</th>
				<td><input type="text" name="homePage" id="homePage" placeholder="홈페이지를 입력하세요." value="https://" class="form-control"></td>
				</tr>
				<tr>
				<th>글 내용</th>
				<td><textarea rows="8" name="content" id="content" placeholder="내용을 입력해주세요." class="form-control" required></textarea> </td>
				</tr>
				<tr>
				<th>공개여부</th>
				<td>
				<input type="radio"  value="OK" checked/>공개
				<input type="radio"  value="NO" />공개
				</td>
				</tr>
				<tr>
					<td colspan="2" class="text-center">
						<input type="button" value="글 작성" onclick="fCheck()" class="btn btn-secondary;">
						<input type="reset" value="다시입력" class="btn btn-secondary;">
						<input type="button" value="글 작성" onclick="location.href='${ctp}/BoardList.bo'" class="btn btn-secondary;">
					</td>
				</tr>
				
			</table>
			<input type="hidden" name="hostIp" value="<%=request.getRemoteAddr()%>"/>
		</form>
	</div>
<p><br/></p>
<jsp:include page="/include/footer.jsp"/>
</body>
</html>