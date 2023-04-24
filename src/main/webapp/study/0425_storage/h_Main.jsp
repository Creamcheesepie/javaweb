<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% String sw = request.getParameter("sw") == null? "" : request.getParameter("sw"); 
	 //세션정보로 바꾸기
	 String logCheck = session.getAttribute("sLogCheck")==null? "OFF" : (String)session.getAttribute("sLogCheck");
%>
<html>
<head>
	<meta charset="UTF-8">
	<title>title</title>
	<jsp:include page="/include/bs4.jsp"/>
  <script>
  </script>
  <style>
  </style>
</head>


<body>
<header>
  <%@ include file="h_Menu.jsp" %>
</header>
  <div id="content" class="text-center">
 <% if(sw.equals("hwChat")) { %>
  	<%@ include file="h_Chat.jsp"%>
  <%} else if(sw.equals("hwLogin")){%>
 	 	<%@ include file="h_Login.jsp"%>
  <%} else if(sw.equals("hwLogout")){%>
 	 	<%@ include file="h_Logout.jsp"%>
  <%} else if(sw.equals("hwSignin")){%>
		<%@ include file="h_Signin.jsp"%>
 	<%} else {%>
	<hr>
 		<h2>메인 페이지입니다</h2>
 	<%} %>
</div>
  <footer>

  </footer>
</body>
</html>