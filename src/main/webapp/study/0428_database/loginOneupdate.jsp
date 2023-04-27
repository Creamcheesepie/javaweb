<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctp" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>title</title>
	<jsp:include page="/include/bs4.jsp"/>
</head>
<body>
<p><br/></p>	
	<div class="container">
	<form name="myform" method="post" action="${ctp}/database/LoginOkOneUpdate">
	<div width="350px">
		<div class="row">
			<div class="col text-center">로그인</div>
		</div>
		<div class="row mt-3">
			<div class="col text-center">아이디</div>
			<div class="col"><input type="text" name="mid" id ="mid" autofocus class="form-control"></div>
		</div>
		<div class="row mt-3">
			<div class="col text-center">비밀번호</div>
			<div class="col"><input type="password" name="pwd" id ="pwd" class="form-control"></div>
		</div>
		<div class="row mt-3">
			<div class="col"><input type="submit" value="로그인" class="btn btn-success form-control"></div>
			<div class="col"><input type="reset" value="다시입력" class="btn btn-warning form-control"></div>
			<div class="col"><input type="button" value="회원가입" onclick="location.href='join.jsp';" class="btn btn-warning form-control"></div>
		</div>
	</div>	
	</form>		
	</div>
<p><br/></p>
<jsp:include page="/include/footer.jsp"/>
</body>
</html>