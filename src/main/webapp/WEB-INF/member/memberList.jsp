<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctp" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>회원 목록</title>
	<jsp:include page="/include/bs4.jsp"/>
	<script >
		//게시판에 올린 글 수 표시
		//회원 목록 페이징 처리 하기
		//준회원은 게시판 보기만 가능, 글쓰기는 불가능
		//mypage에서 정보 수정, 탈퇴만 가능하게 하기.(나머지 기능은 안보이게 처리하기.study 등등의 내용도 보여주게하지 않기.)
		//정회원 등업 조건 : 방명록에 5건 이상 글쓰기 (DB쿼리문 count 써서 처리하자.) and 방문횟수 10회 이상(이건 DB에 저장된 값 )
		//정회원 등업 버튼 추가?
		//정회원 사용 X : PDS(자료실)에 자료 올리기 막기 (앞으로 할거)
	</script>
</head>
<body>
<jsp:include page="/include/header.jsp"/>
<p><br/></p>	
	<div class="container">
		<h2>전체 회원 목록</h2>
		<br/>
		<table class="table table-hover text-center">
			<tr class="table-dark text-dark">
				<th>번호</th>
				<th>아이디</th>
				<th>별명</th>
				<th>성명</th>
				<th>성별</th>
			</tr>
			<c:forEach var="vo" items="${vos}" varStatus="se">
				<tr>
					<td>${vo.idx}</td>
					<td>${vo.mid}</td>
					<td>${vo.nickName}</td>
					<td>
					 <c:if test="${vo.userInfoSw =='공개'}">${vo.name}</c:if>
					 <c:if test="${vo.userInfoSw !='공개'}">부끄러워서 가린 사람입니다.</c:if>
					</td>
					<td>${vo.gender}</td>
				</tr>
			</c:forEach>
			<tr><td colspan="5"></td></tr>
		</table>
		
	</div>
<p><br/></p>
<jsp:include page="/include/footer.jsp"/>
</body>
</html>