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
		
		function uuidCheck(){
			//ajax 처리해서 아래쪽의 demo에 출력하기.
			myform.submit();
		}
		
	</script>
</head>
<body>
<jsp:include page="/include/header.jsp"/>
<p><br/></p>	
	<div class="container">
	<form name="myform" method="post" action="${ctp}/Uuid.st" >
	<h2>UUID란?</h2>
		<p>
			UUID(universally unique identifier)는 네트워크 상의 고유성이 보장되는 id를 만들기 위한 규약<br/>
			128bit로 , 16진수 32자리로 표현된다.<br/>
			예 : ashj1234-au2q-9gvc-rm7d-as94l2jf94if
		</p>
		<p>
			<input type="button" value="UUID 생성" onclick="uuidCheck()" class="btn btn-success"/>
			<input type="button" value="다시하기" onclick="location.reload()" class="btn btn-warning"/>
		</p>
		<hr>
	</form>
	</div>
<p><br/></p>
<jsp:include page="/include/footer.jsp"/>
</body>
</html>