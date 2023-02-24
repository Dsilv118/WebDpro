<%@page import="com.lec.book.*"%>
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
		/*String pageNum = request.getParameter("pageNum");
		String bidStr = request.getParameter("bid");
		if(bidStr == null) {
			response.sendRedirect("ex4_listProduct_Page.jsp");
		} else {
			int bid = Integer.parseInt(bidStr);
		} */
		int bid = Integer.parseInt(request.getParameter("bid"));
		String pageNum = request.getParameter("pageNum");
		if(pageNum == null) pageNum = "1";
		BookDao bDao = BookDao.getInstance();
		BookDto book = bDao.getBook(bid);
	%>
	<table>
		<tr>
			<td rowspan="4">
				<img src="<%=conPath%>/bookImg/<%=book.getBimage1()%>" width="100"><!-- 1,2,3,4행의 1열 -->
			</td>
			<td>
				<%=book.getBid()%>번 도서 상세보기
			</td>
		</tr>
		<tr>
			<td>
				<%=book.getBtitle() %>
			</td>
		</tr>
		<tr>
			<td>
				<del><%=book.getBprice() %></del> <b><%=book.getBdiscount() %>% </b><br>
				<b><%=book.getBprice() * (100-book.getBdiscount()) / 100 %>원</b>
			</td>
		</tr>
		<tr>
			<td>
				<button>구매하기</button>
				<button onclick="location.href='ex4_listProduct_Page.jsp?pageNum=<%=pageNum%>'">책 목록</button>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<img src="<%=conPath%>/bookImg/<%=book.getBimage2()%>"><br>
				<pre><%=book.getBcontent() %></pre>
			</td>
		</tr>
	</table>
</body>
</html>

















