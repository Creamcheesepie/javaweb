<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% String sw = request.getParameter("sw") == null? "" : request.getParameter("sw"); 
	 String member = request.getParameter("member") == null? "" : request.getParameter("member");
	 
	 if(member.equals("OK")) member = "정회원";
	  else member = "비회원";
%>


<html>
<head>
	<meta charset="UTF-8">
	<title>HwFront</title>
 	<jsp:include page="/include/bs4.jsp"/>
  <script>
  </script>
  <style>
  body{
      margin: 0px 0px;
      padding: 0px 0px;
      background: linear-gradient(to bottom, rgb(149, 255, 255) 5%,white 90%);
    }
  </style>
</head>

<body>
<header>
  <%@ include file="hwMenu.jsp" %>
</header>
  <div id="content" class="text-center">
  <% if(sw.equals("hwChat")) { %>
  	<%@ include file="hwChat.jsp"%>
  <%} else if(sw.equals("hwBoard")){%>
  	<%@ include file="hwBoard.jsp"%>
  <%} else if(sw.equals("hwGallary")){%>
   	<%@ include file="hwGallery.jsp"%>
  <%} else if(sw.equals("hwDsp")){%>
  	<%@ include file="hwDsp.jsp"%>
  <%} else if(sw.equals("hwLogin")){%>
 	 	<%@ include file="hwLogin.jsp"%>
  <%} else if(sw.equals("hwLogout")){%>
 	 	<%@ include file="hwLogout.jsp"%>
  <%} else if(sw.equals("hwSignin")){%>
		<%@ include file="hwSignin.jsp"%>
 	<%} else {%>
 		<hr>
 		<h2>메인 페이지입니다 <%=member%></h2>
 	<%} %>
</div>
  <footer>

  </footer>
</body>
</html>
