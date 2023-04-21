<!-- guest -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>guest</title>
 <%-- <jsp:include page="<%=request.getContextPath()%>/include/bs4.jsp"/> --%>
 <jsp:include page="/include/bs4.jsp" />
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
		<hr/>
		<h2/>이곳은 방명록입니다<h2/>
		<hr/>
		<p><img src="../../images/2.jpg" width="600px"></p>
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