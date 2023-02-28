<%@page import="com.lec.dao.FileBoardDao"%>
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
		int fnum = Integer.parseInt(request.getParameter("fnum"));
		String fpw = request.getParameter("fpw");
		FileBoardDao bDao = FileBoardDao.getInstance();
		int result = bDao.deleteBoard(fnum, fpw);
		/* pageNum 추가 */
		String pageNum = request.getParameter("pageNum");
		if(result == FileBoardDao.SUCCESS) {
	%>
			<script>
				alert('<%=fnum%>번 글 삭제 완료');
				location.href = '<%=conPath%>/fileboard/fboardList.jsp?pageNum=<%=pageNum%>';
			</script>
	<% 		
		} else {
	%>
			<script>
				alert('<%=fnum%>번 글 삭제 실패. 비밀번호를 확인하세요');
				history.back();
			</script>
	<% 		
		}
	%>
</body>
</html>