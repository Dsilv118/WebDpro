<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<%
		// String pname = URLEncoder.encode("공책", "utf-8");
		// response.sendRedirect("productStock.do?pname="+pname);
		// response.sendRedirect("productView.do");
		// response.sendRedirect("midConfirm.do?mid=gico");
		response.sendRedirect("joinView.do");
	%>
</body>
</html>