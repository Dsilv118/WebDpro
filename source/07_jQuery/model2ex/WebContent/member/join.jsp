<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="${conPath }/css/join.css" rel="stylesheet">
	<link rel="stylesheet" href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
  <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
  <script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
  <script>
  	$(function(){
  		$('input[name="mid"]').keyup(function(){
  			var mid = $(this).val();
  			if(mid.length<2) {
  				$('#idConfirmResult').text('아이디는 2글자 이상');
  			} else {
  				$.ajax({
  					url : '${conPath }/midConfirm.do',
  					type : 'get',
  					data : 'mid='+mid,
  					dataType : 'html',
  					success : function(data){
  						$('#idConfirmResult').html(data);
  					},
  				}); // ajax함수
  			}  // if
  		}); // keyup event(id 중복 확인용)
  		
       /*$('#memail').keyup(function(){
  			var memail = $(this).val();
  			$.ajax({
  				url : '${conPath}/memailConfirm.do',
  				type : 'get',
  				data : 'memail='+memail,
  				dataType : 'html',
  				success : function(data) {
  					$('#emailConfirmResult').html(data);
  				}
  			}); // ajax 함수
  		}); // keyup event(email 중복 확인용) */
  		
  		var patternMemail = /^[a-zA-Z0-9_\.]+@[a-zA-Z0-9_]+(\.\w+){1,2}$/;
  		$('input[name="memail"]').keyup(function(){
  			let memail = $(this).val();
  			if(!memail){
  				$('#emailConfirmResult').html(' &nbsp; ');
  			}else if(!memail.match(patternMemail)){
  				$('#emailConfirmResult').html('<b>메일 형식을 지켜 주세요</b>');
  			}else{
  				$.ajax({
  					url : '${conPath}/memailConfirm.do',
  					type : 'get',
  					data : 'memail='+memail,
  					dataType : 'html',
  					success : function(data){
  						$('#emailConfirmResult').html(data);
  					},
  				});
  			}
  		});
  		
  		$('#mpw, #mpwChk').keyup(function(){
  			var pw = $('#mpw').val();
  			var pwChk = $('#mpwChk').val();
  			if(pw == pwChk) {
  				$('#pwChkResult').text('비밀번호 일치');
  			} else {
  				$('#pwChkResult').text('비밀번호 불일치');
  			}
  		}); // keyup event(비밀번호 일치 확인용)
  		
  		$('form').submit(function(){
  	  		// "사용 가능한 ID입니다"('#idConfirmResult'), "비밀번호 일치"('#pwChkResult') 가 출력되었을 경우만 submit 가능
  	  		var idConfirmResult = $('#idConfirmResult').text().trim();
  	  		var pwChkResult     = $('#pwChkResult').text().trim();
  	  		if(idConfirmResult != '사용 가능한 ID입니다') {
  	  			alert('사용 가능한 ID인지 확인 요망');
  	  			return false; // submit 제한
  	  		} else if(pwChkResult != '비밀번호 일치') {
  	  			alert('비밀번호를 확인하세요');
  	  			$('#mpw').focus();
  	  			return false;
  	  		}
  		});
  		
  	});
  </script>
  <script>
		$( function() {
		  $( "#datepicker" ).datepicker({
		 	 dateFormat: "yy-mm-dd",
		 	 dayNamesMin: [ "일", "월", "화", "수", "목", "금", "토" ],
		    monthNamesShort: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
		 	 changeMonth: true,  // 월을 바꿀수 있는 셀렉트 박스를 표시한다.
		 	 changeYear: true,   // 년을 바꿀수 있는 셀렉트 박스를 표시한다.
		    showMonthAfterYear: true,
		    yearSuffix: '년',
		    showOtherMonths: true, // 현재 달이아닌 다른 달 날짜를 회색으로 표시한다.
		    minDate: new Date(1920, 1 - 1, 1), // 1920년 1월 일을 최소 날짜로 세팅
		    maxDate: 'y', // 현재 날짜 이전만 선택 가능
		    dayNamesMin: ['일', '월', '화', '수', '목', '금', '토'],
		  });
		} );
   </script>
</head>
<body>
	<jsp:include page="../main/header.jsp"/>
	<div id="joinForm_wrap">
		<form action="${conPath }/join.do" method="post" enctype="multipart/form-data">
			<div id="join_title">회원가입</div>
			<table>
				<tr>
					<th><label for="mid">아이디</label></th>
					<td>
						<input type="text" name="mid" id="mid" class="mid" required="required">
						<div id="idConfirmResult"> &nbsp; &nbsp; &nbsp; </div>
					</td>
				</tr>
				<tr>
					<th><label for="mpw">비밀번호</label></th>
					<td><input type="password" name="mpw" id="mpw" class="mpw" required="required"></td>
				</tr>
				<tr>
					<th><label for="mpwChk">비밀번호 확인</label></th>
					<td>
						<input type="password" name="mpwChk" id="mpwChk" class="mpwChk" required="required">
						<div id="pwChkResult"> &nbsp; &nbsp;  &nbsp; </div>
					</td>
				</tr>
				<tr>
					<th><label for="mname">이름</label></th>
					<td><input type="text" name="mname" id="mname" class="mname"></td>
				</tr>
				<tr>
					<th><label for="memail">이메일</label></th>
					<td>
						<input type="text" name="memail" id="memail" class="memail">
						<div id="emailConfirmResult"> &nbsp; &nbsp; &nbsp; </div>
					</td>
				</tr>
				<tr>
					<th>사진</th>
					<td><input type="file" name="mphoto" id="mphoto" class="mphoto"></td>
				</tr>				
				<tr>
					<th>생년월일</th>
					<td><input type="text" name="mbirth" id="datepicker" class="mbirth"></td>
				</tr>
				<tr>
					<th><label for="maddress">주소</label></th>
					<td><input type="text" name="maddress" id="maddress" class="maddress"></td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="가입하기" class="joinBtn_style">
						<input type="reset" value="다시하기" class="joinBtn_style">
						<input type="button" value="로그인" class="joinBtn_style" onclick="location.href='loginView.do'">
					</td>
				</tr>
			</table>
		</form>
	</div>
	<jsp:include page="../main/footer.jsp"/>
</body>
</html>













