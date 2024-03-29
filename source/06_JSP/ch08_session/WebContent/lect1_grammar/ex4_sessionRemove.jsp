<%@page import="java.util.Enumeration"%>
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
	<%	// 세션 삭제 (로그아웃 시 사용)
		// 특정 세션을 삭제하기(세션의 특정 속성을 삭제하기)
		session.removeAttribute("sessionNum"); // sessionNum 세션(속성) 삭제
		out.println("<h3>sessionNum 삭제 후 모든 세션 list </h3>");
		Enumeration<String> sAttrNames = session.getAttributeNames();
		int cnt = 0;
		while(sAttrNames.hasMoreElements()){
			String sname = sAttrNames.nextElement();
			String svalue = session.getAttribute(sname).toString();
			out.println("<p> 세션 속성 이름 : " + sname + "세션 값 : " + svalue + "</p>");
			cnt ++;
		}
		if(cnt==0){
			out.println("<h3>세션 속성이 없습니다</h3>");
		}
		// 모든 세션 삭제하기
		session.invalidate(); // setAttribute 했던 모든 세션 속성 다 제거. 세션 ID도 제거. 세션 추가시 새로운 ID발부
		out.println("<h3>session.invalidate() 후");
		if(request.isRequestedSessionIdValid()){ // 유효한 세션 attribute가 있는지
			out.println("<h3>유요한 세션 속성이 있음</h3>");
		}else{
			out.println("<h3>유효한 세션이 없음</h3>");
		}
	%>
	<hr>
	<h2>세션 ID : <%=session.getId() %></h2>
	<h2>세션의 유효시간 : <%=session.getMaxInactiveInterval() %></h2>
	<hr>
	<a href="ex1_sessionAddAttr.jsp">세션 데이터 추가</a><br>
	<a href="ex2_sessionGet.jsp">특정 세션 GET</a><br>
	<a href="ex3_sessionList.jsp">세션의 모든 데이터 리스트</a><br>
	<a href="ex4_sessionRemove.jsp">세션 삭제(특정 세션이나 모든 세션 데이터)</a>
</body>
</html>