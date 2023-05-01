<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctp" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>test5_3</title>
	<jsp:include page="/include/bs4.jsp"/>
</head>
<body>
<jsp:include page="/include/header.jsp"/>
<p><br/></p>	
	<div class="container">
		<h2>이곳은 test5_3.jsp 입니다.</h2>
		<P><img src="${ctp}/images/3.jpg" width="450px"/></P>
		<p>
			<a href="${ctp}/mapping/Test5.mi" class="btn btn-primary">test5호출</a>
			<a href="${ctp}/mapping/Test5_2.mi" class="btn btn-seccess">test5_2호출</a>
			<a href="${ctp}/mapping/Test5_4.mi" class="btn btn-secondary">test5_4호출</a>
			<a href="${ctp}/mapping/Test5_5.mi" class="btn btn-secondary">test5_4호출</a>
		</p>
	</div>
	<div>
			구구단 출력 ${dan}단<br/>
			${danOut}
		</div>
<p><br/></p>
<jsp:include page="/include/footer.jsp"/>
</body>
</html>