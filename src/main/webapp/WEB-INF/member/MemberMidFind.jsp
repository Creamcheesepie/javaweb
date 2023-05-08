<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:set var="ctp" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>title</title>
	<jsp:include page="/include/bs4.jsp"/>
  <script>
  </script>
  <style>
  </style>
</head>

<body>
<jsp:include page="/include/header.jsp"/>
<p><br/></p>	
	<div class="container">
		<h2>아이디 찾기</h2>
		<form name="findmidform" method="post" action='${ctp}/MemberMidFindOk.mem'>
			<p>회원가입할 때 입력하신 이메일을 정확히 입력해 주십시오.</p>
			<input type="text" name="email" id="email" required placeholder="이메일을 입력해 주세요."/>
			<input type="submit" name="find" value="아이디 찾기"/>
		</form>
	</div>
<p><br/></p>
<jsp:include page="/include/footer.jsp"/>
</body>
</html>