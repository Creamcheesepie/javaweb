<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
		<h2>JSTL(JAVA STANDARD TAG LIBRARY)</h2>
		<h3>반복처리</h3>
		<hr/>
		<pre>
		사용법 1 : < c : forEach var="변수" begin="초기값" end="최종값" step="증감값(1은 생략가능)" varStatus="매개변수">
						 < /c : forEach>
						 
		사용법 2 : < c : forEach var="변수" items="$ {배열/객체명}" varStatus="매개변수">
						 < /c : forEach>
						 
		사용법 3 : < c : forTokens var="변수" items="$ {배열/객체명}" delims="구분기호">
						 < /c : forEach>
		
		</pre>
		<hr/>
		<p>사용 예 1:<br/>
			<c:forEach var="i" begin="1" end="10" step="1" >
				${i}.안 녕 ? 
			</c:forEach>
		</p>
		<p>사용 예 1_2:<br/>
		인덱스 값은 begin에서 시작한 값이 end로 끝난다, count값은 1,2,3,4...순으로 증가한다<br/>
			<c:forEach var="i" begin="5" end="10" step="1" varStatus="st" >
			||	변수 값${i} | 인덱스값 ${st.index} | count값 ${st.count} | first값 ${st.first} | last값 ${st.last}안 녕 ? ||<br/> 
			</c:forEach>
		</p>
		<p>
			사용예2-1<br/>
			<%
				String[] cards = {"국민카드","비씨카드","농협카드","비자카드","엘지카드","현대카드","삼성카드"};
				pageContext.setAttribute("cards", cards);
			%>
			<c:forEach var="card" items="${cards}">
				${card}/
			</c:forEach>
		</p>
		<p>
			사용예2-2<br/>
			<c:forEach var="card" items="${cards}" varStatus="st">
				<%-- ${st.index}.${card}/ --%>
				${st.count}.${card}/
			</c:forEach>
		</p>
		<%
		String hobbys="등산/낚시/자전거/수영/바둑/영화/음악";
		pageContext.setAttribute("hobbys", hobbys);
		%>
		<p>사용예 3-1<br/>
			<c:forTokens var="hobby" items="${hobbys}" delims="/">
				${hobby} :
			</c:forTokens>
		</p>
		<p>사용예 3-2<br/>
			<c:forTokens var="hobby" items="${hobbys}" delims="/" varStatus="st">
				${st.count}.${hobby} :
			</c:forTokens>
		</p>
		<hr>
		<p>
		문제 1, 전송된 취미 중에서 바둑은 빨간색으로, 수영은 파란색, 나머지는 그대로 출력하세요.<br/>
		<c:set var="str1" value="바둑"/>
		<c:set var="str2" value="수영"/>
		<c:forTokens var="hobby" items="${hobbys}" delims="/">
		<c:choose>
			<c:when test="${hobby==str1}"><span class="text-danger">${hobby}</span></c:when>
			<c:when test="${hobby==str2}"><span class="text-primary">${hobby}</span></c:when>
			<c:otherwise>${hobby}</c:otherwise>
		</c:choose>
		</c:forTokens>
		</p>
		<hr>
		<h3>구구단 연습</h3>
		<c:forEach var="i" begin="1" end="9">
			7*${i} = ${7*i}<br/>
		</c:forEach>
		<h3>2중 for구문을 이용한구구단 연습</h3>
		<P>
		<c:forEach var="dan" begin="2" end="9">
		${dan}단<br/>
			<c:forEach var="i" begin="1" end="9">
				${dan}*${i} = ${dan*i}<br/>
			</c:forEach>
		<hr/>
		</c:forEach>
		<hr/>
		<h3>그림파일 6장을 한줄에 3장씩 출력하기.</h3>
		<c:forEach var="i" begin="1" end="2">
			<c:forEach var="j" begin="1" end="3">
				<c:set var="cnt" value="${cnt+1}"/>		
				<img src="../../images/${cnt}.jpg" width="200px"/>
			</c:forEach>
			<br/>
		</c:forEach>
		
		</P>
	</div>
<p><br/></p>
</body>
</html>