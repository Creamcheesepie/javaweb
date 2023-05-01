<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctp" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>title</title>
	<jsp:include page="/include/bs4.jsp"/>
</head>
<body>
<p><br/></p>
<jsp:include page="/include/header.jsp"/>
	<div class="container">
		<h3>이곳은 Test3.jsp입니다.</h3>
		<a href="${ctp}/mapping/Test1" class="btn btn-primary">test1.jsp로 가기</a>
		<a href="${ctp}/mapping/Test2" class="btn btn-secondary">test2.jsp로 가기</a>
		<p>
		<img src="${ctp}/images/3.jpg" width="350px"/>
		</p>
	</div>
<p><br/></p>
<jsp:include page="/include/footer.jsp"/>
</body>
</html>