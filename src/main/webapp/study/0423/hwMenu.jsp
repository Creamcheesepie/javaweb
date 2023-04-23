<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% String member2 = request.getParameter("member") == null? "" : request.getParameter("member"); %>


<jsp:include page="/include/bs4.jsp"/>

	<Nav class="navbar navbar-expand-sm bg-info">
  <ul class="navbar-nav">
    <li class="nav-item">
      <a class="nav-link btn" href="Homework.jsp?member=<%=member2%>" >홈으로</a>
    </li>
    <li class="nav-item">
      <a class="nav-link btn" href="Homework.jsp?sw=hwChat&member=<%=member2%>">채팅방</a>
    </li>
    <li class="nav-item">
      <a class="nav-link btn" href="Homework.jsp?sw=hwBoard&member=<%=member2%>">게시판</a>
    </li>
    <li class="nav-item">
      <a class="nav-link btn" href="Homework.jsp?sw=hwGallery&member=<%=member2%>">갤러리</a>
    </li>
    <li class="nav-item">
      <a class="nav-link btn" href="Homework.jsp?sw=hwDsp&member=<%=member2%>">자료실</a>
    </li>
<%if(member2.equals("OK")){%>
    <li class="nav-item">
      <a class="nav-link btn loginON" href="Homework.jsp?sw=hwLogout">로그아웃</a>
    </li>
<%} else{ %>
    <li class="nav-item">
      <a class="nav-link btn loginOff"  href="Homework.jsp?sw=hwSignin">회원가입</a>
    </li>
    <li class="nav-item">
      <a class="nav-link btn loginOff" href="Homework.jsp?sw=hwLogin">로그인</a>
    </li>
<%} %>
  </ul>
 </Nav>
