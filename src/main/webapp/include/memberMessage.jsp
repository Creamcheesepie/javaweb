<%@page import="java.util.ArrayList"%>
<%@page import="member.MemberDAO"%>
<%@page import="member.MemberChatVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% 
request.setCharacterEncoding("utf-8");
MemberDAO dao = new MemberDAO();
ArrayList<MemberChatVO> vos = dao.getMemberMessage();
pageContext.setAttribute("vos", vos);

%>
<c:set var="ctp" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>title</title>
	<jsp:include page="/include/bs4.jsp"/>
	<script>
		setTimeout("location.reload()",1000); //1초에 한번 메세지창 새로고침
		$(document).ready(function(){
			document.body.scrollIntoView(false); //스크롤바를 강제로 바디 태그의 마지막으로 위치시켜준다
			
		});
	</script>
</head>
<body>
	<div class="container mt-1">
		<c:forEach var="vo" items="${vos}" varStatus="st">
		<c:if test="${sNickName==vo.nickName}"><font color="blue">${vo.chat}</font></c:if>
		<c:if test="${sNickName!=vo.nickName}">${vo.chat}</c:if>
			<br/>
		</c:forEach>
	</div>
</body>
</html>