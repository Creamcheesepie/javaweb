<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctp" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>title</title>
	<jsp:include page="/include/bs4.jsp"/>
	
  <script>
  'use strict'
  function signInCheck(){
	  let mid = document.getElementById("mid").value.trim();
	  let pwd = document.getElementById("pwd").value.trim();
	  let name = document.getElementById("name").value.trim();
	  let nickName = document.getElementById("nickName").value.trim();
	  
	  if(mid==""){
		  alert("아이디를 입력해 주세요. 공백으로만 채우셔도 안됩니다.");
		  document.getElementById("mid").focus();
	  }
	  else if(pwd==""){
		  alert("비밀번호를 입력해 주세요. 공백으로만 채우셔도 안됩니다.");
		  document.getElementById("pwd").focus();
	  }
	  else if(name==""){
		  alert("성함을 입력해 주세요. 공백으로만 채우셔도 안됩니다.");
		  document.getElementById("name").focus();
	  }
	  else if(nickName==""){
		  alert("별명을 입력해 주세요. 공백으로만 채우셔도 안됩니다.");
		  document.getElementById("nickName").focus();
	  }
	  else{
		  signinform.submit();
	  }
  }
  </script>
  <style>
  </style>
</head>

<body>
<jsp:include page="/include_study/study_header.jsp"/>

<div class="container" style="margin-top:30px">
	<div style="margin-top: 150px"></div>
	<form name="signinform" method="post" action="${ctp}/s0429/SigninCheck">
	<div style="text-align: center"><h2>회원가입</h2></div>
	<div class="row">
		<div class="col-sm"></div>	
		<div class="col-sm-1" style="text-align: right">아이디</div>
		<div class="col-sm"><input type="text" name="mid" id="mid" class="form-control" autofocus></div>
		<div class="col-sm"></div>	
	</div>
	<div class="row mt-3">
		<div class="col-sm"></div>	
		<div class="col-sm-1" style="text-align: right">비밀번호</div>
		<div class="col-sm"><input type="password" name="pwd" id="pwd" class="form-control"></div>
		<div class="col-sm"></div>	
	</div>
	<div class="row mt-3">
		<div class="col-sm"></div>	
		<div class="col-sm-1" style="text-align: right">성함</div>
		<div class="col-sm"><input type="text" name="name" id="name" class="form-control" autofocus></div>
		<div class="col-sm"></div>	
	</div>
	<div class="row mt-3">
		<div class="col-sm"></div>	
		<div class="col-sm-1" style="text-align: right">닉네임</div>
		<div class="col-sm"><input type="text" name="nickName" id="nickName" class="form-control" autofocus></div>
		<div class="col-sm"></div>	
	</div>
	<div class="row mt-3">
		<div class="col-sm"></div>	
		<div class="col-sm"></div>
		<div class="col-sm"><button type="button" class="btn btn-primary" onclick="signInCheck()">회원가입</button></div>
		<div class="col-sm"></div>	
		<div class="col-sm"></div>
	</div>
	</form>
	<div style="margin-top: 250px"></div>

</div>

<jsp:include page="/include_study/study_footer.jsp"/>
</body>
</html>