<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctp" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>upLoad1.jsp</title>
	<jsp:include page="/include/bs4.jsp"/>
	<script>
		'use strict';
	
		function fCheck(){
			let fname = document.getElementById("file").value;
			
			//alert("파일명" + fName);
			
			//확장자 추출
			let ext = fname.substring(fname.lastIndexOf(".")+1).toUpperCase();
			
			
			let maxSize = 1024 * 1024 *15; //15메가바이트 용량의 파일까지 업로드 가능함.
			
			if(fname.trim()==""){ //파일명 유무 체크(제일 먼저 할것) 파일 없는데 다른 체크하면 오류나지?
				alert("업로드할 파일을 선택하세요.");
				return false;
			}
			
			let fileSize = document.getElementById("file").files[0].size;
			
			if(ext != "JPG" && ext != "GIF" && ext != "ZIP" && ext != "HWP" && ext != "PNG" ){
				alert("업로드 가능한 파일은 '.jpg/.gif/.zip/.hwp'입니다. ");
			}
			else if(fileSize>maxSize){ //파일 용량 검사단.
				alert("업로드 가능한 용량은 15메가바이트입니다.")
			}
			else{
				//alert("전송완료");
				myform.submit();
			}
			
		}
		
		//동적 폼 만들기(파일 업로드 박스 추가하기.)
		let appendCnt = 1;
		function fileboxAppend(){
			appendCnt++;
			let fileBox = '';
			fileBox +='<dic id="fBox'+appendCnt+'">';
			fileBox +='<input type="file" name="fname'+appendCnt+'" id="file'+appendCnt+'" class="form-control-file border mt3" style="float:left;width:85%"/>';
			fileBox +='<input type="button" value="삭제" onclick="deleteBox('+appendCnt+')" class="btn btn-danger form-control mt3" style="float:left;width:10%"/>';
			fileBox +='';
			fileBox +='';
			fileBox +='</div>';
			$("#fileBoxAppend").append(fileBox);
			
		}
		
		function deleteBox(cnt){
			$("#fBox"+cnt).remove();
		}
		
		
	</script>
</head>
<body>
<jsp:include page="/include/header.jsp"/>
<p><br/></p>	
	<div class="container">
		<h2>파일 업로드 처리 (멀티파일 업로드2)</h2>
		<p>cos 라이브러리를 이용한 파일 업로드</p>
		<div>(https://servlets.com/cos/)</div>
		<hr/>
		<form name="myform" method="post" action="${ctp}/FileUpLoad3Ok.st" enctype="multipart/form-data"> <!-- 파일 전송시에는 무조건 인코딩 타입(enctype)을 써주어야함 -->
			파일명 :
			<div>
			<input type="button" value="파일박스 추가" onclick="fileboxAppend()" class="btn btn-info mt-3"/>
			<input type="file" name="fname1" id="file1" class="form-control-file border mt-3"/>
			</div>
			<div id="fileBoxAppend"></div>
			<input type="button" value="전송" onclick="fCheck()" class="btn btn-success form-control mt-3"/>
		</form>
		<hr/>
		<input type="button" value="다운로드 사이트로 이동" onclick="location.href='${ctp}/DownLoad.st'" class="btn btn-primary form-control"/>
	</div>
<p><br/></p>
<jsp:include page="/include/footer.jsp"/>
</body>
</html>