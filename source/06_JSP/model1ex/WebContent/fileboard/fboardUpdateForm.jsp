<%@page import="com.lec.dto.FileBoardDto"%>
<%@page import="com.lec.dao.FileBoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath %>/css/content.css" rel="stylesheet" type="text/css">
</head>
<body>
	<jsp:include page="../main/header.jsp"/>
	<div id="content_form" style="padding: 40px">
		<%
			String pageNum = request.getParameter("pageNum");
			int fnum = Integer.parseInt(request.getParameter("fnum"));
			FileBoardDao fDao = FileBoardDao.getInstance();
			FileBoardDto fDto = fDao.getBoard(fnum);
		%>
		<form action="fboardUpdatePro.jsp" method="post" enctype="multipart/form-data">
			<input type="hidden" name="pageNum" value="<%=pageNum %>">
			<input type="hidden" name="dbfilename" value='<%=fDto.getFfilename()==null ? "" : fDto.getFfilename() %>'>
			<table>
				<caption><%=fnum %>번 글 수정</caption>
				<tr>
					<th>글 번호</th>
					<td><input type="text" name="fnum" value="<%=fnum %>" readonly="readonly"></td>
				</tr>
				<tr>
					<th>제목</th>
					<td><input type="text" name="fsubject" value="<%=fDto.getFsubject() %>" required="required"></td>
				</tr>
				<tr>
					<th>첨부파일</th>
					<td>
						<input type="file" name="ffilename" style="width: 30%">
						<%
							if(fDto.getFfilename()!=null) {
								out.print("첨부파일 : " + fDto.getFfilename());
							} else {
								out.print("첨부파일이 없습니다");
							}
						%>
					</td>
				</tr>
				<tr>
					<th>본문</th>
					<td><textarea rows="5" name="fcontent"><%=fDto.getFcontent()== null ? "" : fDto.getFcontent() %></textarea></td>
				</tr>
				<tr>
					<th>삭제용 비번</th>
					<td><input type="password" name="fpw" value="<%=fDto.getFpw() %>" required="required"></td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="글 수정" class="btn">
						<input type="reset" value="이전" class="btn" onclick="history.back()">
						<input type="button" value="목록" class="btn" onclick="location.href=	'fboardList.jsp?pageNum=<%=pageNum %>'">				
					</td>
				</tr>
			</table>
		</form>
	</div>
	<jsp:include page="../main/footer.jsp"/>
</body>
</html>

















