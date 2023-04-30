<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctp" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>title</title>
	<jsp:include page="/include/bs4.jsp"/>
</head>

<body>
<jsp:include page="/include_study/study_header.jsp"/>

<div class="container" style="margin-top:30px">
	<div style="margin-top: 150px"></div>
	<form name="signinform" method="post" action="${ctp}/s0429/SigninCheck">
	<div style="text-align: center"><h2>내정보</h2></div>
	<div class="row mt-3">
		<div class="col-sm"></div>	
		<div class="col-sm-1" style="text-align: right">고유번호</div>
		<div class="col-sm"><input type="text" name="name" id="name" class="form-control" value="${vo.idx}" readonly></div>
		<div class="col-sm"></div>	
	</div>
	<div class="row mt-3">
		<div class="col-sm"></div>	
		<div class="col-sm-1" style="text-align: right">아이디</div>
		<div class="col-sm"><input type="text" name="mid" id="mid" class="form-control" value="${vo.mid}" readonly></div>
		<div class="col-sm"></div>	
	</div>
	<div class="row mt-3">
		<div class="col-sm"></div>	
		<div class="col-sm-1" style="text-align: right">성함</div>
		<div class="col-sm"><input type="text" name="name" id="name" class="form-control" value="${vo.name}" readonly></div>
		<div class="col-sm"></div>	
	</div>
	<div class="row mt-3">
		<div class="col-sm"></div>	
		<div class="col-sm-1" style="text-align: right">닉네임</div>
		<div class="col-sm"><input type="text" name="nickName" id="nickName" class="form-control" value="${vo.nickName}" readonly></div>
		<div class="col-sm"></div>	
	</div>
	<div class="row mt-3">
		<div class="col-sm"></div>	
		<div class="col-sm-1" style="text-align: right">최초가입일자</div>
		<div class="col-sm"><input type="text" name="createDate" id="createDate" class="form-control" value="${vo.createDate}" readonly></div>
		<div class="col-sm"></div>	
	</div>
	<div class="row mt-3">
		<div class="col-sm"></div>	
		<div class="col-sm-1" style="text-align: right">마지막 로그인 시간</div>
		<div class="col-sm"><input type="text" name="lastLoginDate" id="lastLoginDate" class="form-control" value="${vo.lastLoginDate}" readonly></div>
		<div class="col-sm"></div>	
	</div>
	<div class="row mt-3">
		<div class="col-sm"></div>	
		<div class="col-sm-1" style="text-align: right">로그인 횟수</div>
		<div class="col-sm"><input type="text" name="totalLoginCount" id="totalLoginCount" class="form-control" value="${vo.totalLoginCount}" readonly></div>
		<div class="col-sm"></div>	
	</div>
	<div class="row mt-3">
		<div class="col-sm"></div>	
		<div class="col-sm-1" style="text-align: right">포인트</div>
		<div class="col-sm"><input type="text" name="point" id="point" class="form-control" value="${vo.point}" readonly></div>
		<div class="col-sm"></div>	
	</div>
	<div class="row mt-3">
		<div class="col-sm"></div>	
		<div class="col-sm-1" style="text-align: right">회원등급</div>
		<div class="col-sm"><input type="text" name="memberGrade" id="memberGrade" class="form-control" value="${vo.memberGrade}" readonly></div>
		<div class="col-sm"></div>	
	</div>
	<div class="row mt-3">
		<div class="col-sm"></div>	
		<div class="col-sm"></div>
		<div class="col-sm">
			<button type="button" class="btn btn-primary" onclick="location.href='${ctp}/study/0429_study/main.jsp'">홈으로</button>
			<button type="button" class="btn btn-warning" onclick="location.href='${ctp}/study/0429_study/myInfoChange.jsp'">정보수정</button>
		</div>
		<div class="col-sm"></div>	
		<div class="col-sm"></div>
	</div>
	</form>
	<div style="margin-top: 250px"></div>

</div>

<jsp:include page="/include_study/study_footer.jsp"/>
</body>
</html>