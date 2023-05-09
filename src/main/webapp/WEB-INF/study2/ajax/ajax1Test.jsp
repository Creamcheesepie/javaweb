<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctp" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>ajax1.jsp</title>
	<jsp:include page="/include/bs4.jsp"/>
	<script type="text/javascript">
		'use strict'
		//일반 검색
		function idCheck(){
			//let mid = myform.mid.value;
			//let mid = document.getElementById("mid").value;
			let mid = $("#mid").val() 
			
			if(mid.trim()==""){
				alert("아이디를 입력하세요")
				//document.myform.mid.focus();
				//document.getElementById("mid").focus();
				$("#mid").focus();
				return false;
			}
			else{
				location.href="${ctp}/AjaxTest1_1?mid="+mid;
			}
			
		}
		
		//ajax를 이용한 검색
		function idCheck1(){
			let mid = $("#mid").val();
			
			if(mid.trim() == ""){
				alert("찾으실 분 이름은 알려줘야해유...");
				$("#mid").focus();
				return false;
			}
			
					/* mid: mid,
					gneder: gender,
					...
					변수명: 내용 */
			let query = {
					mid: mid,
			}
			
			$.ajax({
				url : "${ctp}/AjaxTest1_2",
				type: "post",
				data: query,
				contextType: "application/json",
				charset : "utf-8",
				success : function(res){
					alert("서버에 다녀왔습니다요. 지가 두 눈으로 똑똑히 봤구먼유!!"+res);
					$("#demo").html(res);
				},
				arror : function(){
					alert("서버에 못다녀왔구먼유...");
				}
			});
		}
			
			
			function idCheck22(){
				let mid = $("#mid").val();
				
				if(mid.trim() == ""){
					alert("찾으실 분 이름은 알려줘야해유...");
					$("#mid").focus();
					return false;
				}
				
				$.ajax({
					url : "${ctp}/AjaxTest2",
					type : "post",
					data : {mid:mid},
					success : function(res){
						alert("서버에 다녀왔구만유. 지가 두 눈으로 똑똑히 봤구먼유!");
						$("#demo").html(res);
						let str = res.split("/");
						$("#tmid").html(str[0]);
						$("#name").html(str[1]);
						$("#nickName").html(str[2]);
						$("#gender").html(str[3]);
						$("#point").html(str[4]);
						
					},
					error : function(){
						alert("문제가 있서 서버에 갔다오지 못했구먼유...");
					}
				});
			}
			
			
			
			
			function idCheck33(){
				let mid = $("#mid").val();
				
				if(mid.trim() == ""){
					alert("찾으실 분 이름은 알려줘야해유...");
					$("#mid").focus();
					return false;
				}
				
				$.ajax({
					type :"post",
					url  :"${ctp}/AjaxTest3",
					data :{mid:mid},
					success:function(res){
						res = res.substring(res.indexOf("[")+1,res.lastIndexOf("]"));
						$("#demo").html(res);
						$("#tMid").html(res.substring(res.indexOf("mid=")+4,res.indexOf(",",res.indexOf("mid="))));
		    		$("#name").html(res.substring(res.indexOf("name=")+5,res.indexOf(",",res.indexOf("name="))));
						$("#nickName").html(res.substring(res.indexOf("nickName=")+9,res.indexOf(",",res.indexOf("nickName="))));
						$("#gender").html(res.substring(res.indexOf("gender=")+7,res.indexOf(",",res.indexOf("gender="))));
						$("#point").html(res.substring(res.indexOf("point=")+6,res.indexOf(",",res.indexOf("point="))));
					},
					error : function(){
						alert("문제가 있서 서버에 갔다오지 못했구먼유...");
					}
				})
			}
			
			function idCheck4(){
					let mid = $("#mid").val();
					
					if(mid.trim() == ""){
						alert("찾으실 분 이름은 알려줘야해유...");
						$("#mid").focus();
						return false;
					}
				
				
				$.ajax({
					type : "post",
					url  : "${ctp}/AjaxTest4",
					data : {mid : mid},
					success : function(res){
						$("#demo").html(res);
						let js = JSON.parse(res);
						
						$("#tmid").html(js.mid);
						$("#name").html(js.name);
						$("#nickName").html(js.nickName);
						$("#gender").html(js.gender);
						$("#point").html(js.point);
						
					},
					error : function(){
						alert("문제가 있서 서버에 갔다오지 못했구먼유...");
					}
				});
			}
			
			//vos 형태의 값을 처리
			function idCheck5(){
				let mid = $("#mid").val();
				
				if(mid.trim() == ""){
					alert("찾으실 분 이름은 알려줘야해유...");
					$("#mid").focus();
					return false;
				}
				
				$.ajax({
					type : "post",
					url : "${ctp}/AjaxTest5",
					data : {mid:mid},
					success:function(res){
						$("#demo").html(res);
						let js = JSON.parse(res);
//						console.log("js",js);
						/*
						$("#tmid").html(js[0].mid);
						$("#name").html(js[0].name);
						$("#nickName").html(js[0].nickName);
						$("#gender").html(js[0].gender);
						$("#point").html(js[0].point);
						*/
						let tMid="",tName="",tNickName="",tGender="",tPoint="";
						for(let j of js){
							tMid += j.mid+"/";
							tName += j.name+"/";
							tNickName += j.nickName+"/";
							tGender += j.gender+"/";
							tPoint += j.point+"/";
						}
						$("#tmid").html(tMid);
						$("#name").html(tName);
						$("#nickName").html(tNickName);
						$("#gender").html(tGender);
						$("#point").html(tPoint);
						
					},
					error : function(){
						alert("전송오류");
					}
					
				})
				
			}
		
		
	</script>
</head>
<body>
<jsp:include page="/include/header.jsp"/>
<p><br/></p>	
	<div class="container">
	<h2>AJAX1 테슷흐</h2>
	<hr/>
	<form name="myform">
	 <div>아이디 <input type="text" name="mid" id="mid"/>&nbsp;<input type="button" value="아이디 일반검색" onclick="idCheck()" class="btn btn-success"/></div>
	 <hr/>
	 ajax검색&nbsp;<br/>
	 <input type="button" value="아이디검색1" onclick="idCheck1()" class="btn btn-success"/><br/>
	 <input type="button" value="찾아오거라~" onclick="idCheck22()" class="btn btn-primary"/><br/>
	 <input type="button" value="찾아오거라3" onclick="idCheck33()" class="btn btn-secondary"/><br/>
	 <input type="button" value="찾아오거라4" onclick="idCheck4()" class="btn btn-secondary"/><br/>
	 <input type="button" value="찾아오거라5" onclick="idCheck5()" class="btn btn-secondary"/><br/>
	 <hr/>
	 <div class="mt-3">출력 결과 : <span id="demo"></span></div>
	 <div>
	 	<div>아이디 : <span id="tmid"></span></div>
	 	<div>성명 : <span id="name"></span></div>
	 	<div>닉네임 : <span id="nickName"></span></div>
	 	<div>성별 : <span id="gender"></span></div>
	 	<div>포인트 : <span id="point"></span></div>
	 </div>
	 <hr/>
	</form>
	</div>
<p><br/></p>
<jsp:include page="/include/footer.jsp"/>
</body>
</html>