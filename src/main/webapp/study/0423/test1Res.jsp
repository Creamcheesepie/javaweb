<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>test1Res.jsp</title>
	<jsp:include page="/include/bs4.jsp"/>
</head>
<body>
<p><br/></p>	
	<div class="container">
		<h2>성적 처리 결과</h2>
		<P>이름 : ${name}</P>
		<P>학번 : ${hakbun}</P>
		<P>국어 : ${kor}</P>
		<P>영어 : ${eng}</P>
		<P>수학 : ${mat}</P>
		<P>사회 : ${soc}</P>
		<P>과학 : ${sci}</P>
		<P>총점 : ${sum}</P>
		<P>평균 : ${avg}</P>
		<P>등급 : ${grade}</P>
		<P><a href="<%=request.getContextPath()%>/study/0423/test1.jsp" class="btn btn-secondary">돌아가기</a></P>
	</div>
<p><br/></p>
</body>
</html>