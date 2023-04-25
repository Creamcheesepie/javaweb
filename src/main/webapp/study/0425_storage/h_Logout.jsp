<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	session.invalidate(); //현재 브라우저를 통해 저장된 세션을 전부 삭제
%>

<script>
	alert("로그아웃 하였습니다." );
	location.href="h_Main.jsp";
</script>