<!-- t1_CookiesDelete.jsp -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
	Cookie[] cookies = request.getCookies();

	for(int i = 0; i<cookies.length; i++){
		cookies[i].setMaxAge(0); //쿠키의 만료시간을 0으로 세팅하여 쿠키를 제거한다.
		response.addCookie(cookies[i]);
	}
	//쿠키 숙제 : 로그인
	//아이디, 비밀번호, 로그인, 취소
	//체크박스 아이디 저장
	//if(체크되어 있으면) 아이디 text박스의 내용을 저장.
	//체크X 면 다시 쿠키의 내용을 초기화하려 text박스 안의 내용을 지우도록 하기로.
	//기본으로 페이지 들어가면 체크되어 있게
%>

<script>
	alert("쿠키삭제완료!");
	location.href="t1_CookiesMain.jsp";
</script>
