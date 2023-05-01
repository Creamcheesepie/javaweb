<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctp" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>내 정보 변경</title>
	<jsp:include page="/include/bs4.jsp"/>
	
  <script>
  'use strict'
  
  function changeInfoTrim(){ 
  let pwd = document.getElementById("pwd").value.trim();
  let name = document.getElementById("name").value.trim();
  let nickName = document.getElementById("nickName").value.trim();
  
  changeInfoform.submit();
  }
  </script>
  <style>
  </style>
</head>

<body>
<jsp:include page="/include_study/study_header.jsp"/>

<div class="container" style="margin-top:30px">
	<div style="margin-top: 150px"></div>
	<form name="changeInfoform" method="post" action="${ctp}/hsMyInfoChange.hs">
	<div style="text-align: center"><h2>정보수정</h2></div>
	<div class="row mt-3">
		<div class="col-sm"></div>	
		<div class="col-sm-1" style="text-align: right">아이디</div>
		<div class="col-sm"><input type="text" name="mid" id="mid" class="form-control" value="${sLoginMid}" readonly></div>
		<div class="col-sm"></div>	
	</div>
	<div class="row mt-3">
		<div class="col-sm"></div>	
		<div class="col-sm-1" style="text-align: right">비밀번호</div>
		<div class="col-sm"><input type="password" name="pwd" id="pwd" class="form-control" placeholder="수정을 원하지 않으면 공백으로 두십시오."></div>
		<div class="col-sm"></div>	
	</div>
	<div class="row mt-3">
		<div class="col-sm"></div>	
		<div class="col-sm-1" style="text-align: right">성함</div>
		<div class="col-sm"><input type="text" name="name" id="name" class="form-control" placeholder="수정을 원하지 않으면 공백으로 두십시오."></div>
		<div class="col-sm"></div>	
	</div>
	<div class="row mt-3">
		<div class="col-sm"></div>	
		<div class="col-sm-1" style="text-align: right">닉네임</div>
		<div class="col-sm"><input type="text" name="nickName" id="nickName" class="form-control" placeholder="수정을 원하지 않으면 공백으로 두십시오."></div>
		<div class="col-sm"></div>	
	</div>
	<div class="row mt-3">
		<div class="col-sm"></div>	
		<div class="col-sm"></div>
		<div class="col-sm">
			<button type="button" class="btn btn-success" onclick="changeInfoTrim()">정보수정</button>
			<button type="button" class="btn btn-primary" onclick="location.href='${ctp}/hsMyInfo.hs'">돌아가기</button>
		</div>
		<div class="col-sm"></div>	
		<div class="col-sm"></div>
	</div>
	</form>
	<div style="margin-top: 250px"></div>

</div>

<jsp:include page="/include_study/study_footer.jsp"/>
</body>
</html>