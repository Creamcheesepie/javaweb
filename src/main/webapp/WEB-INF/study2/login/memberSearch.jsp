<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctp" value="${pageContext.request.contextPath}"/>
<jsp:include page="/include/memberCheck.jsp"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>title</title>
	<jsp:include page="/include/bs4.jsp"/>
	<script>
		'use strict'
		
		function deleteCheck() {
			let ans = confirm("정말 탈퇴하시겠습니까?");
			if(ans){
				location.href="${ctp}/database/DeleteOk";
			}
			
		}
	</script>
</head>
<body>
<p><br/></p>	
<jsp:include page="/include/header.jsp"/>
	<div class="container">
		<h2>개별회원 조회</h2>
		<table class="table table-borderd">
		<tr>
		<th>아이디</th>
		<td>${vo.mid}</td>
		</tr>
		<tr>
		<th>성명</th>
		<td>${vo.name}</td>
		</tr>
		<tr>
		<th>포인트</th>
		<td>${vo.point}</td>
		</tr>
		<tr>
		<th>최종방문일</th>
		<td>${vo.lastDate}</td>
		</tr>
		<tr>
		<th>오늘 방문횟수</th>
		<td>${vo.todayCount}</td>
		</tr>
		</table>
		<br/>
		<p>
			<a href="${ctp}/study/0428_database/memberMain.jsp" class="btn btn-success mr-3">돌아가기</a>
			<c:if test="${vo.mid == sMid }">
			<a href="${ctp}/database/Update" class="btn btn-success mr-3">정보수정</a>
			<a href="javascript:deleteCheck()" class="btn btn-success mr-3">회원탈퇴</a>
			</c:if>
	</div>
<p><br/></p>
<jsp:include page="/include/footer.jsp"/>
</body>
</html>