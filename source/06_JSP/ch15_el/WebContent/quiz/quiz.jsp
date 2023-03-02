<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style>
		p {text-align: center;}
		p:last-child {
			color: red;
			font-weight: bold;
		}
	</style>
</head>
<body>
	<form>
		<p>
			<input type="text" name="n1" value="<%=(int)(Math.random()*10)%>" readonly="readonly"> *
			<input type="text" name="n2" value="<%=(int)(Math.random()*10)%>" readonly="readonly"> =
			<input type="text" name="n3">
		</p>
		<p>
			<input type="submit" value="확인">
		</p>
	</form>
	<p>
		${param.n1 } *
		${param.n2 } = 
		${param.n3 } 는
		${param.n1*param.n2 eq param.n3 ? "true" : "false" }
		${empty param.n3 ? "" : param.n1*param.n2 eq param.n3 ? "정답" : "오답"}
	</p>
</body>
</html>