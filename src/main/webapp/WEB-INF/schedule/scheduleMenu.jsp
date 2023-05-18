<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctp" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>scheduleMenu</title>
	<jsp:include page="/include/bs4.jsp"/>
	<script>
		'use strict'
		
		$(document).ready(function(){
			$("#shceduleInputClose").hide();
		});
		
		function shceduleInputView(){ //대댓글 구현시 사용가능할듯?
			let str = '<hr/><div id="scheduleInputForm">';
			str +='<form name="myform"';
			str +='<table class="table table-bordered">';
			str +='<tr><th>일정분류</th><td>';
			str +='<select name="part" class="form-control">';
			str +='<option>모임</option>';
			str +='<option>학습</option>';
			str +='<option>업무</option>';
			str +='<option>여행</option>';
			str +='<option>기타</option>';
			str +='</select>';
			str +='</td>';
			str +='</tr>';
			str +='<tr><th>내용</th><td>';
			str +='<textarea name="content" rows="4" class="form-control"></textarea>';
			str +='</td></tr>';
			str +='<tr><td colspan="2" class="text-center">';
			str +='<input type="button" value="일정등록" onclick="scheduleInputOk()" class="btn btn-success form-control"/>';
			str +='</td></tr>';
			str +='</table>';
			str +='</form>';
			str +='</div>';
			
			$("#shceduleInputView").hide();
			$("#shceduleInputClose").show();
			$("#demo").html(str);
			$("#demo").slideDown(500);
			$("#scheduleInputForm").slideDown(500)
			
		}
		
		//일정 등록창 닫기
		function shceduleInputClose(){
			$("#shceduleInputView").show();
			$("#shceduleInputClose").hide();
			$("#scheduleInputForm").slideUp(500);
			
		}
		
		function scheduleInputOk(){
			let part = myform.part.value;
			let content = myform.content.value;
			if(content.trim == ""){
				alert("일정을 입력하세요");
				myform.content.focus();
				return false;
			}
			let query ={
					mid : '${sMid}',
					ymd : '${ymd}',
					part:part,
					content:content
			}
			$.ajax({
				type : "post",
				url : "${ctp}/ScheduleInputOk.sc",
				data : query,
				success : function(res){
					if (res=="1"){
						alert("일정이 등록되었습니다.")
						location.reload();
					}
				},
				error : function(){
					alert("전송오류")
				}
			})
		}
		
		function updateCheck(idx,part,content){
			$("#updateContent").val(content);
			$("#updatePart").val(part).prop("selected",true);
			$("#upIdx").val(idx);
		}
		
		function updateOk(){
			let upIdx = $("#upIdx").val();
			let upPart = $("#updatePart").val();
			let upContent = $("#updateContent").val();
			let query = {
				idx : upIdx,
				part : upPart,
				content : upContent,
				ymd : '${ymd}'
			}
			$.ajax({
				type:"post",
				url:"{ctp}/ScheduleUpdateOk.sc",
				data:query,
				success : function(res){
					if(res=='1'){
						alert("일정이 수정되었습니다.")
						location.reload();
					}
				},
				error : function(){
					alert("전송오류")
				}
			})
		}
		
	</script>
</head>
<body>
<jsp:include page="/include/header.jsp"/>
<p><br/></p>	
	<div class="container">
		<h4>${ymd}의 일정입니다.</h4>
		<p>오늘의 일정은 총 ${scheduleCnt}건 있습니다.</p>
		<hr/>
		<div>
			<input type="button" value="일정등록" onclick="shceduleInputView()" id="shceduleInputView" class="btn btn-primary"/>
			<input type="button" value="등록창 닫기" onclick="shceduleInputClose()" id="shceduleInputClose" class="btn btn-primary"/>
			<input type="button" value="돌아가기" onclick="location.href='${ctp}/ScheduleList.sc'" class="btn btn-warning"/>
		</div>
		<div id="demo"></div>
		<hr/>
		<c:if test="${scheduleCnt !=0}">
		<table class="table table-bordered">
			<tr>
				<th>번호</th>		
				<th>내역</th>		
				<th>분류</th>		
				<th>비고</th>		
			</tr>
			<c:forEach var="vo" items="${vos}" varStatus="st">
			<tr>
				<td>${st.count}</td>
				<td>
					${vo.content}
				</td>
				<td>${vo.part}</td>
				<td>
					<input type="button" value="수정" onclick="updateCheck('${vo.idx}','${vo.part}','${vo.content}')" class="btn btn-info" data-toggle="modal" data-target="#upDateModal"/>
					<input type="button" value="삭제" onclick="deleteCheck('${vo.idx}')" class="btn btn-danger"/>
				</td>
			</tr>
			</c:forEach>
			<tr><td colspan="4"></td></tr>
		</table>
		</c:if>
		<div class="modal fade" id="upDateModal">
  <div class="modal-dialog">
    <div class="modal-content">

      <!-- Modal Header -->
      	<div class="modal-header">
        <h4 class="modal-title">일정 수정</h4>
        <button type="button" class="close" data-dismiss="modal">&times;</button>
      	</div>
      <!-- Modal body -->
      <form name="updateform">
      	<div class="modal-body">
      	  내용:<input type="text" name="updateContent" id="updateContent" value="" placeholder="수정할 내용을 입력하세요." class="form-control"/>
      	  분류:
			      <select name="updatePart" id="updatePart" class="form-control">
							<option>모임</option>
							<option>학습</option>
							<option>업무</option>
							<option>여행</option>
							<option>기타</option>
						</select>
					<input type="hidden" name="upIdx" id="upIdx" value=""/>
      	</div>

      <!-- Modal footer -->
     	 <div class="modal-footer">
        <button type="button" class="btn btn-info" onclick="updateOk()">수정</button>
        <button type="button" class="btn btn-danger" data-dismiss="modal">닫기</button>
     	 </div>
			</form>
    	</div>
 	 </div>
	</div>
		
	</div><!-- 메인 컨테이너 끝, 닫는 태그 -->
	
<p><br/></p>
<jsp:include page="/include/footer.jsp"/>
</body>
</html>