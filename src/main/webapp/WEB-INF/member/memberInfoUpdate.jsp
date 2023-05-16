<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<c:set var="ctp" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>title</title>
	<jsp:include page="/include/bs4.jsp"/>
	<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<script src="${ctp}/js/postCodeFind.js"></script>
	<script>
	'use strict'
	//아이디와 중복버튼을 클릭햇는지의 여부를 확인하기위한 변수(버튼 클릭 후에는 내용 수정을 하지 못하도록(버튼을 통해서만 가능?)
	let idCheckSw = 0;
	let nickCheckSw = 0;
		
	 function fCheck() {
		//아이디 , 닉네임 중복체크 여부 검사
		//let midOk ="${midOK}"
		//let nickNameOk ="${nickNameOk}"
		/* else if(!$$inRegEx.test($$in)){
			alert("");
			myform.$$in.focus();
		} */
		
	//	let mid = myform.mid.value.trim();
		// let pwd = myform.pwd.value.trim();
		let nickName = myform.nickName.value.trim();
		let name = myform.name.value.trim();
		let email1 = myform.email1.value.trim();
		let email2 = myform.email2.value.trim();
		let email = email1+email2;
		
		
		//let midOk = "false"
		//let pwdOk = "false"
		let nickNameOk = "false"
		let nameOk = "false"
		let emailOk = "false"
		let telOk = "false"
		
				//유효성 검사 + 전화번호, 
		//const midRegEx = /^[a-zA-Z0-9]{4,20}[^\W]/; //아이디 정규식
		//const pwdRegEx = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[@$!%*#?&])[A-Za-z\d@$!%*#?&]{8,20}$/g; //비밀번호 정규식
		const nickNameRegEx = /^[a-zA-Z0-9가-힣]{2,19}[a-zA-Z0-9가-힣]*$/g; //닉네임 정규식
		const nameRegEx = /^[a-zA-Z가-힣]{1,19}[a-zA-Z가-힣]*$/g; //이름 정규식
		const emailRegEx = /[\w]+@[\w]+[.]{1}[\w]/g; //이메일 정규식
		const telRegEx = /\d{2,3}-\d{3,4}-\d{4}$/g;
		
		let tel1 = myform.tel1.value.trim();
		let tel2 = myform.tel2.value.trim();
		let tel3 = myform.tel3.value.trim();
		let tel =  tel1+"-"+tel2+"-"+tel3;
		
	
		
		//닉네임 검사
		if(nickName==""){
			alert("닉네임을 입력하세요!");
			myform.nickName.focus();
			return false;
		}
		else if(!nickNameRegEx.test(nickName)){
			alert("닉네임은 한글, 영문, 숫자까지 입력할 수 있습니다.");
			myform.nickName.focus();
			return false;
		}else{
			nickNameOk="true";
		}
		
		//이름 검사
		if(name==""){
			alert("이름을 입력하세요!");
			myform.name.focus();
			return false;
		}
		else if(!nameRegEx.test(name)){
			alert("이름은 한글, 영문까지 입력할 수 있습니다.");
			myform.nickName.focus();
			return false;
		}else{
			nameOk="true";			
		}
		
		
		//사진 업로드 처리
		let photoName = document.getElementById("photoFile").value;
		
		let photoNameExe = photoName.substring(photoName.lastIndexOf(".")+1).toLowerCase();
		
		let maxSize = 1024*1024*10;
		
		
		if(photoName.trim()==""){
			photoName = "%{vo.photo}"; // 수정시에 사진을 넣지 않았으면 기존 사진을 유지해야함.
		}
		else if(photoName.trim()!=""){
			let fileSize = document.getElementById("photoFile").files[0].size;
			
			if(photoNameExe!="jpg" && photoNameExe!="png" && photoNameExe!="gif" ){
				alert("프로필 사진으로 업로드 가능한 이미지는 jpg,png,gif 확장자를 가진 이미지 파일입니다.");
				return false;
			}
			
			if(fileSize>maxSize){
				alert("프로필 사진으로 업로드 가능한 이미지의 크기는 10mb까지입니다.");
				return false;
			}
		
		}
		
		//이메일 검사
		if(email1==""){
			alert("이메일을 입력하세요!");
			myform.email1.focus();
			return false;
		}
		else if(!emailRegEx.test(email)){
			alert("이메일을 형식에 맞게 입력해주세요.");
			myform.birthday.focus();
			return false;
		}	else{
			emailOk="true";
		}
		
		if(tel2 !="" && tel3 != ""){
			if(!telRegEx.test(tel)){
				alert("전화번호 형식을 확인세요.");
				myform.tel.focus();
				return false;
			}
			else{
				telOk="true";
			}
		}
		
		
		//주소 묶어주기.
		let postcode = myform.postcode.value + " ";
		let roadAddress = myform.roadAddress.value + " ";
		let detailAddress = myform.detailAddress.value + " ";
		let extraAddress = myform.extraAddress.value;
		myform.address.value  = postcode +"/"+ roadAddress +"/"+ detailAddress+"/"+ extraAddress +"/";
		
		//
		
		/*
			if(sMidOk == null || sMidOk == "no"){
			alert("아이디 중복체크를 해주세요!");
			return false;
		}
		
		if(sNickNameOk == null || sNickNameOk == "no"){
			alert("닉네임 중복체크를 해주세요!");
			return false;
		} 
		*/
		
		
		if(nickCheckSw == 0){
			alert("닉네임 중복체크 버튼을 눌러주세요")
			document.getElementById("nickNameBtn").focus();
		}
		else if(nickNameOk=="true" && nameOk=="true" && emailOk=="true" ){
			myform.tel.value = tel;
			myform.email.value=email;
			myform.submit();
		}
		
	}
	
	
	function nickCheck(){

		let nickName = myform.nickName.value;
		if(nickName.trim() == '${sNickName}'){
			nickCheckSw = 1;
			alert("기존의 닉네임을 그대로 사용합니다.")
			myform.nickName.readOnly="true";
			return 0;
		}
		
		let url = "${ctp}/MemberNickNameCheck.mem?nickName="+nickName;
		
		
		if(nickName.trim()==""){
			alert("닉네임을 입력하세요!");
			myform.nickName.focus();
		}
		else{
			nickCheckSw = 1;
			myform.nickName.readOnly="true";
			window.open(url,"nWin","width=580px,height=250px");
		}
	}
	
	
	</script>
