<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctp" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<style>
th{ background-color='fff'};
</style>
<script type="text/javascript">
 function fCheck(){
	 myform.submit
 };
</script>
<head>
	<meta charset="UTF-8">
	<title>회원가입1(매핑)</title>
	<jsp:include page="/include/bs4.jsp"/>
</head>
<body>
<jsp:include page="/include/header.jsp"/>
<p><br/></p>	
	<div class="container">
		<h2>회원가입1(매핑)</h2>
		<form name="myform" method="post" action="${ctp}/joinOk.re">
			<table class="table">
			<tr>
				<th>아이디</th>
				<td><input type="text" name="mid" id="mid" class="form-control" required/></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="password" name="pwd" id="pwd" class="form-control" required/></td>
			</tr>
			<tr>
				<th>이름</th>
				<td><input type="text" name="name" class="form-control" required/></td>
			</tr>
			<tr>
				<td colspan="2" class="text-center">
					<input type="submit"  value="회원가입" class="btn btn-success mt2"/>
					<input type="reset" value="다시 입력"  class="btn btn-danger "/>
					<input type="button" value="돌아가기" onclick="location.href='${ctp}/javaweb;';" class="btn btn-warning"/>
				</td>
			</tr>
			</table>
		</form>
	</div>
<p><br/></p>
<jsp:include page="/include/footer.jsp"/>
</body>
</html>