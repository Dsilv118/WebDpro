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
</head>
<body>
	<%
		FileBoardDao fDao = FileBoardDao.getInstance();
		FileBoardDto fDto = new FileBoardDto();
		for(int i=0 ; i<70 ; i++) {
			// 글 등록
			if(i%3==0) {
				fDto.setCid("aaa");
			} else if(i%3==1) {
				fDto.setCid("bbb");
			} else {
				fDto.setCid("ccc");
			}
			fDto.setFsubject("for문으로 강제로 입력한 제목 " + i);
			fDto.setFcontent("본문" + i);
			if(i%5==0) {
				fDto.setFfilename("1.docx");
			} else {
				fDto.setFfilename(null);
			}
			fDto.setFpw("1");
			fDto.setFip("183.221.4." + i);
			System.out.println(fDao.insertBoard(fDto)== 1 ? i + "번째 성공" : i + "번째 실패");
		}
		response.sendRedirect("fboardList.jsp");
	%>
</body>
</html>