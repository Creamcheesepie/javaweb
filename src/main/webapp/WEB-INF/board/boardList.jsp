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
	
	function pageCheck(){
		let pageSize = document.getElementById("pageSize").value;
		location.href="${ctp}/BoardList.bo?nowPage=${nowPage}&pageSize="+pageSize;
	}
	</script>
</head>
<body>
<jsp:include page="/include/header.jsp"/>
<p><br/></p>	
	<div class="container">
		<h2 class="text-center">게시판 리스트</h2>
		<table class="table table-borderless">
			<tr>
				<td><a href="${ctp}/BoardInput.bo" class="btn btn-primary btn-sm">글쓰기</a></td>
				<td>
					<select name="pageSize" id="pageSize" onchange="pageCheck()">
						<option <c:if test="${pageSize==5}">selected</c:if>>5</option>
						<option <c:if test="${pageSize==10}">selected</c:if>>10</option>
						<option <c:if test="${pageSize==15}">selected</c:if>>15</option>
						<option <c:if test="${pageSize==20}">selected</c:if>>20</option>
					</select>건 표시
				</td>
			</tr>
		</table>
		<table class="table table-hover text-center">
			<tr class="table-dark text-white">
				<th>글 번호</th>
				<th>글 제목</th>
				<th>작성자</th>
				<th>작성시간</th>
				<th>조회수</th>
				<th>추천수</th>
			</tr>
			<c:forEach var="vo" items="${vos}" varStatus="st">
				<tr>
					<td>${vo.idx}</td>
					<td>${vo.title}</td>
					<td>${vo.mid}</td>
					<td>${vo.wDate}</td>
					<td>${vo.readNum}</td>
					<td>${vo.good}</td>
				</tr>
			</c:forEach>
		</table>
		<!-- 블록페이지 -->
		<ul class="pagination text-center justify-content-center border-secondary">	
				<c:if test="${pag>1}"><li class="page-item"><a class="page-link text-secondary" href="${ctp}/BoardList.bo?pageSize=${pageSize}&nowPage=1">첫페이지</a></li></c:if>
				<c:if test="${curBlock>0}"><li class="page-item"><a class="page-link text-secondary" href="${ctp}/BoardList.bo?pageSize=${pageSize}&nowPage=${(curBlock-1)*blockSize+1}">이전블록</a></li></c:if>
				<c:forEach var="i" begin="${curBlock*blockSize+1}" end="${curBlock*blockSize + blockSize}" varStatus="st">
					<c:if test="${i<=totalPage && i== pag}"><li class="page-item active bg-secondary"><a class="page-link bg-secondary" href="#">${i}</a></li></c:if>
					<c:if test="${i<=totalPage && i!= pag}"><li class="page-item"><a class="page-link text-secondary" href="${ctp}/BoardList.bo?pageSize=${pageSize}&nowPage=${i}">${i}</a></li></c:if>
				</c:forEach>
				<c:if test="${curBlock<lastBlock}"><li class="page-item"><a class="page-link text-secondary" href="${ctp}/BoardList.bo?pageSize=${pageSize}&nowPage=${(curBlock+1)*blockSize+1}">다음블록</a></li></c:if>
				<c:if test="${pag<totalPage}"><li class="page-item"><a class="page-link  text-secondary" href="${ctp}/BoardList.bo?pageSize=${pageSize}&nowPage=${totalPage}">마지막페이지</a></li></c:if>
			</ul>
	
	</div>
<p><br/></p>
<jsp:include page="/include/footer.jsp"/>
</body>
</html>