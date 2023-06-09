<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
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
		<h2>Function 라이브러리</h2>
		<pre>
			사용법 : $ { fn : 함수명 (변수,값) }
			관계연산지 : ==(eq), !=(ne), <(lt), >(gt), 예외 : >=(ge), <=(le)
		</pre>
<%
							 //00        10        20     
							 //01234567890123456789012345
	String atom = "welcome to my homepage";
	pageContext.setAttribute("atom", atom);
	pageContext.setAttribute("atom2", atom);
	
	String[] hobbys = {"등산","낚시","싸이클","수영","독서","바둑"};
	pageContext.setAttribute("hobbys", hobbys);
%>
		<P>
			atom 변수의 값? ${atom}<br/>
			1-1.atom변수의 값 길이 : <%=atom.length()%> / ${fn:length(atom)}<br/>
			1-2.hobbys변수 값의 길이 : <%=hobbys.length %> / ${fn:length(hobbys)}<br/>
			2.대문자 변환(to upperCase()) : <%=atom.toUpperCase() %>/ ${fn:toUpperCase(atom)}<br/>
			2-2.소문자 변환(to lowerCase()): <%=atom.toLowerCase() %>/ ${fn:toLowerCase(atom)}<br/>
			3.문자열 추출(substring()) : <%=atom.substring(0,3) %>/ ${fn:substring(atom,0,3)}<br/>
			3-2.문자열 추출(substring()) : <%=atom.substring(2,5) %>/ ${fn:substring(atom,2,5)}<br/>
			3-3.문자열 추출(substring()) : <%=atom.substring(2) %>/ <%-- ${fn:substring(atom,2)} --%>${fn:substring(atom,2,fn:length(atom))} /<%-- ${fn:substring(atom,2,-1} --%><!-- -1을 넣으면 마지막까지 감. --> <br/>
			4-1.특정문자열의 위치값 검색(indexOf()) : <%=atom.indexOf("o") %> / ${fn:indexOf(atom, "o")}<br/>
			4-2.특정문자열의 위치값 검색(indexOf()) : <%=atom.lastIndexOf("o") %> / <%-- ${fn:lastIndexOf(atom, "o")} --%><br/>
				atom변수에 기억되어 있는 'o'문자의 위치를 모두 출력하시오<br>
						'o'의 위치는 => 
				<c:forEach var="i" begin="0" end="${fn:length(atom)-1}" varStatus="st">
					<c:if test="${fn:substring(atom,i,i+1) == 'o'}">
						<c:set var="cnt" value="${cnt+1}"/>
						${cnt}번째&nbsp;${i} /
					</c:if>
				</c:forEach>
			<br/>
			atom 변수값의 'o'문자 개수는? <font color="red">${cnt}</font>개가 있습니다.<br/>
			5.문자열 추출(substringBefore() / substringAfter())<br/>
			  문자 'o'앞의 문자열 출력 substringBefore() : ${fn:substringBefore(atom,'o')}<br/>
			  문자 'o'뒤의 문자열 출력 substringAfter() : ${fn:substringAfter(atom,'o')}<br/>
			6.문자열 분리(split(변수,분리할 문자)) 분리한 문자들을 각각의 분리된 문자들을 변수에 담아주어야 한다.<br/>
			 	ㅇㅖ) atom 변수의 문자중 'o'문자를 기준으로 분리해 보세요<br/>
			 	<c:set var="atoms" value="${fn:split(atom,'o')}"/>
			 	<c:forEach var="atom" items="${atoms}" varStatus="st">
			 	${st.count}. ${atom}<br/>
			 	</c:forEach>
				atom안의 있는 'o'의 개수는? ${fn:length(atoms)-1}
			7-1.문자 치환(replace())<br/>
			  예) atom변수의 'my'를 'Your'로 변경하시오.
			  <%=atom.replace("my","your") %> / <c:set var="temp1" value="${fn:replace(atom2,'my','Your')}"/> ${temp1}<br/>
			7-2.문자 치환(replace())<br/>
			  예) atom변수의 'o'를 'O'로 변경하시오.
			  <%=atom.replace("o","O") %> / <c:set var="temp2" value="${fn:replace(atom2,'o','O')}"/> ${temp2} <br/>
			8.특정문자(열) 포함유무? contains()<br/>
				예) atom2변수에 'o'를 포함하고 있는지? ${fn:contains(atom2,'o')}<br>
				예) atom2변수에 'my'를 포함하고 있는지? ${fn:contains(atom2,'my')}<br>
				예) atom2변수에 'your'를 포함하고 있는지? ${fn:contains(atom2,'your')}<br>
		</P>
	</div>
<p><br/></p>
</body>
</html>