<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>test4</title>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.4/dist/jquery.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
  <!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script> -->
  <script>
  'use strict'
  
  function fCheck(){
	  let name = myform.name.value.trim();
	  let age = document.getElementById("age").value;
	  
	  if(name==""){
		 	alert("성명을 입력하세요!");
		 	myform.name.focus();
	  }
	  else if(age<20){
		  alert("20세 이상만 가입하실 수 있습니다.")
		 	myform.age.focus();
	  }
	  else{
		  myform.submit();
	  }
  }
  </script>
  <style>
  	div{margin : 10px}
  </style>
</head>

<body>
<p><br/></p>	
	<div class="container">
		<h2>값전송 연습</h2>
		<form name="myform" method="post" action="<%=request.getContextPath()%>/t0420/Test4Ok">
			<div class="border">
				<div>성명 : <input type="text" name="name" id="name" value="hong gill dong" class="form-control"/></div>
				<div>나이 : <input type="number" name="age" id="age" value="25" class="form-control"/></div>
				<div>성별 : <input type="radio" name="gender" id="gender" value="남자" />남자<input type="radio" name="gender" value="여자"/>여자</div>
				<div>
					취미 : 
					<input type="checkbox" name="hobby" value="등산"/> 등산 &nbsp;
					<input type="checkbox" name="hobby" value="자전거"/> 자전거 &nbsp;
					<input type="checkbox" name="hobby" value="드라이빙"/> 드라이빙 &nbsp;
					<input type="checkbox" name="hobby" value="영화"/> 영화 &nbsp;
					<input type="checkbox" name="hobby" value="음악감상"/> 음악감상 &nbsp;
					<input type="checkbox" name="hobby" value="악기연주"/> 악기연주 &nbsp;
					<input type="checkbox" name="hobby" value="수영"/> 수영 &nbsp;
					<input type="checkbox" name="hobby" value="골프"/> 골프 &nbsp;
				</div>
			</div>
				<div class="text-center">
					<input type="button" value="전송" onclick="fCheck()" class="btn btn-success mt-3">
					<input type="reset" value="다시 입력" class="btn btn-warning mt-3">
				</div>
				<input type="hidden" name="hostIp" value="<%=request.getRemoteAddr()%>"/>
		</form>
	</div>
	
<p><br/></p>
</body>
</html>