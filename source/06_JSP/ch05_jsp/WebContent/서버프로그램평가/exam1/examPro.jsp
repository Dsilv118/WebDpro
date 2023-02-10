<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style>
		button {
			text-align: center;
			border: 1px solid blue;
			padding: 50px;
			cursor: pointer;
		}
	</style>
</head>
<body>
	<!-- examPro.jsp?su=1 -->
	<%
		request.setCharacterEncoding("utf-8");
		int num  = Integer.parseInt(request.getParameter("num"));
		int rnum = (int)((Math.random() * (4 - 1)) + 1);
		if(num!=rnum){
			String msg = "틀렸습니다!<br>" + num + "은(는) 아니고 정답은 " + rnum;
			msg = URLEncoder.encode(msg, "utf-8");
			response.sendRedirect("exam.jsp?msg="+msg);
		}
	%>
	<h2>
		정답입니다!
	</h2>
	<h2>
		동전이 있던곳은 <%=rnum %>
	</h2>
	<button onclick="location.href='exam.jsp'">다시시작</button>
</body>
</html>