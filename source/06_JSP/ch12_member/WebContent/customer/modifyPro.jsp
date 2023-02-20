<%@page import="com.lec.customer.CustomerDao"%>
<%@page import="java.sql.Date"%>
<%@page import="com.lec.customer.CustomerDto"%>
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
	<% request.setCharacterEncoding("utf-8"); %>
	<jsp:useBean id="dto" class="com.lec.customer.CustomerDto" scope="page" />
	<jsp:setProperty name="dto" property="*" />
	<%
		String cbirth = request.getParameter("tempBirth");
		if(!cbirth.equals("")){
			dto.setCbirth(Date.valueOf(cbirth));
		}
		CustomerDto customer = (CustomerDto)session.getAttribute("customer");
		String sessionPw = null;
		if(customer != null) {
			sessionPw = customer.getCpw();
		}
		String coldpw = request.getParameter("coldpw");
		if(sessionPw.equals(coldpw)){
			if(dto.getCpw()==null){
				dto.setCpw(coldpw);
			}
			CustomerDao cDao = CustomerDao.getInstance();
			int result = cDao.modifyCustomer(dto);
			if(result == CustomerDao.LOGIN_SUCCESS){
				session.setAttribute("customer", dto);
	%>
				<script>
					alert('정보 수정이 완료되었습니다');
					location.href = 'main.jsp';
				</script>
	<% 
			}else {
	%>
				<script>
					alert('회원정보 수정이 실패되었습니다. 정보가 너무 깁니다.');
					location.href = "modify.jsp";
				</script>
	<% 
			}
		} else {
	%>
			<script>
				alert('현재 비밀번호가 올바르지 않습니다. 다시 입력해주세요');
				history.back();
			</script>
	<% 
		}
	%>
</body>
</html>