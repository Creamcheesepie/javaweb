<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>title</title>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.4/dist/jquery.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
  <!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script> -->
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
</head>
<body>
<p><br/></p>	
	<div class="container">
<hr/>
<h2>회원 로그인</h2>
<hr/>
	<form name="loginform" method="post" action="test1Ok.jsp">
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
				<input type="button" value="로그인" onclick="loginCheck()" class="btn btn-success"/>
				<input type="reset" value="다시 입력" class="btn btn-success"/>
			</th>
		</tr>
	</table>
	</form>
<hr/> 
<p></p>
		
	</div>
<p><br/></p>
</body>
</html>