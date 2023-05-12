<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctp" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>회원 상세정보</title>
	<jsp:include page="/include/bs4.jsp"/>
</head>
<body>
<p><br/></p>	
	<div class="container">
		<h2>회원 상세 조회</h2>
		<h4>${vo.mid} (${vo.nickName}) 회원</h4>
		<table>
		<tr><td>고유 번호 : ${vo.idx}</td></tr>
		<tr><td>아이디 : ${vo.mid}</td></tr>
		<tr><td>닉네임 : ${vo.nickName}</td></tr>
		<tr><td>성명 : ${vo.name}</td></tr>
		<tr><td>성별 : ${vo.gender}</td></tr>
		<tr><td>생일 : ${vo.birthday}</td></tr>
		<tr><td>전화번호 : ${vo.tell}</td></tr>
		<tr><td>이메일 : ${vo.email}</td></tr>
		<tr><td>홈페이지 : ${vo.homePage}</td></tr>
		<tr><td>직업 : ${vo.job}</td></tr>
		<tr><td>취미 : ${vo.hobby}</td></tr>
		<tr><td>사진 : ${vo.photo}</td></tr>
		<tr><td>자기소개글 : ${vo.content}</td></tr>
		<tr><td>개인정보 공개유무 : ${vo.userInfoSw}</td></tr>
		<tr><td>탈퇴여부 : ${vo.userDel}</td></tr>
		<tr><td>포인트 : ${vo.point}</td></tr>
		<tr><td>등급 : ${strLevel}</td></tr>
		<tr><td>총 방문횟수 : ${vo.visitCnt}</td></tr>
		<tr><td>최초가입일 : ${vo.singInDate}</td></tr>
		<tr><td>마지막 접속일 : ${vo.lastDate}</td></tr>
		<tr><td>오늘 접속횟수 : ${vo.todayCnt}</td><tr>
		</table>
		<br/>
		<input type="button" value="돌아가기" onclick="history.back()" class="btn btn-warning"/>
	</div>
<p><br/></p>
</body>
</html>