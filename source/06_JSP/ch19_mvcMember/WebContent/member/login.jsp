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
</head>
<body>
	<c:set var="SUCCESS" value="1"/>
	<c:set var="FAIL" value="0"/>
	<c:if test="${joinResult eq SUCCESS}">
		<script>alert('회원가입되었습니다. 감사합니다')</script>
	</c:if>
	<c:if test="${joinResult eq FAIL}">
		<script>
			alert('회원가입 실패되었습니다. 다시 확인해주세요');
			history.back();
		</script>
	</c:if>
	<form action="login.do" method="post">
		<table>
			<tr>
				<th>ID</th>
				<td><input type="text" name="mid" required="required" autofocus="autofocus"></td>
			</tr>
			<tr>
				<th>PW</th>
				<td><input type="password" name="mpw" required="required"></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="로그인">
					<input type="button" value="회원가입" onclick="location.href='joinView.do'">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>