<!-- test9Ok2.jsp -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
  String mid = request.getParameter("mid");
  String pwd = request.getParameter("pwd");
  
  //adim, hkd1234,chpang1 비밀번호 : 1234
  
  if(mid.equals("admin") || mid.equals("hkd1234")||mid.equals("chpang1") && pwd.equals("1234")){
  	System.out.println("로그인 성공!");
%>
	<script> 
		alert("로그인 성공!")
  	location.href="test9Success.jsp";
	</script>
<%
  }
  else{
  	System.out.println("로그인 실패, 아이디와 비밀번호를 확인해주세용!");
  	%>
  	<script>
  	alert("로그인 실패!!!") 
  	location.href="test9.jsp"
  	</script>
  	<%
  }
%>