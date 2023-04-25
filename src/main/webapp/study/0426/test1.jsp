<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>title</title>
	<jsp:include page="/include/bs4.jsp"/>
</head>
<body>
<p><br/></p>	
	<div class="container">
	<h2>JSP/Servlet LifeCycle연습</h2>
		<form name="myform" method="post" action="location.href='${pageContext.request.contextPath}/t0426/Test1Ok'">
			<table class="table table-bordered">
				<tr>
					<th>제목</th>
					<td><input type="text" name="title" value="servlet에서의 생명주기" class="form-control"></td>				
				</tr>
				<tr>
					<th>내용</th>
					<td><textarea row="5" name="content" class="form-control">서블릿 메소드 생명주기 연습 입니다.</textarea></td>				
				</tr>
				<tr>
				<td colspan="2"><input type="submit" value="전송" class="btn btn-success"></td>
				</tr>
								
			</table>
		</form> 
	</div>
<p><br/></p>
</body>
</html>