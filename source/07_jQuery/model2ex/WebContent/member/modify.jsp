<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="${conPath }/css/style.css" rel="stylesheet" type="text/css">
	<link rel="stylesheet" href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
	<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
  <script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
	<script>
		$(function(){
	 		var patternMemail = /^[a-zA-Z0-9_\.]+@[a-zA-Z0-9_]+(\.\w+){1,2}$/;
	 		$('input[name="memail"]').keyup(function(){
	 			let memail = $(this).val();
	 			if(!memail || (memail == '${member.memail }')){
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
		});
	</script>
</head>
<body>
	<c:if test="${empty member }">
		<script>location.href='${conPath}/loginView.do';</script>
	</c:if>
	<jsp:include page="../main/header.jsp"/>
	<div id="content_form">
		<form action="${conPath }/modify.do" method="post" enctype="multipart/form-data">
			<input type="hidden" name="dbMpw" value="${member.mpw }">
			<input type="hidden" name="dbMphoto" value="${member.mphoto }">
			<table>
				<caption>정보수정</caption>
				<tr>
					<th>아이디</th>
					<td><input type="text" name="mid" value="${member.mid }" readonly="readonly" size="3"></td>
					<td rowspan="4"><img src="${conPath }/memberPhotoUp/${member.mphoto }" alt="${member.mname }사진" size="3"></td>
				</tr>
				<tr>
					<th>현재 비밀번호</th>
					<td><input type="password" name="oldMpw" required="required" size="3"></td>
				</tr>
				<tr>
					<th>새 비밀번호</th>
					<td><input type="password" name="mpw" size="3"></td>
				</tr>
				<tr>
					<th>이름</th>
					<th><input type="text" name="mname" value="${member.mname }" required="required"></th>
				</tr>
				<tr>
					<th>메일</th>
					<td colspan="2">
						<input type="text" name="memail" value="${member.memail }">
						<div id="emailConfirmResult"> &nbsp; &nbsp; &nbsp; </div>
					</td>
				</tr>
				<tr>
					<th>사진</th>
					<td colspan="2"><input type="file" name="mphoto"></td>
				</tr>
				<tr>
					<th>생년월일</th>
					<td colspan="2"><input type="date" name="mbirth" value="${member.mbirth }"></td>
				</tr>
				<tr>
					<th>주소</th>
					<td colspan="2"><input type="text" name="maddress" value="${member.maddress }"></td>
				</tr>
				<tr>
					<td colspan="3">
						<input type="submit" value="정보수정" class="btn">
						<input type="reset" value="초기화" class="btn">
						<input type="button" value="이전" class="btn" onclick="history.back()">
						<input type="button" value="회원탈퇴" class="btn" onclick="location.href='${conPath}/withdrawal.do'">
					</td>
				</tr>
			</table>
		</form>
	</div>
	<jsp:include page="../main/footer.jsp"/>
</body>
</html>






























