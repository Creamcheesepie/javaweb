<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
	session.removeAttribute("sMid");
	session.removeAttribute("sName");
%>


<script>
	alert("세션값 중 mid,name 삭제 완료" );
	location.href="t2_SessionMain.jsp";
</script>