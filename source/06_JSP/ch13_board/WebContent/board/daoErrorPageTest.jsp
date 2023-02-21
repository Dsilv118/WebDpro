<%@page import="com.lec.dto.BoardDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.lec.dao.BoardDao"%>
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
	<a href="xx.jsp">에러 페이지 될까?</a>
	<%
		BoardDao bDao = BoardDao.getInstane();
		out.println("<h3>1. 글 갯수 : " + bDao.getBoardTotalCnt() + "</h3>");
		out.println("<h3>2. 글 목록</h3>");
		ArrayList<BoardDto> dtos = bDao.listBoard();
		for(BoardDto d : dtos) {
			out.println(d + "<br>");
		}
		out.println("<h3>3. 원글쓰기</h3>");
		BoardDto dto = new BoardDto(0, "김구", "대한만세", "냉무", null, 0, "111", 
									0, 0, 0, "192.123.2.1", null);
		int result = bDao.insertBoard(dto);
		out.println(result == BoardDao.SUCCESS ? "글쓰기 성공" : "글쓰기 실패");
		out.println("<h3>4와 5. 조회수 올리고 글 번호로 dto 가져오기</h3>");
		bDao.readCountUp(9);
		dto = bDao.getBoardOneLine(9);
		out.println("수정전의 9번 글 : " + dto);
		out.println("<h3>6. 글 수정</h3>");
		dto = new BoardDto(9, "김구", "수정제목", "수정냉무", "modify@m.com", 0, "111", 
				0, 0, 0, "192.123.2.1", null);
		result = bDao.updateBoard(dto);
		if(result == bDao.SUCCESS) {
			dto = bDao.getBoardOneLine(3);
			out.println("수정 완료 후 9번 글 : " + dto);
		} else {
			out.println("수정 실패. 오타 찾아");
		}
		out.println("<h3>7. 6번글 삭제</h3>");
		result = bDao.deleteBoard(6, "111");
		out.println(result == BoardDao.SUCCESS ? "6번글 삭제 성공" : "6번글 삭제 실패 (비밀번호 오류)<br>");
	%>
</body>
</html>