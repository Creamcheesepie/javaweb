<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	Cookie[] cookies =request.getCookies();
	String mid = "";
	if(cookies!=null){
		for(int i=0; i<cookies.length;i++){
			if(cookies[i].getName().equals("cMid")){
				mid=cookies[i].getValue();
				pageContext.setAttribute("mid", cookies[i].getValue());
				break;
			}

		}	
	}
%>

<html>
<head>
	<meta charset="UTF-8">
	<title>t6_login</title>
	<jsp:include page="/include/bs4.jsp"/>
	<style>
		div{
			margin: 10px;
		}
	</style>
</head>
<body>
<p><br/></p>
<p>샘플 : admin(1234) , hkd1234(1234)</p>	<!-- 링크 글어서 글자 누르면 알아서 내용 들어가게 만들기. -->
	<div class="container">
		<form name="myform" method="post" action="<%=request.getContextPath()%>/t0424/T6_LoginOk" >
			<div>
				아이디 :
				<input type="text" name="mid" class="form-control" autofocus>
			</div>
			<div>
				비밀번호 :
				<input type="password" name="pwd"  class="form-control" autofocus>
			</div>
			<div>
				<button type="submit" class="btn btn-success mt-3">로그인</button>
			</div>
			<div>
				<button type="reset" class="btn btn-danger mt-3">다시입력</button>
			</div>
			<div>
				<input type="checkBox" name="idSave" checked>아이디 저장</button>
			</div>
		</form>
	</div>
<p><br/></p>
</body>
</html>