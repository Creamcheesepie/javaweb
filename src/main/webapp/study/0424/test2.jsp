<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>test2</title>
	<jsp:include page="/include/bs4.jsp"/>
</head>
<body>
<p><br/></p>	
	<div class="container">
		<h2>회원정보</h2>
		<%-- <form name="myform" id="myform" method="post" action="<%=request.getContextPath()%>/t0424/test1Ok"> --%>
		<form name="myform" id="myform" method="post" action="test2Ok.jsp">
			<p>
				성명 : <input type="text" name="name" id="name" value="홍길동" autofocus class="form-control"/>
			</p>
			<p>
				성별 : <input type="radio" name="gender" id="gender" value="여성" autofocus/>여성
						  <input type="radio" name="gender" id="gender" value="남성" autofocus/>남성
			</p>
			<p>
				나이 : <input type="number" name="age" id="age" value="21" autofocus class="form-control"/>
			</p>
			<p>
				직업 : <select name="job" class="form=control">
					<option value="">선택</option>
					<option value="학생">학생</option>
					<option value="군인">군인</option>
					<option value="회사원">회사원</option>
					<option value="공무원">공무원</option>
					<option value="프리랜서">프리랜서</option>
				</select>
			</p>
			<p>
				주소 : <input type="text" name="address" id="address" value="주소" autofocus class="form-control"/>
			</p>
			<p>
				<input type="submit" name="name" id="name" value="입력"  autofocus class="form-control"/>
			</p>
		</form>
	</div>
<p><br/></p>
</body>
</html>