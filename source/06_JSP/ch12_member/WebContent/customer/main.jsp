<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style>
		#mainForm_wrap {
			height: 630px; line-height: 600px; font-size: 32px;
			width: 400px; text-align: center; margin: 0 auto;
		}
	</style>
</head>
<body>
	<jsp:include page="../customer/header.jsp"/>
	<div id="mainForm_wrap">
		CONTENT
	</div>
	<jsp:include page="../customer/footer.jsp"></jsp:include>
</body>
</html>
