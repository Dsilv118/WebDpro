<%@page import="java.sql.Date"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
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
	<%!
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url    = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String uid    = "scott";
		String upw    = "tiger";
	%>
	<%
		request.setCharacterEncoding("utf-8");
		String enameInput = request.getParameter("ename");
		if(enameInput==null){
			enameInput = "";
		}else{
			enameInput = enameInput.toUpperCase().trim();
		}
	%>
	<form action="" method="post">
		<p>
			사원명
			<input type="text" name="ename" required="required" value=<%=enameInput %>>
			<input type="submit" value="검색">
		</p>
	</form>
	<table>
		<tr><th>사번</th><th>이름</th><th>직책</th><th>상사사번</th><th>입사일</th><th>급여</th><th>부서번호</th><th>부서명</th></tr>
		<%
			Connection        conn  = null;
			PreparedStatement pstmt = null;
			ResultSet         rs    = null;
			String sql = "SELECT EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, E.DEPTNO, DNAME " +
							"FROM EMP E, DEPT D " +
							"WHERE E.DEPTNO=D.DEPTNO AND ENAME LIKE '%'||?||'%'";
			try{
				Class.forName(driver);
				conn  = DriverManager.getConnection(url, uid, upw);
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, enameInput);
				rs    = pstmt.executeQuery();
				if(rs.next()){
					do{
						int    empno  = rs.getInt("empno");
						String ename  = rs.getString("ename");
						String   job  = rs.getString("job");
						int      mgr  = rs.getInt("mgr");
						Date hiredate = rs.getDate("hiredate");
						int      sal  = rs.getInt("sal");
						int   deptno  = rs.getInt("deptno");
						String dname  = rs.getString("dname");
						out.println("<tr><td>" + empno    + "</td>");
						out.println("    <td>" + ename 	  + "</td>");
						out.println("    <td>" + job      + "</td>");
						out.println("    <td>" + mgr      + "</td>");
						out.println("    <td>" + hiredate + "</td>");
						out.println("    <td>" + sal      + "</td>");
						out.println("    <td>" + deptno   + "</td>");
						out.println("    <td>" + dname    + "</td></tr>");
					}while(rs.next());
				}else{
					out.println("<tr><td colspan='8'><h3>" + enameInput + "<br><br>해당 문자의 사원명이 없습니다.</h3></td></tr>");
				}
			}catch(Exception e){
				System.out.println(e.getMessage());
			}finally{
				if(rs!=null)    rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null)  conn.close();
			}
		%>
	</table>
</body>
</html>


























