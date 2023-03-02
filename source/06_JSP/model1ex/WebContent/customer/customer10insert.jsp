<%@page import="java.sql.Date"%>
<%@page import="com.lec.dto.CustomerDto"%>
<%@page import="com.lec.dao.CustomerDao"%>
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
	<%
		CustomerDao cDao = CustomerDao.getInstance();
		CustomerDto newCustomer = new CustomerDto();
		for(int i=0 ; i<10 ; i++) {
			newCustomer.setCid("bb"+i);
			newCustomer.setCpw("111");
			if(i%2==0){
				newCustomer.setCname("홍길동");
				newCustomer.setCgender("m");
			} else {
				newCustomer.setCname("홍길숙");
				newCustomer.setCgender("f");
			}
			newCustomer.setCemail("hong"+i+"@hong.com");
			newCustomer.setCtel("010-9999-999"+i);
			int result = cDao.signUp(newCustomer);
			out.println(result == CustomerDao.SUCCESS ? i+"번째 가입 성공" : i + "번째 가입 실패<br>");
		}
	%>
	<button onclick='location.href="<%=conPath%>"'>홈</button>
</body>
</html>