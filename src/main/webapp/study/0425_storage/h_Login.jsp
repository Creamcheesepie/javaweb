
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script>
'use strict'

<%
	Cookie[] cookies =request.getCookies();
	String mid = "";
	for(int i=0; i<cookies.length;i++){
		if(cookies[i].getName().equals("cMid")){
			mid=cookies[i].getValue();
			pageContext.setAttribute("mid", mid);
		}
		else{
			pageContext.setAttribute("mid", mid);
		}
	}
%>


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
		<div class="col"><input type="text" name="mid" id="mid" autofocus required value="${mid}"></div>
	</div>
	<div class="row">
		<div class="col">비밀번호 : </div>
		<div class="col"><input type="password" name="pwd" id="pwd" required></div>
	</div>
	<div class="row">
		<div class="col">아이디 저장</div>
		<div class="col"><input type="checkbox" name="idSave" id="idSave" value="saveOn"></div>
	</div>
	<div class="row">
		<div class="col"><button onclick="loginCheck()">로그인</button></div>
		<div class="col"><button type="reset">다시입력</button></div>
	</div>
</form>