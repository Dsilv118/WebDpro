<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style>
		#logoutForm_wrap {
			height: 630px; line-height: 600px; font-size: 15px;
			width: 400px; text-align: center; margin: 0 auto;
		}
	</style>
	<script>
		setTimeout(function(){location.href="main.jsp";}, 3000);
	</script> 
</head>
<body>
	<%
		session.invalidate();
	%>
	<jsp:include page="../customer/header.jsp"/>
	<div id="logoutForm_wrap">
		로그아웃되었습니다. 잠시 후 페이지 이동이 있겠습니다.
	</div>
	<jsp:include page="../customer/footer.jsp"/>
</body>
</html>