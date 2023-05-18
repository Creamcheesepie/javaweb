<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:set var="ctp" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>경찰정_전국 경찰서별 강력범죄 발생 현황</title>
	<jsp:include page="/include/bs4.jsp"/>
	<script>
		'use strict';
		
		const API_KEY = 'ICmz8Dnwqq2DFCk3u6tle9uDRLbV9qWVKoMrTuFZp16lzL0nl2%2BrvL0ncOkwOc1wof%2B%2BndsRw%2FyZJLzEo30mHg%3D%3D';
		
		// 외부 데이터를 가져오는 방식? : fetch방식 -> jSON 형식
		// 경찰청에서 제공해주는 api 이용한 자료 검색
		 async function getCrimeData(){
			let year = $("#year").val();
			let apiYear="";
			
			if(year==2015) apiYear="/15084592/v1/uddi:fbbfd36d-d528-4c8e-aa9b-d5cdbdeec669";
			else if(year==2016) apiYear="​/15084592/v1/uddi:21ec6fa1-a033-413b-b049-8433f5b446ff";
			else if(year==2017) apiYear="/15084592/v1/uddi:67117bd9-5ee1-4e07-ae4a-bfe0861ee116";
			else if(year==2018) apiYear="/15084592/v1/uddi:2d687e27-b5c3-4bdb-9b77-c644dcafcbc7";
			else if(year==2019) apiYear="/15084592/v1/uddi:b6cc7731-181b-48e1-9a6c-ae81388e46b0";
			else if(year==2020) apiYear="/15084592/v1/uddi:fdde1218-987c-49ba-9326-8e3ba276141e";
			else if(year==2021) apiYear="/15084592/v1/uddi:943e757d-462b-4b3a-ab9f-9a8553637ca2";
			
			let url = "https://api.odcloud.kr/api"+apiYear;
			
			url +="?serviceKey="+API_KEY;
			url +="&page=1&perPage=200"
			
			fetch(url);
			
			let response = await fetch(url);
			
			const res= await response.json();
			
			console.log("res: ",res);
			
			$("#demo").text(res);
			
			/* let str = "";
			for(let i=0;i<res.data.length;i++){
				str+= res.data[i]+"<br/>";
			} */
			
			let str = res.data.map((item,i)=>[
				(i+1) + ". 발생년도 : " + item.발생년도 + "년, 경찰서 : " + item.경찰서 
				+ " = 강도 " + item.강도+"건 , "
				+ "	살인 " + item.살인+"건 , "
				+ "	절도 " + item.절도+"건 , "
				+ "	폭력 " + item.폭력+"건 <br/>"
			]);
			
			$("#demo").html(str);

		}
		
		//검색된 자료를 DB에 저장하기.
		async function saveCrimeData(){
			let year = $("#year").val();
			let apiYear="";
			
			if(year==2015) apiYear="/15084592/v1/uddi:fbbfd36d-d528-4c8e-aa9b-d5cdbdeec669";
			else if(year==2016) apiYear="​/15084592​/v1​/uddi:21ec6fa1-a033-413b-b049-8433f5b446ff";
			else if(year==2017) apiYear="/15084592/v1/uddi:67117bd9-5ee1-4e07-ae4a-bfe0861ee116";
			else if(year==2018) apiYear="/15084592/v1/uddi:2d687e27-b5c3-4bdb-9b77-c644dcafcbc7";
			else if(year==2019) apiYear="/15084592/v1/uddi:b6cc7731-181b-48e1-9a6c-ae81388e46b0";
			else if(year==2020) apiYear="/15084592/v1/uddi:fdde1218-987c-49ba-9326-8e3ba276141e";
			else if(year==2021) apiYear="/15084592/v1/uddi:943e757d-462b-4b3a-ab9f-9a8553637ca2";
			
		
			let url = "https://api.odcloud.kr/api" + apiYear;
			
			url +="?serviceKey="+API_KEY;
			url +="&page=1";
			url +="&perPage=200";
		
			let response = await fetch(url);
			
			const res= await response.json();
			
			console.log("res: ",res);
			
			$("#demo").text(res);
			
			let str = res.data.map((item,i)=>[
				(i+1) + ". 발생년도 : " + item.발생년도 + "년, 경찰서 : " + item.경찰서 
				+ " = 강도 " + item.강도+"건 , "
				+ "	살인 " + item.살인+"건 , "
				+ "	절도 " + item.절도+"건 , "
				+ "	폭력 " + item.폭력+"건 <br/>"
			]);
			
			$("#demo").html(str);
			// aJax를 이용, DB에 자료를 저장한다.
			let query;
			for(let i=0; i<res.data.length;i++){
				if(res.data[i].경찰서 != null){
					query = {
							year : res.data[i].발생년도,
							police : res.data[i].경찰서,
							robbery : res.data[i].강도,
							murder : res.data[i].살인,
							theft : res.data[i].절도,
							violence : res.data[i].폭력
					}
					
					$.ajax({
							type : "post",
							url : "${ctp}/SaveCrimeData.st",
							data : query,
							error : function(){
								alert("전송오류!");
							}
					})
					
				}
				
			}
			alert(year+"년도 자료가 DB에 저장되었습니다.");
			
		}
		
		//DB에 저장된 자료 삭제 처리
		function saveCrimeDelete(){
			let year = $("#year").val()
			let ans = confirm("해당년도의 자료를 삭제 하시겠습니까?")
			if(!ans) return false;
			
			$.ajax({
				type:"post",
				url : "${ctp}/SaveCrimeDelete.st",
				data : {year:year},
				success:function(res){
					if(res=="1") {
						alert(year+"년도 자레 삭제 완료")
						location.reload();
					}
					else{
						alert("삭제 실패.")
					}
				},
				error : function(){
					alert("전송오류")
				}
				
				
			})
		}
		
		function searchDBCrimeData(){
			let year = $("#year").val()
			location.href="${ctp}/SearchCrimeData.st?year="+year;
		}
		
		function searchPoliceCrimeData(){
			let year = $("#year").val();
			let order = $("input[name=crimeOrder]:checked").val();
			location.href="${ctp}/SerchCrimeByPoliceOrder.st?year="+year+"&order="+order;
		}
		
	</script>
