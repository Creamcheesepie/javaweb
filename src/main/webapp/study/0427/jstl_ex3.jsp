<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>title</title>
	<jsp:include page="/include/bs4.jsp"/>
</head>
<script>
	let imgName=[];
	let imgNum=[];
	function f_imageChange(){
	let sel=document.getElementById("imageSel").value;
	demo.innerHTML='<img src="../../images/'+sel+'.jpg">'
	}
	
	function imgNameSave() {
		let sel=document.getElementById("imageSel").value;
		let name=document.getElementById("imgName").value;
		imgName.push(name);
		imgNum.push(sel);
	}
	
	function saveImgOut() {
		let str;
		str += "<div class='row'>"
		for(let i=0; i<imgNum.length;i++){
			str +="<div class='col'>"+imgName[i]+"</div>";
			str +="<div class='col'><img src='../../images/"+imgNum[i]+".jpg'></div></div>";
			demo.innerHTML=str;
		}
	}

</script>
<body>
<p><br/></p>	
	<div class="container">
		<pre>
			콤보상자에 숫자 1~6까지를 기억시키고 화면에 보여준다.(화면에 보여주는 숫자는 1~6.jpg인 그림파일이다)
			콤보상자 옆에 텍스트 박스를 위치시키고,해당 그림의 그림명을 입력 후 저장 버튼을 클릭하면
			그림명과 그림 파일명을 저장시켜준다.
			마지막으로 출력 버튼을 클릭하면 아래쪽으로 저장된 모든 그림파일과 그림파일명을 출력한다.		
		</pre>
		<form name="myform" method=get action="jstl_ex1.jsp">
		<select name="imageSel" id="imageSel" onchange="f_imageChange(this.value)">
			<c:forEach var="i" begin="1" end="6">
				<option value="${i}">그림${i}
			</c:forEach>
		</select>
		<input type="text" id="imgName" name="imgName">
		<input type="button" onclick="imgNameSave()" value="저장" class="btn btn-success">
		<input type="button" onclick="saveImgOut()" value="출력" class="btn btn-success">
		</form>
		<div id="demo" name="demo">
		</div>
		<div id="demo2" name="demo2">
			<c:forEach var="i" begin="1" end="넘겨받은 자료의 개수">
				<div class='col'>${a}</div>
				<div class='col'><img src='../../images/${a}.jpg'></div></div>
			</c:forEach>
		</div>
	</div>
<p><br/></p>
</body>
</html>