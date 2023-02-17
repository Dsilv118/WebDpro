<%@page import="com.lec.member.MemberDto"%>
<%@page import="com.lec.member.MemberDao"%>
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
		MemberDao dao = MemberDao.getInstance();
		String id = "bbb";
		int result = dao.confirmId(id);
		if(result == MemberDao.MEMBER_EXISTENT){
			out.println("<h3>1. confirmId결과 : " + id + "는 중복된 아이디입니다. 회원가입 불가합니다.</h3>");
		} else {
			out.println("<h3>1. confirmId결과 : " + id + "는 사용 가능한 아이디입니다. 회원가입 가능합니다.</h3>");
		}
		// 2. 회원가입
		MemberDto dto = new MemberDto(id,"111", "김길동", null, null, null, null,
								   null, null, null, null);		
		result = dao.joinMember(dto);
		if(result == MemberDao.SUCCESS){
			out.println("<h3>2. join 결과 : 회원가입 성공</h3>");
		}else{
			out.println("<h3>2. join 결과 : 회원가입 실패 : " + dto + "</h3>");
		}
		// 3. 로그인
		out.println("<h3>3. 로그인</h3>");
		int resultlogchk = dao.loginCheck("aaa", "111");
		if(resultlogchk == MemberDao.LOGIN_SUCCESS){
			out.println("<h3>3. login 결과 : 로그인 성공</h3>");
		}else if(resultlogchk == MemberDao.LOGIN_FAIL_ID){
			out.println("<h3>3. login 결과 : ID 오류로 로그인 실패</h3>");
		}else if(resultlogchk == MemberDao.LOGIN_FAIL_PW){
			out.println("<h3>3. login 결과 : PW 오류로 로그인 실패</h3>");
		}
		// 3-2
		resultlogchk = dao.loginCheck("ccc", "111");
		if(resultlogchk == MemberDao.LOGIN_SUCCESS){
			out.println("<h3>3-2. login 결과 : 로그인 성공</h3>");
		}else if(resultlogchk == MemberDao.LOGIN_FAIL_ID){
			out.println("<h3>3-2. login 결과 : ID 오류로 로그인 실패</h3>");
		}else if(resultlogchk == MemberDao.LOGIN_FAIL_PW){
			out.println("<h3>3-2. login 결과 : PW 오류로 로그인 실패</h3>");
		}
		// 3-3
		resultlogchk = dao.loginCheck("aaa", "222");
		if(resultlogchk == MemberDao.LOGIN_SUCCESS){
			out.println("<h3>3-3. login 결과 : 로그인 성공</h3>");
		}else if(resultlogchk == MemberDao.LOGIN_FAIL_ID){
			out.println("<h3>3-3. login 결과 : ID 오류로 로그인 실패</h3>");
		}else if(resultlogchk == MemberDao.LOGIN_FAIL_PW){
			out.println("<h3>3-3. login 결과 : PW 오류로 로그인 실패</h3>");
		}
		// 4. 회원정보 수정시 회원정보 가져오기
		out.println("<h3>4. id로 dto 가져오기</h3>");
		dto = dao.getMember("aaa");
		out.println("aaa 아이디인 member : " + dto + "<br>");
		dto = dao.getMember("qqq");
		out.println("qqq 아이디인 member : " + dto + "<br>");
		// 5. 회원정보수정
		out.println("<h3>5. 회원정보수정</h3>");
		dto = new MemberDto("hhh","111", "나몰라", null, null, null, null,
				   "north@hong.com", null, "북한", null);	
		result = dao.modifyMember(dto);
		if(result == dao.SUCCESS){
			out.println("수정완료<br>");
			out.println("db의 수정된 데이터 : " + dao.getMember(dto.getId()) + "<br>");
		} else {
			out.println(dto.getId() + " 없는 아이디라 수정이 불가합니다.<br>");
		}
	%>
</body>
</html>






















