<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
//request로 내용 받아와서 변수에 담기
String name = request.getParameter("name")==null? "": request.getParameter("name");
String age = request.getParameter("age")==null? "": request.getParameter("age");
String gender = request.getParameter("gender")==null? "": request.getParameter("gender");
String job = request.getParameter("job")==null? "": request.getParameter("job");
String address = request.getParameter("address")==null? "": request.getParameter("address");
//저장소에 담기
pageContext.setAttribute("name", name);
pageContext.setAttribute("age", age);
pageContext.setAttribute("gender", gender);
pageContext.setAttribute("job", job);
pageContext.setAttribute("address", address);
%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>tes2Ok</title>
	<jsp:include page="/include/bs4.jsp"/>
</head>
<body>
<p><br/></p>	
	<div class="container">
		<h2>처리된 자료를 view에 출력시켜본다.</h2>
		<div>
			<table class="table table-bordered">
			<tr>
			<th>성명</th>
			<%-- <td><%=name%></td> --%>
			<td>${name}</td>
			</tr>
			<tr>
			<th>나이</th>
			<%-- <td><%=age %></td> --%>
			<td>${age}</td>
			</tr>
			<tr>
			<th>성별</th>
			<%-- <td><%=gender %></td> --%>
			<td>${gender}</td>
			</tr>
			<tr>
			<th>직업</th>
			<%-- <td><%=job %></td> --%>
			<td>${job}</td>
			</tr>
			<tr>
			<th>주소</th>
			<%-- <td><%=address %></td> --%>
			<td>${address}</td>
			</tr>
			<tr>
				<a href="test2.jsp" class="btn btn-warning">돌아가기</a>
			</tr>
			</table>
		</div>
	</div>
<p><br/></p>
</body>
</html>