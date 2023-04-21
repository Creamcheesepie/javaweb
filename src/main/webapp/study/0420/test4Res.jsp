<!-- test4Res.jsp -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>test4res</title>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.4/dist/jquery.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
  <!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script> -->
	<script>
	<%-- //location.href='<%=request.getContextPath()%>/study/0420/test4.jsp'; --%>
	alert("${name}님 자료가 저장되었습니다.")
	</script>
  <style>
  </style>
</head>

<body>
<p><br/></p>	
	<div class="container">
		<table class="table table=bordered">
			<tr>
				<td>성명 : </td>
				<td>${name}</td>
			</tr>
			<tr>
				<td>나이 : </td>
				<td>${age}</td>
			</tr>
			<tr>
				<td>성별 : </td>
				<td>${gender}</td>
			</tr>
			<tr>
				<td>취미 : </td>
				<td>${str}</td>
			</tr>
			<tr>
				<td>접속자Ip : </td>
				<td>${hostIp}</td>
			</tr>
		</table>
		<br/>
		<p class="text-center">
		<a href="<%=request.getContextPath()%>/study/0420/test4Out.jsp?name=${name}" class="btn btn-warning">로그아웃~~</a>
		<a href="<%=request.getContextPath()%>/study/0420/test4.jsp" class="btn btn-warning">돌아가자~</a>
		</p>
	</div>
<p><br/></p>
</body>
</html>
