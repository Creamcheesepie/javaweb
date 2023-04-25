<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>form2</title>
	<jsp:include page="/include/bs4.jsp"/>
</head>
<body>
<p><br/></p>	
	<div class="container">
		<h2>값 여러개를 배열로 넘기는 연습하기~</h2>
		<form name="myform" method="post" action="${pageContext.request.contextPath}/t0427/el2Ok">
			<h2>자료 전송 연습</h2>
			<div>성명 : <input type="text" name="name" value="홍길동"/></div>
			<div>
				취미 : 
				<input type="checkbox" name="hobby" value="등산" >등산
				<input type="checkbox" name="hobby" value="공부" >공부
				<input type="checkbox" name="hobby" value="라이딩" >라이딩
				<input type="checkbox" name="hobby" value="수영" >수영
				<input type="checkbox" name="hobby" value="승마" >승마
				<input type="checkbox" name="hobby" value="바둑" >바둑
				<input type="checkbox" name="hobby" value="게임" >게임
			</div>
		<input type="submit" class="btn btn-success" value="입력">
		</form>
	</div>
<p><br/></p>
</body>
</html>