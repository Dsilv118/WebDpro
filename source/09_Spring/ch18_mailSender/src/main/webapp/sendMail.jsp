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
	<div style="width: 500px; margin: 0 auto;">
		<h1>이디디님의 회원가입 감사합니다</h1>
		아무개 사이트에서만 쓰실 수 있는 감사 쿠폰을 드립니다.<br>
		<img src="https://t1.daumcdn.net/daumtop_chanel/op/20200723055344399.png" alt="다음 로고">
		<hr color="red">
		<span style="color: red;">빨간 글씨 부분</span><br>
		<span style="color: blue;">파란 글씨 부분</span><br>
		<img src="http://localhost:8090/ch18/img/coupon.jpg" alt="쿠폰"><br>
		<p style="text-align: center;">서울시 강서구 금낭화로129</p>
	</div>
</body>
</html>