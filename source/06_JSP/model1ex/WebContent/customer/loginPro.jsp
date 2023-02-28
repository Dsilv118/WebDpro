<%@page import="com.lec.dto.CustomerDto"%>
<%@page import="com.lec.dao.CustomerDao"%>
<%@page import="sun.nio.cs.HistoricallyNamedCharset"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath %>/css/login.css" rel="stylesheet" type="text/css">
</head>
<body>
	<%
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String method = request.getParameter("method");
		CustomerDao cDao = CustomerDao.getInstance();
		int result = cDao.cusLogin(id, pw);
		if(result == CustomerDao.SUCCESS){
			CustomerDto customer = cDao.getCustomer(id);
			session.setAttribute("customer", customer);
			if(method.equals("null")){
				response.sendRedirect("../main/main.jsp");
			} else {
				response.sendRedirect(conPath + "/" + method + ".jsp");
			}
		} else {
	%>
			<script>
				alert('아이디나 비밀번호를 확인하세요.');
			</script>
	<% 
			response.sendRedirect("loginForm.jsp?msg=xx");
		}
	%>
	<jsp:include page="../main/header.jsp"/>
</body>
</html>