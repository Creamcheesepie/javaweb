<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
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
	
	function searchCheck(){
		let searchString = $("#searchString").val();
		
		if(searchString.trim()==""){
			alert("찾고자 하는 검색어를 입력하세요!");
			searchFrom.searchString.focus();
		}
		else{
			searchForm.submit();
		}
		
		
		
	}
	</script>
</head>
<body>
<jsp:include page="/include/header.jsp"/>
<p><br/></p>	
	<div class="container">
		<h2 class="text-center">게시판 검색 결과</h2>
		<div>
			<font color="blue">${searchTitle}</font>(으)로 <font color="res">${searchString}</font>(을)를 검색한 결과 <font color="yellowgreen">${searchCnt}</font>건이 검색되었습니다.
		</div>
		<table class="table">
			<tr>
				<td><a href="${ctp}/BoardList.bo?nowPage=${nowPage}&pageSize=${pageSize}" class="btn btn-sm btn-info">돌아가기</a></td>
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
				<%-- <c:if test="${vo.openSw eq'ok'}"> --%>
					<tr>
						<td>${searchCnt}</td>
						<td>
							<c:if test="${vo.hour_diff<=24}"><img src="${ctp}/images/new.gif"/></c:if>
							<a href="${ctp}/BoardContent.bo?flag=search&search=${search}&searchString=${searchString}&idx=${vo.idx}&nowPage=${nowPage}&pageSize=${pageSize}">${vo.title}</a>
							<c:if test="${vo.hour_diff<=24}">&nbsp;<span class="badge badge-warning text-white">new!</span></c:if>
						</td>
						<td>${vo.nickName}</td>
						<td>
							<!-- 24시간 이내는 시간만 표시 이후는 날짜만 표시-->
							<!-- 단(24시간 안에 만족하는 자료),단 오늘날짜만 시간으로 표시하고,어제 날짜는 날짜로 표시하세요! -->
							<c:if test="${vo.date_diff==1}">
								<c:if test="${vo.hour_diff<=24}">${fn:substring(vo.wDate,0,10)}</c:if>
							</c:if>
							<c:if test="${vo.hour_diff<=24}">${fn:substring(vo.wDate,10,16)}</c:if>
							<c:if test="${vo.hour_diff>24}">${fn:substring(vo.wDate,0,10)}</c:if>	
							<!-- 선생님 방식 3항 비교
								<c:if test="${vo.hour_diff>24}">${fn:substring(vo.wDate,0,10)}</c:if>
								<c:if test="${vo.hour_diff <= 24}">
									${vo.date_diff==0?fn:substring(vo.wDate,11,19) : fn:substring(vo.wDate,11,19)}
								</c:if>
							 -->						
						</td>
						<td>${vo.readNum}</td>
						<td>${vo.good}</td>
					</tr>
					<c:set var="searchCnt" value="${searchCnt-1}"/>
				<%-- </c:if> --%>
			</c:forEach>
		</table>
		<!-- 블록페이지 -->
		<ul class="pagination text-center justify-content-center border-secondary pagination-sm">	
				<c:if test="${nowPage>1}"><li class="page-item"><a class="page-link text-secondary" href="${ctp}/BoardList.bo?pageSize=${pageSize}&nowPage=1">첫페이지</a></li></c:if>
				<c:if test="${curBlock>0}"><li class="page-item"><a class="page-link text-secondary" href="${ctp}/BoardList.bo?pageSize=${pageSize}&nowPage=${(curBlock-1)*blockSize+1}">이전블록</a></li></c:if>
				<c:forEach var="i" begin="${curBlock*blockSize+1}" end="${curBlock*blockSize + blockSize}" varStatus="st">
					<c:if test="${i<=totalPage && i== nowPage}"><li class="page-item active bg-secondary"><a class="page-link bg-secondary" href="#">${i}</a></li></c:if>
					<c:if test="${i<=totalPage && i!= nowPage}"><li class="page-item"><a class="page-link text-secondary" href="${ctp}/BoardList.bo?pageSize=${pageSize}&nowPage=${i}">${i}</a></li></c:if>
				</c:forEach>
				<c:if test="${curBlock<lastBlock}"><li class="page-item"><a class="page-link text-secondary" href="${ctp}/BoardList.bo?pageSize=${pageSize}&nowPage=${(curBlock+1)*blockSize+1}">다음블록</a></li></c:if>
				<c:if test="${nowPage<totalPage}"><li class="page-item"><a class="page-link  text-secondary" href="${ctp}/BoardList.bo?pageSize=${pageSize}&nowPage=${totalPage}">마지막페이지</a></li></c:if>
			</ul>
	</div>
	<br/>
	<!-- 검색 기능 -->
	<div class="container text-center">
		<form name="searchForm" method="post" action="${ctp}/BoardSearch.bo">
			<b>검색</b><br/>
			<select name="search">
				<option value="title" selected>글제목</option>
				<option value="nickName">글쓴이</option>
				<option value="content">글내용</option>
			</select>
			<input type="text" name="searchString" id="searchString"/>
			<input type="button" value="검색" onclick="searchCheck()" class="btn btn-success btn-sm"/>
			<input type="hidden" name="nowPage" value="${nowPage}"/>
			<input type="hidden" name="pageSize" value="${pageSize}"/>
		</form>
	</div>
<p><br/></p>
<jsp:include page="/include/footer.jsp"/>
</body>
</html>