</head>
<body>
<jsp:include page="/include/header.jsp"/>
<p><br/></p>	
	<div class="container">
		<h2>경찰정_전국 경찰서별 강력범죄 발생 현황</h2>
		<hr/>
		<select name="year" id="year">
			<c:forEach var="i" begin="2015" end="2021">
				<option <c:if test="${whichYear == i}">selected</c:if> >${i}</option>
			</c:forEach>			
		</select>
		<p>
			<input type="button" value="강력범죄자료조회" onclick="getCrimeData()" class="btn btn-success mt-3"/>
			<input type="button" value="조회자료DB저장" onclick="saveCrimeData()" class="btn btn-success mt-3"/>
			<input type="button" value="DB자료 삭제" onclick="saveCrimeDelete()" class="btn btn-success mt-3"/>
						<input type="button" value="DB자료출력" onclick="searchDBCrimeData()" class="btn btn-primary mt-3"/>
		</p>
		<p>
		
		정렬순서 :	<input type="radio" name="crimeOrder" id="crimeOrder" value="asc" <c:if test="${whichOrder eq null || whichOrder=='asc'}">checked</c:if>/>오름차순 &nbsp;
						<input type="radio" name="crimeOrder" id="crimeOrder" value="desc" <c:if test="${whichOrder=='desc'}">checked</c:if>/> 내림차순&nbsp;
						<input type="button" value="경찰서순서 자료조회" onclick="searchPoliceCrimeData()" class="btn btn-primary mt-3"/>
		</p>
		<p>
			<input type="button" value="돌아가기" onclick="location.href='${ctp}/ApiTest.st'" class="btn btn-warning"/>
		</p>
		<hr/>
		<div id="demo"></div>
		<c:set var="totrob" value="0"/>
		<c:set var="totmurder" value="0"/>
	 	<c:set var="tottheft" value="0"/>
		<c:set var="totviolence" value="0"/>
		
		<c:if test="${vos ne null}">
		<table class="table table-bordered">
			<tr>
				<th>번호</th>
				<th>년도</th>
				<th>경찰서</th>
				<th>강도</th>
				<th>살인</th>
				<th>절도</th>
				<th>폭행</th>
			</tr>
			<c:forEach var="vo" items="${vos}" varStatus="st">
				<tr>
					<td>${st.count}</td>
					<td>${vo.year}</td>
					<td>${vo.police}</td>
					<td>${vo.robbery}</td>
					<td>${vo.murder}</td>
					<td>${vo.theft}</td>
					<td>${vo.violence}</td>
					<c:set var="totrob" value="${totrob + vo.robbery}"/>
					<c:set var="totmurder" value="${totmurder + vo.murder}"/>
					<c:set var="tottheft" value="${tottheft + vo.theft}"/>
					<c:set var="totviolence" value="${totviolence + vo.violence}"/>
				</tr>
			</c:forEach>
				<tr>
				<td colspan="3">총계</td>
				<td>${totrob}</td>
				<td>${totmurder}</td>
				<td>${tottheft}</td>
				<td>${totviolence}</td>
				</tr>
				<c:set var="avgrob" value="${totrob / vosSize}"/>
				<c:set var="avgmurder" value="${totmurder / vosSize}"/>
				<c:set var="avgtheft" value="${tottheft / vosSize}"/>
				<c:set var="avgviolence" value="${totviolence / vosSize}"/>
				<tr>
				<td colspan="3">평균</td>
				<td>${avgrob}</td>
				<td>${avgmurder}</td>
				<td>${avgtheft}</td>
				<td>${avgviolence}</td>
				</tr>
		</table>
		</c:if>
	</div>
<p><br/></p>
<jsp:include page="/include/footer.jsp"/>
</body>
</html>