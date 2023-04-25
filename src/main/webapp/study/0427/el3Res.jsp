<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
		<h2>Arraylist에 등록된 자료 출력하기.</h2>
		<p>
			vos : ${vos}
		</p>
		<hr>
		<p>0.vo : ${vos[0]}</p>
		<p>1.vo : ${vos[2]}</p>
		<p>2.vo : ${vos[2]}</p>
		<hr/>
		<p></p>
		<p><a href="${pageContext.request.contextPath}/0427/el2.jsp"></p>
	</div>
<p><br/></p>
</body>
</html>