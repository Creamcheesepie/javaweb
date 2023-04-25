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
		<h2>이곳은 init에서 보낸 값을 찍어봅니다.</h2>
		<P>
		로고명 : ${logoName}<br/>
		홈페이지주소 : ${homeAddress}<br/>
		
		</P>
		<p>
		아이디 : ${iMid}<br/>
		비밀번호 : ${iPwd}
		</p>
	</div>
<p><br/></p>
</body>
</html>