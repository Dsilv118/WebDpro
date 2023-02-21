<%@page import="com.lec.friend.FriendDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.lec.friend.FriendDao"%>
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
		// 1. 친구 추가
		FriendDao dao = FriendDao.getInstance();
		int result = dao.addFriend("양길동", "010-1134-5678");
		if(result == FriendDao.SUCCESS){
			out.println("<h2>1. 친구 추가 성공</h2>");
		} else {
			out.println("<h2>2. 친구 추가 실패</h2>");
		}
		// 2. 친구 목록 출력
		ArrayList<FriendDto> fdto = dao.friendList();
		for(FriendDto d : fdto){
			int num = d.getNum();
			String name = d.getName();
			String tel  = d.getTel();
			out.println(num + name + tel);
		}
	%>
</body>
</html>