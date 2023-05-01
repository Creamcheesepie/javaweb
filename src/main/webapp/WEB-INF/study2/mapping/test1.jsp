<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctp" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>test1</title>
	<jsp:include page="/include/bs4.jsp"/>
</head>
<body>
<jsp:include page="/include/header.jsp"/>
<p><br/></p>	
	<div class="container">
		<h2>이곳은 /WEB-INF/study2/mapping/test1.jsp입니다.</h2>
		<p>
			<a href="${ctp}/mapping/Test2" class="btn btn-secondary">test2.jsp로 가기</a>
			<a href="${ctp}/mapping/Test3" class="btn btn-success">test3.jsp로 가기</a>
			<a href="${ctp}/mapping/Test4?su1=100&su2=50" class="btn btn-warning">test4.jsp로 가기</a>
		</p>
		<p>
			<div>두 수의 합 : ${hap}</div>
			<div>두 수의 차 : ${cha}</div>
		</p>
		<p>
			<img src="${ctp}/images/1.jpg" width="350px"/>
		</p>
	</div>
<p><br/></p>
<jsp:include page="/include/footer.jsp"/>
</body>
</html>