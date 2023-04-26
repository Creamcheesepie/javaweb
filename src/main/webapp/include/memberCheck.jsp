<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctp" value="${pageContext.request.contextPath}"/>

<%
	String memberCheckId = session.getAttribute("sMid")==null?"" : (String)session.getAttribute("sMid");
	if(memberCheckId.equals("")){%>
	<script>
	location.href="${ctp}/study/0428_database/login.jsp";
	</script>
<% } //아이디를 다른 프로그램에서 쓰게 될 때 include 하게 되면 변수가 중복될 수 있어서 되지 않게 조심해야한다. %>