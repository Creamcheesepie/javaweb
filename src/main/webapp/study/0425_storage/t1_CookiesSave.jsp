<!-- t1_CookiesSave.jsp -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
	//cookie변수는 첫글자 c로 사용, session변수는 첫글자 s로 사용
	String mid = "hkd1234";
	Cookie cookieMid = new Cookie("cMid",mid);
	cookieMid.setMaxAge(60*60*24); //쿠키의 만료 시간 : 단위(초) ex)1일 : 60*60*24;
	
	String pwd = "1234";
	Cookie cookiePwd =new Cookie("cPwd",pwd);
	cookiePwd.setMaxAge(60*60*24);
	
	String job = "학생";
	Cookie cookieJob = new Cookie("cJob",job);
	cookieJob.setMaxAge(60*60*24);
	
	//쿠키를 클라이언트에 저장하기(즉, 엔드유저(사용자 컴퓨터)에 저장함.)
	response.addCookie(cookieMid);
	response.addCookie(cookiePwd);
	response.addCookie(cookieJob);
	
%>
<script>
	alert("쿠키에 저장하였습니다.");
	location.href="t1_CookiesMain.jsp";
</script>
