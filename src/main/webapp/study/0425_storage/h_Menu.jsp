<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% String member2 = request.getParameter("member") == null? "" : request.getParameter("member"); %>
<%
	String logCount = "";
//아래 부분 수정
	String logCheck2= session.getAttribute("sLogCheck")==null? "Off" : (String)session.getAttribute("sLogCheck");
	Cookie[] cookies2 = request.getCookies();
	for(int i=0; i<cookies2.length;i++){
		if(cookies2[i].getName().equals("cLC")){
			logCount = cookies2[i].getValue();
		}
	}
	pageContext.setAttribute("logCount", logCount);
%>
<style>
@font-face{
	font-family:"seoulhangangM"
	src:url("/../font/SeoulHangangM.ttf") format("truetype");
	font-weight:normal
}
a{
	font-family:'seoulhangangM',굴림;
}

</style>
<jsp:include page="/include/bs4.jsp"/>

	<Nav class="navbar navbar-expand-sm bg-info">
  <ul class="navbar-nav">
    <li class="nav-item">
      <a class="nav-link btn" href="h_Main.jsp" >홈으로</a>
    </li>
    <li class="nav-item">
      <a class="nav-link btn" href="h_Main.jsp?sw=hwChat">채팅방</a>
    </li>
    <!-- 이 방법 외에는 표시 안하는 방법이 없나..? -->
<%if(logCheck2.equals("ON")){%>
    <li class="nav-item">
      <a class="nav-link btn loginON" href="h_Main.jsp?sw=hwLogout">로그아웃</a>
    </li>
    <li>
    ${logCount}회 접속하셨습니다.
    </li>
<%} else{ %>
    <li class="nav-item">
      <a class="nav-link btn loginOff"  href="h_Main.jsp?sw=hwSignin">회원가입</a>
    </li>
    <li class="nav-item">
      <a class="nav-link btn loginOff" href="h_Main.jsp?sw=hwLogin">로그인</a>
    </li>
<%} %>
  </ul>
 </Nav>