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
		'use strict'
		
		function pwdCheck(idx){
			let pwd = myform.pwd.value.trim();
			myform.idx.value = idx;
			if(pwd =="" ){
				alert("비밀번호를 입력하세요");
				myform.pwd.focus();
			} 
			else{
				if(idx == 1){
					myform.action = "${ctp}/PassOk1.st";
				}
				else if(idx==2){
					myform.action = "${ctp}/PassOk1.st";
				}
				else if(idx==3){
					myform.action = "${ctp}/PassOk2.st";
				}
				myform.submit();
			}
			
		}
	</script>
</head>
<body>
<jsp:include page="/include/header.jsp"/>
<p><br/></p>	
	<div class="container">
		<h2>비밀번호 암호화 연습 (10자 이내)</h2>
		<hr>
		<form name="myform" method="post" >
			<table class="table table-bordered">
				<tr>
					<td>아이디</td>
					<td><input type="text" name="mid" id="mid" value="hkd1234" class="form-control"/></td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td><input type="password" name="pwd" id="pwd" maxlength="9" class="form-control"/></td>
				</tr>
				<tr>
					<td></td>
					<td>
					<input type="button" value="확인(숫자만)" onclick="pwdCheck(1)" class="btn btn-success"/>
					<input type="button" value="확인(숫자문자 혼합)" onclick="pwdCheck(2)" class="btn btn-primary"/>
					<input type="button" value="확인(SHA256)" onclick="pwdCheck(3)" class="btn btn-danger"/>
					</td>
				</tr>
				<input type="hidden" name="idx"/>
			</table>
		</form>
		<HR/>
		<h3>SHA(Secure Hash Algotith)</h3>
		<pre>
		SHA : 단방향식 암호화 기법? 암호학적 해쉬 함수들의 모임이다.
		      일반적으로 복호화 할 수 없도록 만든 알고리즘이 SHA-2라고 한다.
		      해시 함수가 출력하는 암축된 문장을 다이제스트(digest)라고 하는데,
		      이때 SHA-2가 생성해주는 다이제스트의 출력 길이는 256, 512(2진수 비트)가 있다.
		      이때 256bit의 출력길이를 가지는 SHA-2암호화를 'SHA-256 암호화 방식'이라고 칭한다.
		       
		</pre>
	</div>
<p><br/></p>
<jsp:include page="/include/footer.jsp"/>
</body>
</html>