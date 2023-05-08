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
  
  function pwdReset(){
	  let pwd = pwdreset.pwd.value.trim();
	  const pwdRegEx = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[@$!%*#?&])[A-Za-z\d@$!%*#?&]{8,20}$/g;
	  
	  if(pwd==""){
			alert("비밀번호를 입력하세요!");
			pwdreset.pwd.focus();
			return false;
		}
		else if(!pwdRegEx.test(pwd)){
			alert("비밀번호는 영문 대소문자에 특수문자 1개 이상,8글자 이상으로 입력해주세요!");
			pwdreset.pwd.focus();
			return false;
		}else{
			pwdreset.submit();
		}
  }
  
  </script>
  <style>
  </style>
</head>

<body>
<jsp:include page="/include/header.jsp"/>
<p><br/></p>	
	<div class="container">
		<h2>비밀번호 재설정</h2>
			<p>${msg}</p>
		<c:if test="${findOk=='ok'}">
			<form name="pwdreset" method="post" action="${ctp}/MemberPwdReset.mem">
				<p>비밀번호 : <input type="password" name="pwd"/></p>
				<input type="button" value="재설정" onclick="pwdReset()"/>
				<input type="hidden" value="${mid}" name="mid"/>
				<input type="hidden" value="${email}" name="mid"/>
				<input type="hidden" value="${idx}" name="mid"/>
			</form>
		</c:if>
		<c:if test="${findOk=='no'}">
			<input type="button" value="돌아가기" onclick="location.href='${ctp}/MemberLogin.mem'"/>
		</c:if>
	</div>
<p><br/></p>
<jsp:include page="/include/footer.jsp"/>
</body>
</html>