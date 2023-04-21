<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>test3</title>
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
		<%
		int sum=0;
		for(int i=1; i<101; i++){
			sum+=i;
		}
		out.println("1~100까지의 합은 " + sum+"입니다.");
		%>
		<hr/>
		하나에서 백까지의 합은?? <%=sum %>입니당! <!-- 표현식은 이렇게 씁니당~ -->
		
	</div>
<p><br/></p>
</body>
</html>