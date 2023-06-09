<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- 스크릿틀릿 대신에 jstl 사용 -->
<!-- 앞에서 전송된 값들을 변수에 담아보자. -->
<c:set var="name" value="${param.nane}"/>
<c:set var="age" value="${param.age}"/>
<c:set var="gender" value="${param.gender}"/>
<c:set var="job" value="${param.job}"/>
<c:set var="address" value="${param.address}"/>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>test2Ok2</title>
	<jsp:include page="/include/bs4.jsp"/>
</head>
<body>
<p><br/></p>	
	<div class="container">
		<h2>처리된 자료를 view에 출력시켜본다.</h2>
		<div>
			<table class="table table-bordered">
			<tr>
			<th>성명</th>
			<%-- <td>${name}</td> --%>
			<td><c:out value="${name}"></c:out></td>
			</tr>
			<tr>
			<th>나이</th>
			<%-- <td>${age}</td> --%>
			<c:out value="${age+1}"></c:out>
			</tr>
			<tr>
			<th>성별</th>
			<%-- <td>${gender}</td> --%>
			<c:out value="${gender}"></c:out>
			</tr>
			<tr>
			<th>직업</th>
			<%-- <td>${job}</td> --%>
			<c:out value="${job}"></c:out>
			</tr>
			<tr>
			<th>주소</th>
			<%-- <td>${address}</td> --%>
			<c:out value="${address}"></c:out>
			</tr>
			<tr>
				<a href="test2.jsp" class="btn btn-warning">돌아가기</a>
			</tr>
			</table>
		</div>
	</div>
<p><br/></p>
</body>
</html>