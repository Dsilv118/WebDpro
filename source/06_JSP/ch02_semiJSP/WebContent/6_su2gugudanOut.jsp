<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style>
		table {
		width: 800px; 
		margin: 20px auto;
		text-align: center;
		border: 1px solid lightblue;
	}
	</style>
</head>
<body>
	<% 
		int su1 = Integer.parseInt(request.getParameter("su1"));
		int su2 = Integer.parseInt(request.getParameter("su2"));
	%>
	<table>
		<caption><h2><%=su1 %>단 부터 <%=su2 %>단까지 구구단 출력</h2></caption>
		<tr>
			<%for(int y=su1 ; y<=su2 ; y++){ %>
				<td><%=y %>단</td>
			<%} %>
		</tr>
		<%for(int x=1 ; x<10 ; x++){ %> 
			<tr>
			<%for(int i=su1 ; i<=su2 ; i++){ %>
				<td><%=i + " * " + x + " = " + (i*x) %></td>
			<%} %>
			</tr>
		<%} %>
	</table>
</body>
</html>