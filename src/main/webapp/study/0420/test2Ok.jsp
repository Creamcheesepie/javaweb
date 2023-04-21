<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");

String name= request.getParameter("name");
int age = Integer.parseInt(request.getParameter("age"));
String gender = request.getParameter("gender");
String[] hobbys = request.getParameterValues("hobby");
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>title</title>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.4/dist/jquery.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
  <!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script> -->
  <script>
  </script>
  <style>
  </style>
</head>

<body>
<p><br/></p>	
	<div class="container">
		<table class="table table=bordered">
			<tr>
				<td>성명 : </td>
				<td><%=name %></td>
			</tr>
			<tr>
				<td>나이 : </td>
				<td><%=age %></td>
			</tr>
			<tr>
				<td>성별 : </td>
				<td><%=gender %></td>
			</tr>
			<tr>
				<td>취미 : </td>
				<%-- <td><%=hobbys %></td> --%>
				<td>
				<%-- <%
					for(String hobby : hobbys){
						out.print(hobby + "/");
					}
				%> --%>
				<%
				String str = "";
					for(String hobby : hobbys){
						str += hobby+"/";
					}
					str = str.substring(0, str.length()-1);
					out.println(str);
				%>
				</td>
			</tr>
		</table>
		<br/>
		<p class="text-center">
		<a href="test2.jsp" class="btn btn-warning">돌아가자~</a>
		</p>
	</div>
<p><br/></p>
</body>
</html>