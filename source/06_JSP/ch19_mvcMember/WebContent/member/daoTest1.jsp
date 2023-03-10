<%@page import="java.util.ArrayList"%>
<%@page import="com.lec.ex.dto.MemberDto"%>
<%@page import="com.lec.ex.dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<h1>5. 회원정보 수정(nnnn 회원수정)</h1>
	<%
		String mid = "nnnn";
		MemberDao mdao = MemberDao.getInstance();
		MemberDto mdto = mdao.getMember(mid);
		out.print("<p>수정 전 : " + mdto + "</p>");
		mdto.setMname("엔길동");
		mdto.setMemail("nnn@nnn.com");
		mdto.setMaddress("서울시 강서구");
		mdao.modifyMember(mdto);
		out.print("<p>수정 후 :" + mdao.getMember(mid) + "</p>");
	%>
	<h1>6. 회원리스트 (4등~6등)</h1>
	<%
		ArrayList<MemberDto> members = mdao.allMember(4, 6);
		for(MemberDto m : members) {
			out.println(m + "<br>");
		}
	%>
	<h1>7. 회원수</h1>
	<%
		int num = mdao.getMemberTotCnt();
		out.println(num);
	%>
	<h1>8. (nnnn)회원탈퇴</h1>
	<%
		int result = mdao.withdrawalMember(mid);
		out.println(result == MemberDao.SUCCESS ? "탈퇴 완료" : "탈퇴 실패");
	%>
</body>
</html>