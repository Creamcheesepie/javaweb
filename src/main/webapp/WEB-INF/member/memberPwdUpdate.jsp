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
			
			let oldPwd = document.getElementById("oldPwd").value;
			let newPwd = document.getElementById("newPwd").value;
			let rePwd = document.getElementById("rePwd").value;
			
			if(oldPwd.trim()==""){
				alert("기존 비밀번호를 입력하세요!");
				document.getElementByID("oldPwd").focus();
			}
			else if(newPwd.trim()==""){
				alert("변경할 비밀번호를 입력하세요");
				document.getElementByID("newPwd").focus();
			}
			else if(oldPwd.trim()==""){
				alert("확인 비밀번호를 입력하세요!");
				document.getElementByID("rePwd").focus();
			}
			else if(!pwdRegEx.test(newPwd)){
				alert("비밀번호는 영문대소문자, 숫자에 필수로 특수문자 1개 이상은 포함되어야 합니다. 사용가능한 특수문자는 @$!%*#?& 입니다.")
			}
			else if(newPwd!=rePwd){
				alert("새 비밀번호와 동일한 비밀번호를 입력해주세용");
				document.getElementByID("rePwd").focus();
			}
			else if(newPwd == oldPwd){
				alert("기존 비밀번호와 신규 비밀번호는 동일하면 안됩니다.");
				document.getElementByID("newPwd").focus();
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
		<form name="myform" method="post" action="${ctp}/MemberPwdUpdateOk.mem" class="was-validated">
			<h2>비밀번호 변경</h2>
			<br/>
			<table class="table table-bordered">
				<tr>
					<th>기존 비밀번호</th>
					<td>
						<input type="password" name="oldPwd" id="oldPwd" autofocus required class="form-control" placeholder="기존 비밀번호를 입력하세요."/>
						<div class="invalid-feedback">기존 비밀번호를 입력하세요.</div>
					</td>
				</tr>
				<tr>
					<th>새 비밀번호</th>
					<td>
						<input type="password" name="newPwd" id="newPwd" autofocus required class="form-control" placeholder="새 비밀번호를 입력하세요."/>
						<div class="invalid-feedback">변경할 비밀먼호를 입력하세요.</div>
					</td>
				</tr>
				<tr>
					<th>비밀번호 확인</th>
					<td>
						<input type="password" name="rePwd" id="rePwd" autofocus required class="form-control" placeholder="다시한번 비밀번호를 입력하세요."/>
						<div class="invalid-feedback">다시한번 비밀번호를 입력하세요.</div>
					</td>
				</tr>
				<tr>
					<td colspan="2" class="text-center">
						<input type="button" onclick="fCheck()" class="btn btn-success mr-2" value="비밀번호 변경"/>
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