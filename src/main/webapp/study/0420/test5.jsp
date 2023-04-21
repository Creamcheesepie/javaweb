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
		<h2>수를 입력해 주세용~~</h2>
		<form name="myform" method="post" action="<%=request.getContextPath() %>/t0420/SuControl">
		<div>
			su1 : 
			<input type="text" name="su">
		</div>
		<div>
			su2 : 
			<input type="text" name="su">
		</div>
		<div>
			su3 : 
			<input type="text" name="su">
		</div>
		<div>
			su4 : 
			<input type="text" name="su">
		</div>
		<div>
			su5 : 
			<input type="text" name="su">
		</div>
		<div>
			<button type="submit">전송</button>
		</div>
		</form>
	</div>
<p><br/></p>
</body>
</html>