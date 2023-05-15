<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctp" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>upLoad4.jsp</title>
	<jsp:include page="/include/bs4.jsp"/>
	<script>
		'use strict';
	
		function fCheck(){
			let fName1 = document.getElementById("file1").value;
			
			//alert("파일명" + fName);
			
			//확장자 추출
			let ext1 = fName1.substring(fName1.lastIndexOf(".")+1).toUpperCase();
			
			
			let maxSize = 1024 * 1024 *15; //15메가바이트 용량의 파일까지 업로드 가능함.
			
			if(fName1.trim()==""){ //파일명 유무 체크(제일 먼저 할것) 파일 없는데 다른 체크하면 오류나지?
				alert("업로드할 파일을 선택하세요.");
				return false;
			}
			
			let fileSize1 = document.getElementById("file1").files[0].size;
			
			if(ext1 != "JPG" && ext1 != "GIF" && ext1 != "ZIP" && ext1 != "HWP" && ext1 != "PNG" ){
				alert("업로드 가능한 파일은 '.jpg/.gif/.zip/.hwp'입니다. ");
			}
			else if(fileSize1>maxSize){ //파일 용량 검사단.
				alert("업로드 가능한 용량은 15메가바이트입니다.")
			}
			else{
				//alert("전송완료");
				myform.submit();
			}
			
		}
		
		
	</script>
</head>
<body>
<jsp:include page="/include/header.jsp"/>
<p><br/></p>	
	<div class="container">
		<h2>파일 업로드 처리 (멀티파일 업로드3)</h2>
		<p>cos 라이브러리를 이용한 파일 업로드</p>
		<div>(https://servlets.com/cos/)</div>
		<div>여러개의 파일을 선택할 경우에는 'ctrl+클릭/shift+클릭'하시주.</div>
		<hr/>
		<form name="myform" method="post" action="${ctp}/FileUpLoad4Ok.st" enctype="multipart/form-data"> <!-- 파일 전송시에는 무조건 인코딩 타입(enctype)을 써주어야함 -->
			파일명 :
			<input type="file" name="fname1" id="file1" multiple class="form-control-file border mt-3"/>
			<input type="button" value="전송" onclick="fCheck()" class="btn btn-success form-control mt-3"/>
		</form>
		<hr/>
		<input type="button" value="다운로드 사이트로 이동" onclick="location.href='${ctp}/DownLoad.st'" class="btn btn-primary form-control"/>
	</div>
<p><br/></p>
<jsp:include page="/include/footer.jsp"/>
</body>
</html>