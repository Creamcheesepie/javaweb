<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctp" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>title</title>
	<jsp:include page="/include/bs4.jsp"/>
	<script>
	'use strict'
	
	function nameCheck() {
		$("#myModal1").val();
		alert("성명 : " + name);
	}
	
	function fCheck(){
		let name = $("#myModal2 #name").val();
		let nickName = $("#myModal2 #nickName").val();
		let mid = $("#myModal2 #mid").val();
		let email = $("#myModal2 #email").val();
		alert("성명 :" +name+" || 닉네임 : "+nickName+" || 아이디 : "+mid+" || 이메일 : " + email);
	}
	
	</script>
</head>
<body>
<jsp:include page="/include/header.jsp"/>
<p><br/></p>	
	<div class="container">
		<!-- Button to Open the Modal -->
		<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal1">폼 내용 처리1</button>
		<button type="button" class="btn btn-secondary" data-toggle="modal" data-target="#myModal2">폼 내용 처리2</button>
		<a href="#" class="btn btn-info" data-toggle="modal" data-target="#myModal2">폼 내용 처릐3</a>
		<!-- The Modal -->
		<div class="modal" id="myModal1">
		  <div class="modal-dialog">
		    <div class="modal-content">
		
		      <!-- Modal Header -->
		      <div class="modal-header">
		        <h4 class="modal-title">폼 입력 연습</h4>
		        <button type="button" class="close" data-dismiss="modal">&times;</button>
		      </div>
		
		      <!-- Modal body -->
		      <div class="modal-body">
		      <form name="myform">
		        성명 : <input type="text" name="name" id="name" placeholder="성명을 입력하세요." class="form-control"/>
		        <input type="button" name="nameCheck" id="nameCheck" value="이름쳌!" onclick="nameCheck()"/>
		       </form>
		      </div>
		
		      <!-- Modal footer -->
		      <div class="modal-footer">
		        <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
		      </div>
		
		    </div>
		  </div>
		 </div>
		  
		  		<!-- The Modal2 -->
		<div class="modal" id="myModal2">
		  <div class="modal-dialog">
		    <div class="modal-content">
		
		      <!-- Modal Header -->
		      <div class="modal-header">
		        <h4 class="modal-title">폼 입력 연습2</h4>
		        <button type="button" class="close" data-dismiss="modal">&times;</button>
		      </div>
		
		      <!-- Modal body -->
		      <div class="modal-body">
		      <form name="myform">
		        성명 : <input type="text" name="name" id="name" value="${vo.name}" placeholder="성명을 입력하세요." class="form-control"/>
		        닉네임 : <input type="text" name="nickName" id="nickName" value="${sNickName}" placeholder="별명을 입력하세요." class="form-control"/>
		        아이디 : <input type="text" name="mid" id="mid" value="${sMid}" placeholder="아이디를 입력하세요." class="form-control"/>
		        이메일 : <input type="text" name="email" id="email" value="${vo.email}" placeholder="아이디를 입력하세요." class="form-control"/>
		        <input type="button" name="nameCheck" id="nameCheck" value="확인 쳌!" onclick="fCheck()" class="btn btn-success mt-2"/>
		       </form>
		      </div>
		      <!-- Modal footer -->
		      <div class="modal-footer">
		        <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
		      </div>
			    </div>
		  </div>
		</div>
	</div>
<p><br/></p>
<jsp:include page="/include/footer.jsp"/>
</body>
</html>