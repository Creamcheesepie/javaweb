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
		<h2>그림파일 불러오기 연습</h2>
		<P>
			<img src="../../images/1.jpg" width="150px"/>
			<img src="<%=request.getContextPath() %>/images/1.jpg" width="150px"/>
			<hr/>
			<p>
			<% 
				for(int i=1; i<=6; i++){
					out.print("<img src='"+request.getContextPath()+"/images/"+i+".jpg'>");
				}
			%>
			</p>
		</P>
	</div>
<p><br/></p>
</body>
</html>