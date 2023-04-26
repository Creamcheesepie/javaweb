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
	<div class="container">
		<pre>
			String atom="Welcome to my homepage!"
			1.찾고자 하는 문자를 입력받는다,
			2. atom 변수에 포함된 문자 중, 3번째 위치를 찾아서 출려하시오.(출력시에너느 검색한 위치값을 모두 툴력할 것)
			단, 찾으려는 문자가 없으면 '검색문자 없음'을 출력하시오. 3번째 문자까지를 모두 검색했으면 더 이상 수행하지 않도록 프로그램을 제작하시오.
			+@ 다음 찾기 기능 추가?
			(JSTL위주 프로그래밍.)
		</pre>
	</div>
<p><br/></p>
</body>
</html>