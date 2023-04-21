<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>test2Res.jsp</title>
	<jsp:include page="/include/bs4.jsp"/>
</head>
<body>
<p><br/></p>	
	<div class="container">
		<h2>성적 처리 결과</h2>
		<P>이름 : ${vo.name}</P>
		<P>학번 : ${vo.hakbun}</P>
		<P>국어 : ${vo.kor}</P>
		<P>영어 : ${vo.eng}</P>
		<P>수학 : ${vo.mat}</P>
		<P>사회 : ${vo.soc}</P>
		<P>과학 : ${vo.sci}</P>
		<P>총점 : ${vo.sum}</P>
		<P>평균 : ${vo.avg}</P>
		<P>등급 : ${vo.grade}</P>
		<P><a href="<%=request.getContextPath()%>/study/0423/test1.jsp" class="btn btn-secondary">돌아가기</a></P>
	</div>
<p><br/></p>
</body>
</html>