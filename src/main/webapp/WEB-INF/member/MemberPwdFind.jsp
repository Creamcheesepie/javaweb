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
		<h2>비밀번호 재설정</h2>
		<p>보안상의 이유로 비밀번호는 재설정 할 수 밖에 없습니다.</p>
		<form name="findmidform" method="post" action="${ctp}/MemberPwdFindOk.mem">
			<p>회원가입할 때 입력하신 아이디와 이메일을 정확히 입력해 주십시오.</p>
			<p>아이디 : <input type="text" name="mid" id="mid" required placeholder="아이디를 입력해 주세요."/></p>
			<p>이메일 : <input type="text" name="email" id="email" required placeholder="이메일을 입력해 주세요."/></p>
			<input type="submit" name="find" value="비밀번호 재설정"/>
		</form>
	</div>
<p><br/></p>
<jsp:include page="/include/footer.jsp"/>
</body>
</html>