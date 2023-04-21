<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>test8Post</title>
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
		<!-- <form name="myform" method="get" action="../../t8Get"> -->
		<form name="myform" method="post" action="../../t8Post">
		<div>성명 : 
			<input type="text" name="name" class="from-control mt-3">
		</div>
		<div>나이 : 
			<input type="number" name="age" class="from-control mt-3">
		</div>
		<div>
			<input type="submit" value="전송" class="btn btn-success mt-3">
		</div>
		</form>
	</div>
<p><br/></p>
</body>
</html>