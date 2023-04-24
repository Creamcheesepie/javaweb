<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
	session.invalidate(); //현재 브라우저를 통해 저장된 세션을 전부 삭제
%>

<script>
	alert("세션값 전부 삭제 완료" );
	location.href="t2_SessionMain.jsp";
</script>