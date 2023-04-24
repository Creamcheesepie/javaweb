<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>t3_ApplicationMain</title>
	<jsp:include page="/include/bs4.jsp"/>
</head>
<body>
<p><br/></p>	
	<div class="container">
		<h2>어플리케이션 연습 메인메뉴</h2>
			<form name="myform" method="post" action="t3_ApplicationSave.jsp">
				<div>
					아이디 : <input type="text" name="mid" value="${aMid}" autofocues class="form-control">
				</div>
				<div>
					닉네임 : <input type="text" value="${aNickname}" name="nickName" class="form-control">
				</div>
				<div>
					이름 : <input type="text" value="${aName}" name="name" class="form-control">
				</div>
				<hr/>
				<div class="row">
				<div class="col">
					<a href="t3_ApplicationSave.jsp" class="btn btn-success form-control mt-3">어플리케이션 저장1(Get)</a>
				</div>
				<div class="col">
					<button type="submit" class="btn btn-success form-control mt-3">어플리케이션 저장2(post)</button>
				</div>
				<div class="col">
					<button type="submit" class="btn btn-success form-control mt-3">어플리케이션 확인</button>
				</div>
			</div>
			</form>
	</div>
<p><br/></p>
</body>
</html>