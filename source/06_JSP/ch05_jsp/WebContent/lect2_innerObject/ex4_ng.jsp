<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>ageInput.html(나이 입력)->agePro.jsp(나이에 따른 분기)->ng.jsp</h2>
	<%
		int age = Integer.parseInt(request.getParameter("age"));
	%>
	<h2><%=age %>살 어허!</h2>
	<button onclick="history.back()">뒤로가기</button>
	<button onclick="location.href='ex4_ageinput.html'">새로입력</button>
</body>
</html>