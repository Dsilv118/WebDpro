<%@page import="com.lec.dao.FileBoardDao"%>
<%@page import="com.lec.dto.FileBoardDto"%>
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
	<div id="content_form" style="padding: 40px";>
	<%
		// fboardWriteForm.jsp => 원 글 쓰기
		// 						fsubject, fcontent, ffilename, fpw(사용자)
		//						fref, fre_step, fre_lavel -> (0으로 넘김)
		// fboardWriteForm.jsp?fnum=1%pageNum=9 => 1번 글에 대한 답글 쓰기
		//						fsubject, fcontent, ffilename, fpw(사용자) 
		//						fref, fre_step, fre_lavel -> (원글에서 가져옴)
		if(session.getAttribute("customer")==null) {
			response.sendRedirect(conPath+"/customer/loginForm.jsp?method=fileboard/fboardWriteForm");
		}
		String pageNum = request.getParameter("pageNum");
		if(pageNum==null) pageNum="1";
		int fnum = 0; // 글 번호는 0으로 초기화
		FileBoardDto fDto = new FileBoardDto(); // 빈 dto 객체 생성 (fnum, fref, fre_step, fre_level은 0)
		if(request.getParameter("fnum")!=null) { // fnum번 글의 답글 쓰러 왔음
			fnum = Integer.parseInt(request.getParameter("fnum"));
			FileBoardDao fDao = FileBoardDao.getInstance();
			fDto = fDao.getBoard(fnum); // 원 글에 대한 정보 (fref, fre_step, fre_level)
		}
	%>
	<form action="<%=conPath %>/fileboard/fboardWritePro.jsp" method="post" enctype="multipart/form-data">
		<input type="hidden" name="pageNum" value="<%=pageNum %>">
		<input type="hidden" name="fnum" value="<%=fnum %>">
		<input type="hidden" name="fref" value="<%=fDto.getFref() %>">
		<input type="hidden" name="fre_step" value="<%=fDto.getFre_step() %>">
		<input type="hidden" name="fre_level" value="<%=fDto.getFre_level() %>">
		<table>
			<tr>
				<th>글 제목</th>
				<td>
					<input type="text" name="fsubject" required="required" autofocus="autofocus"
						   value="<% 
						   			if(fDto.getFsubject()!=null) {
						   				out.print("[답]" + fDto.getFsubject());
						   			}
						   		  %>"
					>
				</td>
			</tr>
			<tr>
				<th>첨부파일</th>
				<td><input type="file" name="ffilename"></td>
			</tr>
			<tr>
				<th>본문</th>
				<td><textarea rows="5" name="fcontent"></textarea></td>
			</tr>
			<tr>
				<th>삭제비번</th>
				<td><input tpye="password" name="fpw" required="required"></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value='<%=fnum==0 ? "글쓰기" : "답글쓰기"%>' class="btn">
					<input type="reset" value="다시쓰기" class="btn">
					<input type="button" value="목록" class="btn"
						   onclick="location.href='fboardList.jsp?pageNum=<%=pageNum %>'">
				</td>
			</tr>
		</table>
	</form>
	</div>
	<jsp:include page="../main/footer.jsp"/>
</body>
</html>















