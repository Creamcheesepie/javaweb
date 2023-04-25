<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>jstl.jsp</title>
	<jsp:include page="/include/bs4.jsp"/>
</head>
<body>
<p><br/></p>	
	<div class="container">
		<h2>JSTL(JAVA STANDARD TAG LIBRARY)</h2>
		<table class="table table-boarder table-hover">
		<tr>
			<th>라이브러리명</th>
			<th>주소(url)</th>
			<th>접두어</th>
			<th>기본문법</th>
		</tr>
		<tr>
			<td>Core</td>
			<td>http://java.sun.com/jsp/jstl/core</td>
			<td>c</td>
			<td><pre>< c :태그명...></pre></td>
		</tr>
		<tr>
			<td>formatting</td>
			<td>http://java.sun.com/jsp/jstl/fmt</td>
			<td>fmt</td>
			<td><pre>< fmt :태그명...></pre></td>
		</tr>
		<tr>
			<td>Function</td>
			<td>http://java.sun.com/jsp/jstl/function</td>
			<td>fn</td>
			<td><pre>$ {  fn :태그명... }</pre></td>
		</tr>
		<tr>
			<td>SQL</td>
			<td>http://java.sun.com/jsp/jstl/sql</td>
			<td>sql</td>
			<td><pre>< sql :태그명...></pre></td>
		</tr>
		</table>
		<h2>라이브러리를 사용할 경우, 상단에 jsp지시자(taglibrary) 이용하여 선언 후 사용가능하다.</h2>
	</div>
	<br><hr><hr>
	<h3>core라이브러리 : 변수 제어(선언/할당/출력/제거) 제어문(조건,반복문) - 제어문 안의 변수로 활용</h3>
	<pre>
		변수선언 : < c : set var="변수명" value="값"/>
		변수출력 : < c : out value="변수명/값" />
		변수제거 : < c : remove var="변수명" />
	</pre>
	<P>사용예<br/>
	su1에 변수를 선언 후 초기값으로 100할당?<br/>	
	<c:set var="su1" value="100"/>
	su1 변수의 값 출력. >> ""안의 내용을 그대로 출력해버리기 때문에 변수를 출력시키기 위해서는 EL표기법을 써야한다.<br/>
	<c:out value="${su1}"/>
	<c:out value="su1"/>
	su1 변수의 값에 100을 더하여 su2변수에 할당하고 출력하시오.<br/>
	<c:set var="su2" value="${su1+100}"/>
	<c:out value="${su2}"/>
	<br/>
	< c : out value="">은 EL 변수로 대체가능하다 $ { su2 }  => ${su2} 
	</P>
	<h4>JSTL 제어문(core라이브러리 활용)</h4>
	<P>사용법 : < c : if test="$ {조건식}">조건식의 내용이 참일때 수행. JSTL에서는 else문이 없다. 거짓일때도 다시 써야한다.(배타적 조건 작성)< /c : if ></P>
	<div>일반적인 비교연산 수행을 시도하면 '문자'로 비교처리한다.</div>
	<div>숫자로 비교연산을 하기 위해서는 숫자로 변형(문자변수 + 숫자(보통0))해서 비교처리를 할 필요가 있다.</div>
	<div>예제 : su3=100; su4=200을 기억후 두 값을 비교해보자.<br/>
			<c:set var="su3" value="100"/>
			<c:set var="su4" value="20"/>
			1. su3==su4? : 
				<c:if test="${su3==su4}">su3와 su4는 같다</c:if>
				<c:if test="${su3!=su4}">su3와 su4는 다르다</c:if>
			<br/>
			2. su3>su4?
				<c:if test="${su3>su4}">su3는 su4보다 크다</c:if>
				<c:if test="${su3==su4}">su3는 su4와 같다</c:if>
				<c:if test="${su3<su4}">su3는 su4보다 작다</c:if>
			<br/>
			3. su3 > su4 ? 문자로 비교 처리가 아니고 숫자로 비교처리해보기. +0을 해본다.
				<c:if test="${su3+0>su4+0}">su3는 su4보다 크다</c:if>
				<c:if test="${su3+0<=su4+0}">su3는 su4보다 작거나 같다</c:if>
			<br/>
			<div>예제 : url에 get방식으로 입력되는 점수를 받아, 학점을 구하시오.
			<c:set var="jum" value="${param.jumsu}"/>
			<c:if test="${jum+0>=60}"><c:set var="grade" value="D"/></c:if>
			<c:if test="${jum+0>=70}"><c:set var="grade" value="C"/></c:if>
			<c:if test="${jum+0>=80}"><c:set var="grade" value="B"/></c:if>
			<c:if test="${jum+0>=90}"><c:set var="grade" value="A"/></c:if>
			<c:if test="${jum+0<60}"><c:set var="grade" value="F"/></c:if>
			학점은 : ${grade}
			</div>
			<hr/>
			<div>
			<h3>다중조건비교 : choose ~ when</h3>
			<pre>
			사용법 : 
				< c : choose >
					< c : when test="조건식1">수행할 내용1< /c : when>
					< c : when test="조건식2">수행할 내용2< /c : when>
					< c : when test="조건식3">수행할 내용3< /c : when>
					< c : when test="조건식4">수행할 내용4< /c : when>
						~~~~~~~
					< c : otherwise > 기타 수행할 내용 < /c: otherwise >
				< / c :choose>
			</pre>
			학점은 : 
			<c:choose>
				<c:when test="${jum>=90}">A</c:when>
				<c:when test="${jum>=80}">B</c:when>
				<c:when test="${jum>=70}">C</c:when>
				<c:when test="${jum>=60}">D</c:when>
				<c:otherwise>F</c:otherwise>
			</c:choose>
			</div>
	</div>
	<p><br/></p>
</body>
</html>