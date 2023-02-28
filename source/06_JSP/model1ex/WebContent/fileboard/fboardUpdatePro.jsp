<%@page import="com.lec.dao.FileBoardDao"%>
<%@page import="com.lec.dto.FileBoardDto"%>
<%@page import="java.io.FileOutputStream"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.IOException"%>
<%@page import="java.io.OutputStream"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.io.File"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="java.util.Enumeration"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
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
		// 첨부한 파일을 서버에 저장하고 파일 이름 가져오기
		String path = request.getRealPath("fileboardUpload");
		int maxSize = 1024*1024*5; // 최대 업로드 용량은 5MB
		String ffilename = null; // 첨부파일이 서버에 저장된 파일 이름
		MultipartRequest mRequest = null;
		try {
			mRequest = new MultipartRequest(request, path, maxSize, "utf-8", new DefaultFileRenamePolicy()); // 객체 생성
			Enumeration<String> paramNames = mRequest.getFileNames();
			String param = paramNames.nextElement();
			/*while(paramNames.hasMoreElements()) { 파일이 여러개 일때는 while 문으로 반복
				String param = paramNames.nextElement();
			} */
			ffilename = mRequest.getFilesystemName(param); // 첨부하여 서버에 저장된 파일 이름
		} catch(IOException e) {
			System.out.println(e.getMessage());
		}
		// 서버에 저장한 파일을 소스 폴더로 복사하기
		if(ffilename!=null) {
			InputStream  is = null;
			OutputStream os = null;
			try {
				File serverFile = new File(path + "/" + ffilename);
				is = new FileInputStream(serverFile);
				os = new FileOutputStream("D:/Dsilv/source/06_JSP/model1ex/WebContent/fileboard/" + ffilename);
				byte[] bs = new byte[(int)serverFile.length()];
				int readByteCnt;
				while((readByteCnt = is.read(bs)) != -1) {
					os.write(bs, 0, readByteCnt);
				}
				System.out.println(ffilename + "복사함");
			} catch(Exception e) {
				System.out.println(e.getMessage());
			} finally {
				if(os!=null) os.close();
				if(is!=null) is.close();
			}
		}
		// ffilename 외의 다른 파라미터들 받기(pageNum, dbfilename, fnum, fsubject, fcontent, fpw)
		String pageNum  = mRequest.getParameter("pageNum");
		String dbfilename = mRequest.getParameter("dbfilename");
		int fnum        = Integer.parseInt(mRequest.getParameter("fnum"));
		String fsubject = mRequest.getParameter("fsubject");
		String fcontent = mRequest.getParameter("fcontent");
		String fpw      = mRequest.getParameter("fpw");
		// ffilename이 null이면 ffilename 대신 dbfilename으로 dto의 ffilename을 셋팅
		ffilename = ffilename==null ? dbfilename : ffilename;
		// 받은 파라미터를 이용하여 dto 객체 생성
		FileBoardDto fDto = new FileBoardDto(fnum, null, fsubject, fcontent, ffilename, fpw, 0, 0, 0, null);
		// dao를 통해서 update
		FileBoardDao fDao = FileBoardDao.getInstance();
		int result = fDao.updateBoard(fDto);
		if(result == FileBoardDao.SUCCESS) {
	%>		
			<script>
				alert('글 수정 완료');
				location.href='fboardList.jsp?pageNum=<%=pageNum%>'; <%-- 상세보기 --%>
				<%-- location.href ='fboardContent.jsp?fnum=<%=fnum%>&pageNum=<%=pageNum %>';  --%>
			</script>
	<%	} else {%>
			<script>
				alert('글 수정 실패');
			</script>
	<%	} %>
</body>
</html>
















