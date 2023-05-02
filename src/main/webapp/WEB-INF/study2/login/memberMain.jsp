<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:set var="ctp" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>memberMain.jsp</title>
	<jsp:include page="/include/bs4.jsp"/>
	<script>
		'use stirct';
		
		function searchCheck(){
			let temp = '';
			temp+='검색할 아이디 : ';
			temp+='<input type="text" name="searchMid" id="searchMid"/>';
			temp+='<input type="button" value="아이디 검색" onclick="idCheck()" class="btn btn-secondary"/>';
			
			demo.innerHTML = temp;
		}
		function idCheck(){
			let mid = document.getElementById("searchMid").value;
			location.href ="${ctp}/LoginSearch.re?mid="+mid;
		}
		
	</script>
</head>
<body>
	<jsp:include page="/include/memberCheck.jsp"/>
	<jsp:include page="/include/header.jsp"/>
<p><br/></p>	
	<div class="container">
		<h2>회원 전용 창입니다 -></h2>
		<p>현재 ${sMid}(${sName})님 로그인 중입니다.</p>
		<hr/>
		<p>보유 포인트 : ${sPoint} /최종 접속일 : ${fn:substring(sLastDate,0,16)}/오늘 접속횟수 : ${sTodayCount}회<p>
		<hr/>
		<p>
		<c:set var="random"><%=(int)(Math.random()*6)+1%></c:set>
		<img src="../../images/${random}.jpg" width="300px"/>
		</p>
		<hr/>
		<div>
		<div class="row">
			<div class="col"></div>
			<div class="col"><button type="button" onclick="searchCheck()" class="btn btn-primary form-control">개별조회</button></div>
			<div class="col"><a href="${ctp}/List.re" class="btn btn-success form-control">전체조회</a></div>
			<div class="col"><a href="${ctp}/Logout.re" class="btn btn-danger form-control">로그아웃</a></div>
			<div class="col"></div>
		</div>
		<hr/>
		<div name="demo" id="demo"></div>
		</div>
	</div>
<p><br/></p>
<jsp:include page="/include/footer.jsp"/>
</body>
</html>