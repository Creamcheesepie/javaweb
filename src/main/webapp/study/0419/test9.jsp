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
  <script>
  </script>
  <style>
  </style>
</head>

<body>
<p><br/></p>	
	<div class="container">
		<h2>로그인~!</h2>
		<form name="myform" method="post" action="test9Ok.jsp">
		<div class="row" style="width:600px;">
			<div class="col" style="width:200px; text-align:center;">ID</div>
			<div class="col"><input type="text" name="mid" placeholder="아이디를 입력해 주세요." class="form-control"></div>
		</div>
		<div class="row" style="width:600px;">
			<div class="col" style="width:200px; text-align:center;">비밀번호</div>
			<div class="col"><input type="password" name="pwd" placeholder="비밀번호를 입력해 주세요." class="form-control"></div>
		</div>
		<div class="row" style="width:600px;">
		<div class="col"><input type="submit" value="로그인" class="btn btn-success form-control"/></div>
		<div class="col"><input type="reset" value="리셋" class="btn btn-warning form-control"/></div>
		</div>
		</form>
	</div>
<p><br/></p>
</body>
</html>