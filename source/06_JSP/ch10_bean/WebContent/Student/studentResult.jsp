<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath %>/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<jsp:useBean id="s" class="com.lec.ex.Student" scope="request"/>
	<h2><%=s.getName() %>님의 개인정보</h2>
	<p>학번 : <%=s.getNum() %></p>
	<p>이름 : <%=s.getName() %></p>
	<p>학년 : <%=s.getGrade() %>학년</p>
	<p>반   : <%=s.getClss() %>반</p>
	<p>점수 : <%=s.getScore() %>점</p>
</body>
</html>