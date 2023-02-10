<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="join.css" rel="stylesheet">
</head>
<body>
	<%
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String birth = request.getParameter("birth");
		String hobby = request.getParameter("hobby");
		String gender = request.getParameter("gender");
		String email = request.getParameter("email");
		String mailSend = request.getParameter("mailSend");
		String sign = request. getRemoteAddr();
	%>
	<div id="joinForm_wrap">
		<div id="join_title">
			회원가입정보
		</div>
		<h2>
			name  : <%=name %><br><br>
			id    : <%=id %><br><br>
			pw    : <%=pw %><br><br>
			birth : <%=birth %><br><br>
			hobby : <%=hobby %><br><br>
			gender: <%=gender %><br><br>
			email : <%=email %><br><br>
			mailSend : <%=mailSend %><br><br>
			가입IP  : <%=sign %>
		</h2>
	</div>
	<%@ include file="footer.jsp" %>
</body>
</html>