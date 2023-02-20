<%@page import="com.lec.customer.CustomerDao"%>
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
	<h1>테스트 페이지</h1>
	<%
		// 1. 회원가입시 id 중복체크
		CustomerDao dao = CustomerDao.getInstance();
		String id = "aaa";
		int result = dao.confirmId(id);
		if(result == CustomerDao.CUSTOMER_EXISTENT){
			out.println("<h3>1. confirmId결과 : " + id + "는 중복된 아이디입니다. 회원가입 불가합니다.</h3>");
		} else {
			out.println("<h3>1. confirmId결과 : " + id + "는 사용 가능한 아이디입니다. 회원가입 가능합니다.</h3>");
		}
	    // 2. 회원가입
		CustomerDto dto = new CustomerDto("bbb","111", "김길동", "02-2441-2231", "dwas@naver.com", 
										 "서울시 강서구", null, "f");		
		result = dao.joinCustomer(dto);
		if(result == CustomerDao.SUCCESS){
			out.println("<h3>2. join 결과 : 회원가입 성공</h3>");
		}else{
			out.println("<h3>2. join 결과 : 회원가입 실패 : " + dto + "</h3>");
		}
		// 3. 로그인
		int resultlogchk = dao.loginCheck("bbb", "111");
		if(resultlogchk == CustomerDao.LOGIN_SUCCESS){
			out.println("<h3>3. login 결과 : 로그인 성공</h3>");
		}else if(resultlogchk == CustomerDao.LOGIN_FAIL){
			out.println("<h3>3. login 결과 : ID 혹은 PW 오류로 로그인 실패</h3>");
		}
		// 4. 회원정보 수정시 회원정보 가져오기
		out.println("<h3>4. id로 dto 가져오기</h3>");
		dto = dao.getCustomer("aaa");
		out.println("aaa 아이디인 Customer : " + dto + "<br>");
		dto = dao.getCustomer("bbb");
		out.println("bbb 아이디인 Customer : " + dto + "<br>");
		// 5. 회원정보수정
		out.println("<h3>5. 회원정보수정</h3>");
		dto = new CustomerDto("aaa", "111", "박길동", "010-2213-2212", null, null, null, null);	
		result = dao.modifyCustomer(dto);
		if(result == dao.SUCCESS){
			out.println("수정완료<br>");
			out.println("db의 수정된 데이터 : " + dao.getCustomer(dto.getCid()) + "<br>");
		} else {
			out.println(dto.getCid() + " 없는 아이디라 수정이 불가합니다.<br>");
		}
	%> 
</body>
</html>






















