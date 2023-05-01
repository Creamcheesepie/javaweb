<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctp" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>test5_4</title>
	<jsp:include page="/include/bs4.jsp"/>
</head>
<body>
<jsp:include page="/include/header.jsp"/>
<p><br/></p>	
	<div class="container">
		<h2>이곳은 test5_4.jsp 입니다.</h2>
		<P><img src="${ctp}/images/4.jpg" width="450px"/></P>
			<a href="${ctp}/mapping/Test5.mi" class="btn btn-seccess">test5호출</a>
			<a href="${ctp}/mapping/Test5_2.mi" class="btn btn-seccess">test5_2호출</a>
			<a href="${ctp}/mapping/Test5_3.mi" class="btn btn-secondary">test5_3호출</a>
			<a href="${ctp}/mapping/Test5_5.mi" class="btn btn-secondary">test5_5호출</a>
		</p>
		<hr/>
			메세지 : ${msg}
	</div>
<p><br/></p>
<jsp:include page="/include/footer.jsp"/>
</body>
</html>