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
		<h2>넘어온 값 출력</h2>
		<div>이름 : ${name}</div>
		<%
			//String[] hobbys = request.getParameterValues("hobbys");
			//String hobby="";
			//for(int i=0; i<hobbys.length;i++){
			//	hobby += hobbys[i]+"/";
			//	request.setAttribute("hobby", hobby);
			//}
		%>
		<div>취미 : ${hobbys[0]},${hobbys[1]}</div>
	</div>
<p><br/></p>
</body>
</html>