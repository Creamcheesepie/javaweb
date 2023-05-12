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
		'use strict';
		
		function fCheck(){
			let pwdRegEx = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[@$!%*#?&])[A-Za-z\d@$!%*#?&]{8,20}$/g;
			
			let pwd = document.getElementById("pwd").value;

			
			if(pwd.trim()==""){
				alert("비밀번호를 입력하세요!");
				document.getElementByID("pwd").focus();
			}
			else{
				myform.submit();
			}
			
			
			
			
		}
	</script>
</head>
<body>
<jsp:include page="/include/header.jsp"/>
<p><br/></p>	
	<div class="container">
		<form name="myform" method="post" action="${ctp}/MemberPwdCheckOk.mem" class="was-validated">
			<h2>비밀번호 확인</h2>
			<br/>
			<table class="table table-bordered">
				<tr>
					<th>비밀번호</th>
					<td>
						<input type="password" name="pwd" id="pwd" autofocus required class="form-control" placeholder="기존 비밀번호를 입력하세요."/>
						<div class="invalid-feedback">비밀번호를 입력하세요.</div>
					</td>
				</tr>
				<tr>
					<td colspan="2" class="text-center">
						<input type="button" onclick="fCheck()" class="btn btn-success mr-2" value="비밀번호 확인"/>
						<input type="reset"  class="btn btn-success mr-2" value="다시 입력"/>
						<input type="button" onclick="location.href='${ctp}/MemberMain.mem'" class="btn btn-success mr-2" value="돌아가기"/>
					</td>
				</tr>
			</table>
		</form>
	</div>
<p><br/></p>
<jsp:include page="/include/footer.jsp"/>
</body>
</html>