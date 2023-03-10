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
</head>
<body>
	<c:if test="${empty getMember }">
		<script>location.href='${conPath}/loginView.do';</script>
		<link href="${conPath }/css/member.css" rel="stylesheet" type="text/css">
	</c:if>
	<form action="${conPath }/modify.do" method="post" enctype="multipart/form-data">
		<input type="hidden" name="dbMpw" value="${getMember.mpw }">
		<input type="hidden" name="dbMphoto" value="${getMember.mphoto }">
		<table>
			<caption>정보수정</caption>
			<tr>
				<th>아이디</th>
				<td><input type="text" name="mid" value="${getMember.mid }" readonly="readonly" size="3"></td>
				<td rowspan="4"><img src="${conPath }/memberPhotoUp/${getMember.mphoto }" alt="${member.mname }사진" size="3"></td>
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
				<th><input type="text" name="mname" value="${getMember.mname }" required="required"></th>
			</tr>
			<tr>
				<th>메일</th>
				<td colspan="2"><input type="text" name="memail" value="${getMember.memail }"></td>
			</tr>
			<tr>
				<th>사진</th>
				<td colspan="2"><input type="file" name="mphoto"></td>
			</tr>
			<tr>
				<th>생년월일</th>
				<td colspan="2"><input type="date" name="mbirth" value="${getMember.mbirth }"></td>
			</tr>
			<tr>
				<th>주소</th>
				<td colspan="2"><input type="text" name="maddress" value="${getMember.maddress }"></td>
			</tr>
			<tr>
				<td colspan="3">
					<input type="submit" value="정보수정">
					<input type="reset" value="초기화">
					<input type="button" value="이전" onclick="history.back()">
					<input type="button" value="회원탈퇴" onclick="location.href='${conPath}/withdrawal.do'">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>






























