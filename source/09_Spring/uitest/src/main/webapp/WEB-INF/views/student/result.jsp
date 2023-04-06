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
	<link href="${conPath }/css/style.css" rel="stylesheet">
</head>
<body>
	<div id="wrap">
		<h2 class="right">"현재 총 ${cnt }명"</h2>
		<table>
			<caption>결과는 다음과 같습니다</caption>
			<tr>
				<th>이 름 : </th>
				<td>${students.name }</td>
			</tr>
			<tr>
				<th>국 어 : </th>
				<td>${students.kor }</td>
			</tr>
			<tr>
				<th>영 어 : </th>
				<td>${students.eng }</td>
			</tr>
			<tr>
				<th>수 학 : </th>
				<td>${students.math }</td>
			</tr>
			<tr>
				<th>총 점 : </th>
				<td>${students.kor + students.eng + students.math}</td>
			</tr>
			<tr>
				<th>평 균 : </th>
				<td><fmt:formatNumber value="${(students.kor + students.eng + students.math)/3 }" pattern="00.00"/></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="button" value="뒤로가기" onclick="history.go(-1)">
					<input type="reset" value="다시입력" onclick="location.href='${conPath}/input.do'">
				</td>
			</tr>
		</table>
	</div>
</body>
</html>