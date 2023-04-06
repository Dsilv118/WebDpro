<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="${conPath }/css/style.css" rel="stylesheet">
</head>
<body>
	<div id="wrap">
		<h2 class="right">"현재 총 ${cnt }명"</h2>
		<form action="input.do" method="post">
			<table>
				<caption>개인 정보 입력</caption>
				<tr>
					<th>이 름 : </th>
					<td>
						<input type="text" name="name" placeholder="홍길동" required="required">
					</td>
				</tr>
				<tr>
					<th>국 어 : </th>
					<td>
						<input type="number" name="kor" placeholder="100" min="0" max="100" required="required">
					</td>
				</tr>
				<tr>
					<th>영 어 : </th>
					<td>
						<input type="number" name="eng" placeholder="100" min="0" max="100" required="required">
					</td>
				</tr>
				<tr>
					<th>수 학 : </th>
					<td>
						<input type="number" name="math" placeholder="99" min="0" max="100" required="required">
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="입 력">
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>