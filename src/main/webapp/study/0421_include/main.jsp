<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% String sw = request.getParameter("sw") == null? "" : request.getParameter("sw"); %>
<% String member = request.getParameter("member") == null? "" : request.getParameter("member");  

 if(member.equals("OK")) member = "정회원";
  else member = "비회원";
  %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>main</title>
 <%-- <jsp:include page="<%=request.getContextPath()%>/include/bs4.jsp"/> --%>
 <jsp:include page="/include/bs4.jsp"/>
</head>


<body>

	<div id="header" class="text-center" style="background-color:cyan">
		<%@ include file="menu.jsp" %>
	</div>
	<div class="container">
	<!-- 헤더영역(로고/메뉴)를 표시 -->
	<div>
	<!-- 본문 영역 -->
	<div id="content" class="text-center">
<%  if(sw.equals("guest")){ %>
			<%@ include file="guest.jsp"%>
<% 	} else if(sw.equals("board")){%>
			<%@ include file="board.jsp"%>
<% 	} else if(sw.equals("pds")){%>
			<%@ include file="pds.jsp"%>
<% 	} else if(sw.equals("schedule")){%>
			<%@ include file="schedule.jsp"%>
<% 	} else if(sw.equals("photo")){%>
			<%@ include file="photo.jsp"%>
<% 	} else if(sw.equals("login")){%>
			<%@ include file="login.jsp"%>
<% 	} else {%>
		<hr/>
		<h2>이곳은 메인입니다.<%=member%></h2>
		<hr/>
		<p><img src="../../images/1.jpg" width="600px"></p>
		<hr/>
<p>환영합니당~~</p>
<%  }%>	
	</div>
		<!-- 푸터(footer)영역 : 저작권 주소, 이메일 제작자 등... -->
	</div>
	</div>

		<div id="footer">
		<%@ include file="footer.jsp" %>	
		</div>
</body>
</html>
		<%-- <jsp:include page="<%=request.getContextPath() %>/study/0421_include/menu.jsp"/> --%>