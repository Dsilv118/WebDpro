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
<%
	/* list.jsp 또는 list.jsp?pageNum=19 */
	String pageNum = request.getParameter("pageNum");
	if(pageNum==null) pageNum = "1"; // 전달받은 pageNum 파라미터가 없으면 1page로 전환
	int currentPage = Integer.parseInt(pageNum);
	final int PAGESIZE=10, BLOCKSIZE=10;
	int startRow = (currentPage - 1) * PAGESIZE + 1;
	int endRow   = startRow + PAGESIZE - 1;
%>
<body>
	<table>
		<caption>게시판</caption>
		<tr><td><a href="<%=conPath %>/board/writeForm.jsp?pageNum=<%=pageNum%>">글쓰기</a></td></tr>
	</table>
	<table>
		<tr><th>글번호</th><th>작성자</th><th>글제목</th><th>메일</th><th>조회수</th></tr>
		<%
			// out.print("<tr><td colspan='3'>startRow : " + startRow + ", endRow : " + endRow + "</td></tr>");
			BoardDao bDao = BoardDao.getInstance();
			int totalCnt = bDao.getBoardTotalCnt(); // 글 갯수
			if(totalCnt == 0) {
				out.println("<tr><td colspan='5'>등록된 글이 없습니다.</td></tr>");
			} else {
				ArrayList<BoardDto> dtos = bDao.listBoard(startRow, endRow);
				for(BoardDto d : dtos) {
					// 글번호 <td>1</td>
					out.println("<tr><td>" + d.getNum() + "</td>");
					// 작성자
					out.println("    <td>" + d.getWriter() + "</td>");
					out.println("<td class='left'>");
					// 답변글(re_indent)일 경우 re_indent만큼 들여쓰기(level.gif) + re.gif 출력
					if(d.getRe_indent()>0){
						int width = d.getRe_indent()*20;
						out.println("<img src='"+conPath+"/img/level.gif' width='"+width+"' height='10'>");
						out.println("<img src='"+conPath+"/img/re.gif'>");
					}
					// 글제목(조회수가 10 이상이면 hot 이미지와 같이 제목 출력, 글 제목 클릭 시 상세 보기 페이지로)
					if(d.getReadcount() > 10) {
						out.println("<img src='"+conPath+"/img/hot.gif'>");
					}
					out.println("<a href='"+conPath+"/board/content.jsp?num="+d.getNum()+"&pageNum="+pageNum+"'>"
									+d.getSubject()+"</a>");
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
	<div class="paging">
		<%
			int pageCnt = (int)Math.ceil((double)totalCnt / PAGESIZE);
			int startPage = ((currentPage-1)/BLOCKSIZE) * BLOCKSIZE + 1;
			int endPage = startPage + BLOCKSIZE - 1;
			if(endPage > pageCnt) {
				endPage = pageCnt;
			}
			if(startPage > BLOCKSIZE) {
				out.println("[<a href='"+conPath+"/board/list.jsp?pageNum="+(startPage-1)+"'>이전</a>]");
			}
			for(int i=startPage ; i<=endPage ; i++) {
				if(i == currentPage) {
					out.println("[<b>" + i + "</b>]");
				} else {
					out.println("[<a href='"+conPath+"/board/list.jsp?pageNum="+i+"'>"+i+"</a>]");
				}
			}
			if(endPage < pageCnt) {
				out.println("[<a href='"+conPath+"/board/list.jsp?pageNum="+(endPage+1)+"'>다음</a>]");
			}
		%>
	</div>
</body>
</html>



