</head>
<body>
<jsp:include page="/include/header.jsp"/>
<p><br/></p>	
	<div class="container">
		<form name="myform" method="post" action="${ctp}/MemberUpdateOk.mem" class="was-validated" enctype="multipart/form-data">
    <h2>회원 정보 수정</h2>
    <br/>
    <div class="form-group">
			아이디 : ${sMid}
    </div>
    <div class="form-group">
      <label for="nickName">닉네임 : &nbsp; &nbsp;<input type="button" value="닉네임 중복체크" name="nickNameBtn" id="nickNameBtn" class="btn btn-secondary btn-sm" onclick="nickCheck()"/></label>
      <input type="text" class="form-control" name="nickName" id="nickName" value="${sNickName}" required />
    </div>
    <div class="form-group">
      <label for="name">성명 :</label>
      <input type="text" class="form-control" name="name" id="name" value="${vo.name}"  required />
    </div>
    <div class="form-group">
      <label for="email1">Email address:</label>
        <div class="input-group mb-3">
          <input type="text" class="form-control" id="email1" name="email1" value="${email1}" required />
          <div class="input-group-append">
            <select name="email2" class="custom-select">
              <option value="@naver.com"   <c:if test="${email2 == 'naver.com'}">selected</c:if>>naver.com</option>
              <option value="@hanmail.net" <c:if test="${email2 == 'hanmail.net'}">selected</c:if>>hanmail.net</option>
              <option value="@hotmail.com" <c:if test="${email2 == 'hotmail.com'}">selected</c:if>>hotmail.com</option>
              <option value="@gmail.com"   <c:if test="${email2 == 'gmail.com'}">selected</c:if>>gmail.com</option>
              <option value="@nate.com"    <c:if test="${email2 == 'nate.com'}">selected</c:if>>nate.com</option>
              <option value="@yahoo.com"   <c:if test="${email2 == 'yahoo.com'}">selected</c:if>>yahoo.com</option>
            </select>
          </div>
        </div>
    </div>
    <div class="form-group">
      <div class="form-check-inline">
        <span class="input-group-text">성별 :</span> &nbsp; &nbsp;
        <label class="form-check-label">
          <input type="radio" class="form-check-input" name="gender" value="남자" <c:if test="${vo.gender=='남자'}">checked</c:if>>남자
        </label>
      </div>
      <div class="form-check-inline">
        <label class="form-check-label">
          <input type="radio" class="form-check-input" name="gender" value="여자" <c:if test="${vo.gender=='여자'}">checked</c:if>>여자
        </label>
      </div>
    </div>
    <div class="form-group">
      <label for="birthday">생일</label>
      <input type="date" name="birthday" class="form-control" value="${birthday}"/>
    </div>
    <div class="form-group">
      <div class="input-group mb-3">
        <div class="input-group-prepend">
          <span class="input-group-text">전화번호 :</span> &nbsp;&nbsp;
            <select name="tel1" class="custom-select">
              <option value="010" ${tel1=="010" ? "selected" : ""}>010</option>
              <option value="02"  ${tel1=="02" ? "selected" : ""}>서울</option>
              <option value="031" ${tel1=="031" ? "selected" : ""}>경기</option>
              <option value="032" ${tel1=="032" ? "selected" : ""}>인천</option>
              <option value="041" ${tel1=="041" ? "selected" : ""}>충남</option>
              <option value="042" ${tel1=="042" ? "selected" : ""}>대전</option>
              <option value="043" ${tel1=="043" ? "selected" : ""}>충북</option>
              <option value="051" ${tel1=="051" ? "selected" : ""}>부산</option>
              <option value="052" ${tel1=="052" ? "selected" : ""}>울산</option>
              <option value="061" ${tel1=="061" ? "selected" : ""}>전북</option>
              <option value="062" ${tel1=="062" ? "selected" : ""}>광주</option>
            </select>-
        </div>
        <input type="text" name="tel2" value="${tel2}" size=4 maxlength=4 class="form-control"/>-
        <input type="text" name="tel3" value="${tel3}" size=4 maxlength=4 class="form-control"/>
      </div>
    </div>
    <div class="form-group">
      <label for="address">주소</label>
      <input type="hidden" name="address" id="address">
      <div class="input-group mb-1">
        <input type="text" name="postcode" id="sample6_postcode" value="${postcode}" placeholder="우편번호" class="form-control">
        <div class="input-group-append">
          <input type="button" onclick="sample6_execDaumPostcode()" value="우편번호 찾기" class="btn btn-secondary">
        </div>
      </div>
      <input type="text" name="roadAddress" id="sample6_address" size="50"  value="${roadAddress}" placeholder="주소" class="form-control mb-1">
      <div class="input-group mb-1">
        <input type="text" name="detailAddress" id="sample6_detailAddress" value="${detailAddress}" placeholder="상세주소" class="form-control"> &nbsp;&nbsp;
        <div class="input-group-append">
          <input type="text" name="extraAddress" id="sample6_extraAddress"  value="${extraAddress}" placeholder="참고항목" class="form-control">
        </div>
      </div>
    </div>
    <div class="form-group">
      <label for="homepage">Homepage address:</label>
      <input type="text" class="form-control" name="homePage" value="${vo.homePage}" placeholder="홈페이지를 입력하세요." id="homePage"/>
    </div>
    <div class="form-group">
      <label for="name">직업</label>
      <select class="form-control" id="job" name="job">
        <!-- <option value="">직업선택</option> -->
        <option ${vo.job == '학생' ? selected : "" }>학생</option>
        <option ${vo.job == '회사원' ? selected : "" }>회사원</option>
        <option ${vo.job == '공무원' ? selected : "" }>공무원</option>
        <option ${vo.job == '군인' ? selected : "" }>군인</option>
        <option ${vo.job == '의사' ? selected : "" }>의사</option>
        <option ${vo.job == '법조인' ? selected : "" }>법조인</option>
        <option ${vo.job == '세무인' ? selected : "" }>세무인</option>
        <option ${vo.job == '자영업' ? selected : "" }>자영업</option>
        <option ${vo.job == '기타' ? selected : "" }>기타</option>
      </select>
    </div>
    <div class="form-group">
      <!-- <div class="form-check-inline">
        <span class="input-group-text">취미</span> &nbsp; &nbsp;
        <label class="form-check-label">
          <input type="checkbox" class="form-check-input" value="등산" name="hobby"/>등산
        </label>
      </div>
      <div class="form-check-inline">
        <label class="form-check-label">
          <input type="checkbox" class="form-check-input" value="낚시" name="hobby"/>낚시
        </label>
      </div>
      <div class="form-check-inline">
        <label class="form-check-label">
          <input type="checkbox" class="form-check-input" value="수영" name="hobby"/>수영
        </label>
      </div>
      <div class="form-check-inline">
        <label class="form-check-label">
          <input type="checkbox" class="form-check-input" value="독서" name="hobby"/>독서
        </label>
      </div>
      <div class="form-check-inline">
        <label class="form-check-label">
          <input type="checkbox" class="form-check-input" value="영화감상" name="hobby"/>영화감상
        </label>
      </div>
      <div class="form-check-inline">
        <label class="form-check-label">
          <input type="checkbox" class="form-check-input" value="바둑" name="hobby"/>바둑
        </label>
      </div>
      <div class="form-check-inline">
        <label class="form-check-label">
          <input type="checkbox" class="form-check-input" value="축구" name="hobby"/>축구
        </label>
      </div>
      <div class="form-check-inline">
        <label class="form-check-label">
          <input type="checkbox" class="form-check-input" value="기타" name="hobby" checked/>기타
        </label>
      </div> -->
      취미 : 
      <c:set var="varHobbys" value="${fn:split('등산/낚시/수영/독서/영화감상/바둑/축구/기타','/')}"/>
      <c:forEach var="tempHobby" items="${varHobbys}" varStatus="st">
      	<input type="checkbox" name="hobby" value="${tempHobby}" <c:if test="${fn:contains(hobby,varHobbys[st.index]) }">checked</c:if>/>${tempHobby}
      </c:forEach>
    </div>
    <div class="form-group">
      <label for="content">자기소개</label>
      <textarea rows="5" class="form-control" id="content" name="content" placeholder="자기소개를 입력하세요.">${vo.content}</textarea>
    </div>
    <div class="form-group">
      <div class="form-check-inline">
        <span class="input-group-text">정보공개</span>  &nbsp; &nbsp;
        <label class="form-check-label">
          <input type="radio" class="form-check-input" name="userInfoSw" value="공개"  ${vo.userInfoSw=='공개'?"checked":""}/>공개
        </label>
      </div>
      <div class="form-check-inline">
        <label class="form-check-label">
          <input type="radio" class="form-check-input" name="userInfoSw" value="비공개" ${vo.userInfoSw=='비공개'?"checked":""}/>비공개
        </label>
      </div>
    </div>
    <div  class="form-group">
      회원 사진(파일용량:2MByte이내) : 
      <img src="${ctp}/images/member/${vo.photo}" width="150px"/>
      <input type="file" name="photoFile" id="photoFile" class="form-control-file border"/>
    </div>
    <button type="button" class="btn btn-secondary" onclick="fCheck()">회원정보수전</button> &nbsp;
    <button type="reset" class="btn btn-secondary">다시작성</button> &nbsp;
    <button type="button" class="btn btn-secondary" onclick="locction.href='${ctp}/MemberMain.mem'">돌아가기</button>
    <input type=hidden name="tel" id="tel"/>
    <input type=hidden name="email" id="email"/>
  </form>
	</div>
<p><br/></p>
<jsp:include page="/include/footer.jsp"/>
</body>
</html>