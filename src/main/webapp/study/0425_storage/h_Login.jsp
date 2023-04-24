
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script>
'use strict'
window.onload = function(){
	Cookie[] cookies = request.getCookies();
	for(let i=0; i<cookies.length;i++){
		if(cookies[i].getName()==("cMid")){
			if(!(document.getElementById("cMid[i]").value)==""){
				document.getElementById("idSave").checked=true;
				document.getElementById("cMid").value = cookies[i].getValue();
			}
		}
	}
}

function idSave(mid){
	let tempMid=mid;
	if(document.getElementById("idSave").checked){
<%
	Cookie cookieMid = new Cookie("cMid",tempMid);
	cookieMid.setMaxAge(60*60*24*7);
	response.addCookie(cookieMid);
	%>
	}
	else{
		<%
		for(int i = 0; i<cookies.length; i++){
			if(cookies[i].getName().equals("cMid")){
				cookies[i].setMaxAge(0);
				response.addCookie(cookies[i]);
			}
		}
		%>
	}
}

function loginCheck(){
	let mid = loginform.mid.value.trim();
	let pwd = document.getElementById("mid").value.trim();
	
	if(mid == ""){
		alert("아이디를 입력하세요.");
		login.mid.focus();
	}
	else if(pwd == ""){
		alert("비밀번호를 입력하세요.");
		login.pwd.focus();
	}
	else{
		loginform.submit();
	}
}
</script>

<style>

</style>
<h2>login</h2>
<form name="loginform" method="post" action="<%=request.getContextPath()%>/t0424/H_LoginCheck">
	<div class="row">
		<div class="col">아이디 : </div>
		<div class="col"><input type="text" name="mid" id="mid" autofocus required></div>
	</div>
	<div class="row">
		<div class="col">비밀번호 : </div>
		<div class="col"><input type="password" name="pwd" id="pwd" required></div>
	</div>
	<div class="row">
		<div class="col">아이디 저장</div>
		<div class="col"><input type="checkbox" name="idSave" id="idSave"></div>
	</div>
	<div class="row">
		<div class="col"><button onclick="loginCheck()">로그인</button></div>
		<div class="col"><button type="reset">다시입력</button></div>
	</div>
</form>