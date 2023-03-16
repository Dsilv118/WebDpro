<%@page import="com.lec.ex.dto.BoardDto"%>
<%@page import="com.lec.ex.dao.BoardDao"%>
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
	<%
		String mname=null, mid=null, ftitle=null, fcontent=null, ffilename=null, fip=null;
		BoardDao bDao = new BoardDao();
		for(int i=1 ; i<70 ; i++) {
			mid = "ham";
			mname = "홍길동" + i;
			ftitle = "제목" + i;
			fcontent = "본문" + i;
			ffilename = "NOIMAGE.JPG";
			fip = "192.321.241." + i;
			BoardDto bDto = new BoardDto(0, mid, ftitle, fcontent, ffilename, null, 0, 0, 0, 0, fip, mname);
			int result = bDao.write(bDto);
			System.out.println(result==1 ? i+"번째 성공" : i+"번째 실패");
		}
		response.sendRedirect("../boardList.do");
	%>
</body>
</html>