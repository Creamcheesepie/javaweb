<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:set var="ctp" value="${pageContext.request.contextPath}"/>
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
		<h2>Format라이브러리</h2>
		<pre>
		사용용도 : 형식 문자열을 지정할 때 사용한다.(쉼표,화폐단위,백분율...)
		사용법 : < fmt : 명령어 value="$ {값/변수}" pattern="표현패턴" type="화폐단위"/>
		</pre>
		<%
			int won= 7654321;
		pageContext.setAttribute("won", won);
			double won2= 7654.321;
		pageContext.setAttribute("won2", won2);
		
		%>
		<div>
		1.formatNumber<br/>
		1-1. 천단위 쉼표표시<br/>
			1234567=><fmt:formatNumber value="1234567" /> <br/>
			7654321=><fmt:formatNumber value="${won}"/>	<br/>
			7654.321=><fmt:formatNumber value="${won2}" /> <br/>
			7654.321=><fmt:formatNumber value="${won2}" pattern="0,000,000.00"/> <br/>
			7654.321=><fmt:formatNumber value="${won2}" pattern="0,000,000.0000"/> <br/>
			7654.321=><fmt:formatNumber value="${won2}" pattern="#,###,###.####"/> <br/>
		1-2.화폐단위로 표현<br/>
			원화 7654321=><fmt:formatNumber value="${won}" type="currency"/>	<br/>
			달러화 7654321=><fmt:formatNumber value="${won}" type="currency" currencyCode="USD"/>	<br/>
		1-3.백분율 표시(기본적으로 반올림하여 퍼센트로 표시해줌)<br/>
			<c:set var="su1" value="0.9456"/><br/>
			<fmt:formatNumber value="${su1}" type="percent"/><br/>
		2.formatDate<br/>
		2-1.날짜<br/>
			<c:set var="today" value="<%=new Date()%>"/>
			오늘 날짜 : ${today}<br/>
			<fmt:formatDate value="${today}"/><br/>
			<fmt:formatDate value="${today}" pattern="yyyy-MM-dd"/><br/>
			<fmt:formatDate value="${today}" pattern="hh:mm:ss"/><br/>
			<fmt:formatDate value="${today}" pattern="yyyy-MM-dd hh:mm:ss"/><br/>
			<fmt:formatDate value="${today}" pattern="yyyy년 MM월 dd일 hh시mm분ss초"/><br/>
		3.locale<br/>
		3-1. 톰캣서버의 기본 로케일 : <%=response.getLocale() %><br/>
		3-2. 로케일 미국 서버로 변경 : <fmt:setLocale value="en_US"/><fmt:formatNumber value="${won2}" type="currency"/><br>
		4.URL이동 : location.href="url"; / < c : redirect url="url" <br/>
			jstl3.jsp로 이동 : <%-- <c:redirect url="jstl3.jsp"/> --%>
		5.절대경로 : <br/>
			<img src="<%=request.getContextPath()%>/images/1.jpg" width="300px"/><br/>
			<img src="${ctp}/images/1.jpg" width="300px"/><br/>
		6.import<br/>
		<c:import url="/include/bs4.jsp"/>
		</div>
	</div>
<p><br/></p>
</body>
</html>