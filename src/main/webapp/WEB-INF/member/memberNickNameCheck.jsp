<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctp" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>title</title>
	<jsp:include page="/include/bs4.jsp"/>
	<script>
		'use srict'
		
		function sendCheck(){
			opener.window.document.myform.nickName.value='${nickName}';
			opener.window.document.myform.name.focus();
			window.close();
		}
		
		function reInputCheck(){
			let nickName = recheckform.nickName.value;
			
			if(nickName.trim() ==""){
				alert("아이디를 입력하세요.")
			}
			else{
				recheckform.submit();
			}
		}
		
	</script>
</head>
<body>

<p><br/></p>	
	<div class="container">
		<h3>닉네임 중복 확인</h3>
			<c:if test="${res ==1 }">
				<h4>${nickName} 이 닉네임은 사용가능합니다.</h4>
				<p><input type="button" value="창닫기" onclick="sendCheck()"/></p>
			</c:if>
			<c:if test="${res ==0}">
				<h4>이 아이디는 이미 사용중인 닉네임입니다.</h4>
				<p><form name="recheckform" method="post" action="${ctp}/MemberNickNameCheck.mem"><input type="text" name="nickName" id="nickName" required placeholder="닉네임을 입력해 주세요"></form></p>
				<p><input type="button" value="다시 확인" onclick="reInputCheck()"/></p>
			</c:if>
	</div>
<p><br/></p>
</body>
</html>