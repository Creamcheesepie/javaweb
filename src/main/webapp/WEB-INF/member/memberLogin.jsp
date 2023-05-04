<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctp" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>회원 로그인</title>
	<jsp:include page="/include/bs4.jsp"/>
</head>
<body>
<jsp:include page="/include/header.jsp"/>
<p><br/></p>	
	<div class="container">
	<div class="modal-dialog modal-lg">
		<h2 class="text-center">로그인</h2>
	
	<form name="myform" method="post" action="${ctp}/memberInputOk.mem" class="was-validated">
		<div class="form-group">
      <label for="mid">회원 아이디</label>
      <input type="text" class="form-control" name="mid" id="mid" placeholder="아이디를 입력하세요." value="${mid}" required autofocus>
      <div class="valid-feedback">잘하셨습니다~!</div>
      <div class="invalid-feedback">아이디을 입력해 주세요!</div>
    </div>
		<div class="form-group">
      <label for="pwd">비밀번호</label>
      <input type="password" class="form-control" id="pwd" name="pwd" placeholder="비밀번호를 입력하세요." required >
      <div class="valid-feedback">감사합니다~!</div>
      <div class="invalid-feedback">비밀번호를 입력해 주세요!</div>
    </div>
    <div class="form-group">
	    <button type="submit" class="btn btn-primary">로그인</button>
	    <button type="reset" class="btn btn-warning">리셋</button>
	    <button type="button" onclick="location.href='${ctp}/'" class="btn btn-danger">돌아가기</button>
	    <button type="button" onclick="location.href='${ctp}/MemberJoin.mem'" class="btn btn-danger">회원가입</button>
    </div>
    <div class="row">
    	<div class="col"><input type="checkbox" name="idsave" checked/>아이디저장</div>
    	<div class="col">
    		<a href="#">아이디찾기</a>
    		<a href="#">비밀번호찾기</a>
    	</div>
	</form>
	</div>
	</div>
<p><br/></p>
<jsp:include page="/include/footer.jsp"/>
</body>
</html>