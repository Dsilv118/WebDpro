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
	<table>
		<caption>게시판</caption>
		<tr><td><a href="<%=conPath %>/board/writeForm.jsp">글쓰기</a></td></tr>
	</table>
	<table>
		<tr><th>글번호</th><th>작성자</th><th>글제목</th><th>메일</th><th>조회수</th></tr>
		<%
			BoardDao bDao = BoardDao.getInstance();
			int totalCnt = bDao.getBoardTotalCnt();
			if(totalCnt == 0) {
				out.println("<tr><td colspan='5'>등록된 글이 없습니다.</td></tr>");
			} else {
				ArrayList<BoardDto> dtos = bDao.listBoard();
				for(BoardDto d : dtos) {
					// 글번호 <td>1</td>
					out.println("<tr><td>" + d.getNum() + "</td>");
					// 작성자
					out.println("    <td>" + d.getWriter() + "</td>");
					// 글제목(조회수가 10 이상이면 hot 이미지와 같이 제목 출력, 글 제목 클릭 시 상세 보기 페이지로)
					out.println("<td class='left'>");
					if(d.getReadcount() > 10) {
						out.println("<img src='"+conPath+"/img/hot.gif'>");
					}
					out.println("<a href='"+conPath+"/board/content.jsp?num="+d.getNum()+"'>"+d.getSubject()+"</a>");
					out.println("</td>");
					// 메일
					String email = d.getEmail();
					out.println("<td>" + (email==null ? " - ":email) + "</td>");
					// 조회수
					out.println("<td>" + d.getReadcount()+"</td></tr>");
				}
			}
		%>
	</table>
</body>
</html>