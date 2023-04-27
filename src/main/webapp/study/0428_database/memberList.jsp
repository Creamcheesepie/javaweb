<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:set var="ctp" value="${pageContext.request.contextPath}"/>
<jsp:include page="/include/memberCheck.jsp"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>memberList</title>
	<jsp:include page="/include/bs4.jsp"/>

</head>
<body>
<jsp:include page="/include/header.jsp"/>
<p><br/></p>	
	<div class="container">
		<h2>전체회원 리스트</h2>
		<table class="table table-hover">
			<tr class="table table-dark">
			<th>번호</th>
			<th>아이디</th>
			<c:if test="${sMid=='admin'}">
			<th>성명</th>
			<th>포인트</th>
			</c:if>
			<th>최종 방문일</th>
			<th>오늘 방문 횟수</th>
			</tr>
			<c:forEach var="vo" items="${vos}" varStatus="st">
				<tr>
					<td>${vo.idx}</td>			
					<td>${vo.mid}</td>
					<c:if test="${sMid=='admin'}">			
					<td>${vo.name}</td>			
					<td>${vo.point}</td>
					</c:if>		
					<td>${fn:substring(vo.lastDate,0,10)}</td>			
					<td>${todayCount}</td>			
				</tr>
			</c:forEach>
			<tr><td colspan="7" class="m-0 p-0"></td></tr>
		</table>
		<br/>
		<div>
			<a href="${ctp}/study/0428_database/memberMain.jsp" class="btn btn-success">돌아가기</a>
		</div>
	</div>
<p><br/></p>
<jsp:include page="/include/footer.jsp"/>
</body>
</html>