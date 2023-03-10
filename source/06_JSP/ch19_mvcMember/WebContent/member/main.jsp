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
	<link href="${conPath }/css/member.css" rel="stylesheet" type="text/css">
</head>
<body>
	<c:set var="FAIL" value="0"/>      <!-- ID중복 -->
	<c:if test="${not empty loginFail}">
		<script>
			alert('로그인 실패했습니다. ID와 PW를 다시 확인해주세요');
			history.back();
		</script>
	</c:if>
	
	<c:if test="${not empty modifyResult }">
		<script>alert('${modifyResult }');</script>
	</c:if>
	<c:if test="${not empty modifyErrorMsg }">
		<script>
			alert('${modifyErrorMsg }');
			history.back();
		</script>
	</c:if>
	
	<c:if test="${not empty withdrawalResult }">
		<script>
			alert('${withdrawalResult }');
		</script>
	</c:if>
	<c:if test="${empty getMember }"> <!-- 로그인 전 화면 -->
		<p>로그인 상태가 아닙니다</p>
		<hr>
		<p>
			<input type="button" value="로그인" onclick="location.href='${conPath}/loginView.do'">
			<input type="button" value="회원가입" onclick="location.href='${conPath}/joinView.do'">
			<input type="button" value="전체회원보기" onclick="location.href='${conPath}/allView.do'">
		</p>
	</c:if>
	<c:if test="${!empty getMember}"> <!-- 로그인 후 화면 -->
		<p>${getMember.mname }(${getMember.mid })님 어서오세요</p>
		<hr>
		<p>
			<input type="button" value="정보수정" onclick="location.href='${conPath}/modifyView.do'">
			<input type="button" value="로그아웃" onclick="location.href='${conPath}/logout.do'">
			<input type="button" value="전체회원보기" onclick="location.href='${conPath}/allView.do'">
		</p>
	</c:if>
</body>
</html>