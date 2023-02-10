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
	<form action="examPro.jsp" method="post">
		<button name="num" value="1">1번</button>
		<button name="num" value="2">2번</button>
		<button name="num" value="3">3번</button>
	</form>
	<div id="msg">
		<%
			String msg = request.getParameter("msg");
			if(msg!=null){
				out.println(msg);
			}
		%>
	</div>
</body>
</html>