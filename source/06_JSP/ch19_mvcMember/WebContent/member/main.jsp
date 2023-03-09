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
	<c:if test="${empty getMember }">
		<p>로그인 상태가 아닙니다</p>
		<hr>
		<p>
			<input type="button" value="로그인" onclick="location.href='loginView.do'">
			<input type="button" value="회원가입" onclick="location.href='joinView.do'">
		</p>
	</c:if>
	<c:if test="${!empty getMember}">
		<p>${getMember.mname }(${param.mid })님 어서오세요</p>
		<hr>
		<p>
			<input type="button" value="로그아웃" onclick="location.href='logout.do'">
		</p>
	</c:if>
</body>
</html>