<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctp" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>adminMain</title>
	<frameset cols="130px, *">
		<frame src="${ctp}/AdminLeft.ad" name="adminLeft" frameborder="0"/>
		<frame src="${ctp}/AdminContent.ad" name="adminContent" frameborder="0"/>
	</frameset>
	<script>
		//프로젝트 일주일 남음  >> 일정 예약하기 다음중에
		//숙제 >> 관리자 전체 회원 리스트에 각 가로줄마다 체크박스를 추가하고 그 체크 사항에 따라 일괄변경 기능 구현
		//
		//개인 과제 >> 탈퇴유무에서 정지회원 지정 후 제약 걸기
		//개인 과제 >> 회원 등급별 조회 기능 추가?
		//개인 과제 >> 운영자 게시판 리스트 구현?
		//
	</script>
</head>

</html>