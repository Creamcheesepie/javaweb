<!-- schedule -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<style>
	th{
	background-color:#eee;
	}
	th, td{text-align:center}
	
</style>
<script>
'use strict'
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
<hr/>
<h2>회원 로그인</h2>
<hr/>

<form name="loginform" method="post" action="<%=request.getContextPath()%>/t0421/LoginOk">
<table class="table table-bordered" style="width:500px; height:250px;" align="center">
	<tr>
		<th colspan="2" class="text-center">로그인</th>
	</tr>
	<tr>
		<th>아이디 : </th>
		<td><input type="text" name="mid" id="mid" class="form-control" autofocus /></td>
	</tr>
	<tr>
		<th>비밀번호 : </th>
		<td><input type="password" name="pwd" id="pwd" class="form-control"/></td>
	</tr>
	<tr>
		<th colspan="2" class="text-center">
		<!-- 로그인 버튼을 누르면 loginCheck 함수가 작동하여 프론트 검사를 함, 그리고 조건에 맞으면 submit으로 form의 데이터를 보냄.  -->
		<input type="button" value="로그인" onclick="loginCheck()" class="btn btn-success"/>
		<input type="reset" value="다시 입력" class="btn btn-success"/>
		<input type="button" value="홈으로" class="btn btn-info" onclick="location.href='Homework.jsp'"/>
		</th>
	</tr>
</table>
</form>
<hr/> 
<p></p>
