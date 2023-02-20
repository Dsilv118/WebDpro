<%@page import="com.lec.customer.CustomerDao"%>
<%@page import="java.sql.Date"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.sql.Timestamp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href='<%=conPath %>/css/join.css' rel='stylesheet'>
</head>
<body>
	<%request.setCharacterEncoding("utf-8");%>
	<jsp:useBean id="dto" class="com.lec.customer.CustomerDto"/>
	<jsp:setProperty property="*" name="dto"/>
	<%
		String cbirth = request.getParameter("tempBirth");
		if(!cbirth.equals("")){
			dto.setCbirth(Date.valueOf(cbirth));
		}
		CustomerDao cDao = CustomerDao.getInstance();
		int rs = cDao.confirmId(dto.getCid());
		if(rs == CustomerDao.CUSTOMER_NONEEXISTENT){
			rs = cDao.joinCustomer(dto);
			if(rs == CustomerDao.SUCCESS){
				session.setAttribute("jcid", dto.getCid());
	%>
				<script>
					alert('회원가입 감사합니다. 로그인 후에 서비스를 이용하세요');
					location.href = 'login.jsp';
				</script>
	<% 
			} else {
	%>
				<script>
					alert('회원가입이 실패되었습니다. 너무 긴 데이터는 가입이 불가합니다. 다시 가입해주세요');
					location.href = 'join.jsp';
				</script>
	<% 			
			}
		} else {
	%>
			<script>
				alert('중복된 ID입니다. 다른 아이디를 사용해주세요');
				history.back();
			</script>
	<% 		
		}
	%>
</body>
</html>
