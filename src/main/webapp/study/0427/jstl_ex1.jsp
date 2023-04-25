<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>title</title>
	<jsp:include page="/include/bs4.jsp"/>
	<script>
		function f_imageChange(obj) {
				document.getElementById("demo").innerHTML='<img src="../../images/'obj'.jpg"/>';

		}
	</script>
</head>
<body>
<p><br/></p>	
	<div class="container">
		<h3>콤보상자에 숫자 1~6까지를 기억시키고 화면에 보여준다. 이때 숫자를 클릭하면 아래쪽(demo)으로 선택한 숫자의 그림파일을 출력한다. </h3>
		<form name="myform" method=get action="jstl_ex1.jsp">
		<select onchange="f_imageChange(this)">
			<c:forEach var="i" begin="1" end="6">
				<option value="${i}">그림${i}
			</c:forEach>
		</select>
		</form>
		<div name="demo" id="demo">
		 <img src="../../images/${i}.jpg"/>
		</div>
	</div>
<p><br/></p>
</body>
</html>