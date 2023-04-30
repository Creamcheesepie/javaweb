<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
	  <!-- <a class="navbar-brand" href="http://localhost:9090/javaweb/">home</a> -->
	  <a class="navbar-brand" href="http://192.168.50.88:9090/javaweb/">home</a>
	  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
	    <span class="navbar-toggler-icon"></span>
	  </button>
	  <div class="collapse navbar-collapse" id="collapsibleNavbar">
	    <ul class="navbar-nav">
	      <li class="nav-item">
	        <a class="nav-link" href="#">guest</a>
	      </li>
	      <li class="nav-item">
	        <a class="nav-link" href="#">board</a>
	      </li>
	      <li class="nav-item">
	        <a class="nav-link" href="#">PDS</a>
	      </li>
	      <li>
			  <div class="dropdown">
			  	<button type="button" class="btn text-light dropdown-toggle" data-toggle="dropdown">study1</button>
			   	<div class="dropdown-menu">
			      <a class="dropdown-item" href="#">url 매핑</a>
			      <a class="dropdown-item" href="#">Link 2</a>
			      <a class="dropdown-item" href="#">Link 3</a>
			    </div>
			  </div>  
	      </li>
	      <li>
			  <div class="dropdown">
			  	<button type="button" class="btn text-light dropdown-toggle" data-toggle="dropdown">study2</button>
			   	<div class="dropdown-menu">
			      <a class="dropdown-item" href="${pageContext.request.contextPath}/study/0428_database/login.jsp">로그인 연습</a>
			      <a class="dropdown-item" href="#">Link 3</a>
			      <a class="dropdown-item" href="#">url 매핑</a>
			    </div>
			  </div>  
	      </li>
	      <li>
			  <div class="dropdown">
			  	<button type="button" class="btn text-light dropdown-toggle" data-toggle="dropdown">개인정보</button>
			   	<div class="dropdown-menu">
			      <a class="dropdown-item" href="#">회원정보수정</a>
			      <a class="dropdown-item" href="#">회원목록</a>
			      <a class="dropdown-item" href="#">회원탈퇴</a>
			    </div>
			  </div>  
	      </li>
	    </ul>
	  </div>
	</nav>