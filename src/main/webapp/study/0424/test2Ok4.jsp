<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- 스크릿틀릿 대신에 jstl 사용 -->
<!-- 앞에서 전송된 값들을 VO에 담아보자. -->
<!-- jsp에서 객체를 사용하기 위해서는 해당 jsp액션태그(usebean)을 사용해서 객체를 생성해야한다. -->
<jsp:useBean id="vo" class="study.t0424.Test1VO"/>

<!-- 서블릿에서는 getter()와 setter()을 이용해서 값을 불러오거나 저장시켜준다.  -->
<!--jsp에서는 getProperty(getter())와 setProperty(setter())을 이용해서 값을 불러오거나 저장시켜준다. -->
<jsp:setProperty property="name" name="vo"/>
<jsp:setProperty property="age" name="vo"/>
<jsp:setProperty property="gender" name="vo" value="25"/>
<jsp:setProperty property="job" name="vo"/>
<jsp:setProperty property="address" name="vo"/>



<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>test2Ok4</title>
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
			<td><c:out value="${name}"></c:out><jsp:getProperty property="name" name="vo"></td>
			</tr>
			<tr>
			<th>나이</th>
			<%-- <td>${age}</td> --%>
			<c:out value="${age+1}"></c:out>
			<jsp:getProperty property="age" name="vo">
			</tr>
			<tr>
			<th>성별</th>
			<%-- <td>${gender}</td> --%>
			<c:out value="${gender}"></c:out>
			<jsp:getProperty property="gender" name="vo">
			</tr>
			<tr>
			<th>직업</th>
			<%-- <td>${job}</td> --%>
			<c:out value="${job}"></c:out>
			<jsp:getProperty property="job" name="vo">
			</tr>
			<tr>
			<th>주소</th>
			<%-- <td>${address}</td> --%>
			<c:out value="${address}"></c:out>
			<jsp:getProperty property="address" name="vo">
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