<!-- test9Ok.jsp -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
  String mid = request.getParameter("mid");
  String pwd = request.getParameter("pwd");
  
  //adim, hkd1234,chpang1 비밀번호 : 1234
  
  if(mid.equals("admin") || mid.equals("hkd1234")||mid.equals("chpang1") && pwd.equals("1234")){
  	System.out.println("로그인 성공!");
  	out.println("<script>");
  	out.println("alert('로그인 성공!')");
  	out.println("location.href='test9Success.jsp';");
  	out.println("</script>");

  }
  else{
  	System.out.println("로그인 실패, 아이디와 비밀번호를 확인해주세용!");
  	out.println("<script>");
  	out.println("alert('로그인 실패!!!');");
  	out.println("location.href='test9.jsp';");
  	out.println("</script>");
  }
%>