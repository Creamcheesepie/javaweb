<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctp" value="${pageContext.request.contextPath}"/>

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