<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:set var="ctp" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>title</title>
	<jsp:include page="/include/bs4.jsp"/>
  <script>
  </script>
  <style>
  </style>
</head>

<body>
<jsp:include page="/include/header.jsp"/>
<p><br/></p>	
	<div class="container">
	<form name="BoardWrite" method="post" action="${ctp}/hsBoardWriteSubmit.pp">
		<div class="row" >
			<div class="col-sm-2">작성자 아이디</div>
			<div class="col-sm-2"><input type="text" name="mid" id="mid" value="${mid}" readonly/></div>
			<div class="col-sm-8"></div>
		</div>
		<div class="row" >
			<div class="col-sm-2">제목</div>
			<div class="col-sm-6"><input type="text" name="title" id="title" placeholder="제목을 입력해주세요." class="form-control"></div>
			<div class="col-sm-2">비밀번호</div>
			<div class="col-sm-2"><input type="text" name="deleteCode" id="deleteCode" placeholder="비밀번호4자리를 입력해 주세요." class="form-control"></div>
		</div>
		<div class="row">
			<div class="col text-center">내용</div>
		</div>
		<div class="row">
			<div class="col-sm-12"><textarea row="10" name="article" id="article" class="form-control" required></textarea></div>
		</div>
		<button type="submit" class="btn btn-primary">게시글 등록</button>
	    <button type="reset" class="btn btn-warning">다시 쓰기</button>
	    <button type="button" onclick="location.href='${ctp}/hsBoardList'" class="btn btn-danger">돌아가기</button>
	</form>
	</div>
<p><br/></p>
<jsp:include page="/include/footer.jsp"/>
</body>
</html>