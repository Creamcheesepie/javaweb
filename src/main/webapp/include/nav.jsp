<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	int level = session.getAttribute("sLevel")==null?99:(int)session.getAttribute("sLevel");
	pageContext.setAttribute("level", level);
%>
<c:set var="ctp" value="${pageContext.request.contextPath}"/>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
	  <!-- <a class="navbar-brand" href="http://localhost:9090/javaweb/">home</a> -->
	  <a class="navbar-brand" href="http://192.168.50.88:9090/javaweb/">home</a>
	  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
	    <span class="navbar-toggler-icon"></span>
	  </button>
	  <div class="collapse navbar-collapse" id="collapsibleNavbar">
	    <ul class="navbar-nav">
	      <li class="nav-item">
	        <a class="nav-link" href="${ctp}/GuestList.gu">guest</a>
	      </li>
	      <c:if test="${level <=4}">
		      <li class="nav-item">
		        <a class="nav-link" href="${ctp}/BoardList.bo">board</a>
		      </li>
		      <li class="nav-item">
		        <a class="nav-link" href="#">PDS</a>
		      </li>
		      <li>
				  <div class="dropdown">
				  	<button type="button" class="btn text-light dropdown-toggle" data-toggle="dropdown">study1</button>
				   	<div class="dropdown-menu">
				      <a class="dropdown-item" href="${ctp}/mapping/Test1">url 매핑(디렉토리패턴)</a>
				      <a class="dropdown-item" href="${ctp}/mapping/Test5.do">url 매핑(확장자패턴1)</a>
				      <a class="dropdown-item" href="${ctp}/mapping/Test5.mi">url 매핑(확장자패턴2)</a>
				      <a class="dropdown-item" href="${ctp}/mapping/JoinSecure.re">회원가입(암호화)</a>
				      <a class="dropdown-item" href="${ctp}/mapping/LoginSecure.re">로그인(암호화)</a>
				      <a class="dropdown-item" href="${pageContext.request.contextPath}/study/0428_database/Login.re">로그인 연습1(매핑)</a>
				      <a class="dropdown-item" href="${ctp}/Ajax1Test1">ajax1연습1</a>
				      <a class="dropdown-item" href="${ctp}/UserList.st">ajax1연습2</a>
				    </div>
				  </div>  
		      </li>
		      <li>
				  <div class="dropdown">
				  	<button type="button" class="btn text-light dropdown-toggle" data-toggle="dropdown">study2</button>
				   	<div class="dropdown-menu">
				      <a class="dropdown-item" href="${pageContext.request.contextPath}/study/0428_database/login.jsp">로그인 연습2</a>
				      <a class="dropdown-item" href="#">로그인 연습3</a>
				      <a class="dropdown-item" href="${ctp}/mapping/Test1">url 매핑</a>
				      <a class="dropdown-item" href="Password.st">암호화연습</a>
				      <a class="dropdown-item" href="Uuid.st">UUID 연습</a>
				    </div>
				  </div>  
		      </li>
		      <li>
				  <div class="dropdown">
				  	<button type="button" class="btn text-light dropdown-toggle" data-toggle="dropdown">homeStudy</button>
				   	<div class="dropdown-menu">
				      <a class="dropdown-item" href="${pageContext.request.contextPath}/hsLogin.hs">로그인연습(집)</a>
				      <a class="dropdown-item" href="${pageContext.request.contextPath}/hsLogout.hs">로그아웃(집)</a>
				      <a class="dropdown-item" href="${pageContext.request.contextPath}/hsMyInfo.hs">내정보(집)</a>
				      <a class="dropdown-item" href="${pageContext.request.contextPath}/hsGoSigninPage.hs">회원가입(집)</a>
				      <a class="dropdown-item" href="${pageContext.request.contextPath}/hsBoardList.pp">게시판(집)</a>
				    </div>
				  </div>  
		      </li>
		      <li>
				  <div class="dropdown">
				  	<button type="button" class="btn text-light dropdown-toggle" data-toggle="dropdown">개인정보</button>
				   	<div class="dropdown-menu">
				      <a class="dropdown-item" href="${ctp}/MemberMain.mem">회원전용방</a>
				      <a class="dropdown-item" href="#">회원정보수정</a>
				      <a class="dropdown-item" href="${ctp}/MemberList.mem">회원목록</a>
				      <a class="dropdown-item" href="#">회원탈퇴</a>
				      <c:if test="${sLevel==0}">
				      	<a class="dropdown-item" href="#">관리자 메뉴</a>
				      </c:if>
				    </div>
				  </div>  
		      </li>
	      </c:if>
	      <c:if test="${level>4}">
		      <li class="nav-item">
		        <a Class="nav-link" href="${ctp}/MemberLogin.mem">로그인</a>
		      </li>
		      <li class="nav-item">
		        <a class="nav-link" href="${ctp}/MemberJoin.mem">회원가입</a>
		      </li>	
	      </c:if>
	      <c:if test="${level<=4}">
	      <li class="nav-item">
	        <a class="nav-link" href="${ctp}/MemberLogout.mem">로그아웃</a>
	      </li>
	      </c:if>
	    </ul>
	  </div>
	</nav>