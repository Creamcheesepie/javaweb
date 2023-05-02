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
	<div class="text-center">
		<h2>게시판</h2>
	</div>
	<div class="row">
		<div class="col"><button type="button" onclick="location.href='${ctp}/hsBoardWrite.pp'" class="btn btn-success">글작성</button></div>
	</div>	
	<div class="row text-center ">
		<div class="col-sm-2 bg-light">번호</div>
		<div class="col-sm-8 text-center bg-light">제목</div>
		<div class="col-sm-2 bg-light">작성자</div>
		<hr/>
	</div>
	<c:forEach var="vo" items="${vos}" varStatus="st">
		<div class="row text-center">
			<div class="col-sm-2">${vo.idx}</div>
			<div class="col-sm-8 text-center"><a href="${ctp}/hsBoardArticle.pp?title=${vo.title}">${vo.title}</a></div>
			<div class="col-sm-2">${vo.mid}</div>
			<hr/>
		</div>
	</c:forEach>
	</div>
<p><br/></p>
<jsp:include page="/include/footer.jsp"/>
</body>
</html>