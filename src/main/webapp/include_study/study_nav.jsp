<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctp" value="${pageContext.request.contextPath}"/>
<%
	String navLoginMidCheck= (String)session.getAttribute("sLoginMid");
	
%>

<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
  <a class="navbar-brand" href="${pageContext.request.contextPath}/study/0429_study/main.jsp">Studymain</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="collapsibleNavbar">
    <ul class="navbar-nav">
    <%if(navLoginMidCheck==null) {%>
      <li class="nav-item">
        <a class="nav-link" href="${ctp}/study/0429_study/login.jsp">로그인</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="${ctp}/study/0429_study/signIn.jsp">회원가입</a>
      </li>
    <%} else{ %> 
      <li class="nav-item">
        <a class="nav-link" href="${ctp}/s0429/Logout">로그아웃</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="${ctp}/s0429/MyInfo">내 정보</a>
      </li>
    <%} %>
      <li class="nav-item">
        <a class="nav-link" href="#">게시판</a>
        
        
        
      </li>    
    </ul>
  </div>  
</nav>