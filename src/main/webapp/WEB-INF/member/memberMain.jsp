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
</head>
<body>
<jsp:include page="/include/header.jsp"/>
<p><br/></p>	
	<div class="container">
	<h2>회원 전용방</h2>
	<hr/>
	<div>
	<p>${sNickName}님(${level}) 로그인 중이십니다.</p>
	<p>누적 포인트 : ${point}</p>
	<p>총 방문횟수 : ${visitCnt}</p>
	<p>오늘 방문 횟수 : ${todatCnt}</p>
	<p>회원사진 : <img src="${ctp}/images/member/${photo}" width="200px"></p>
	</div>
		
	</div>
<p><br/></p>
<jsp:include page="/include/footer.jsp"/>
</body>
</html>