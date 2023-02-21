<%@page import="com.lec.friend.FriendDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.lec.friend.FriendDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath %>/css/style.css" rel="stylesheet" type="text/css">
	<script>
		window.onload = function(){
			document.querySelector('form').onsubmit = function(){
				var name  = document.getElementById('name');
				var tel   = document.getElementById('tel');
				var telPt = /^\d{2,3}-\d{3,4}-\d{4}$/;
				if(name.value.length > 6 || !name.value) {
					alert('이름은 6자 이내 혹은 필수 입력 사항입니다. 다시 시도해주세요');
					name.value = '';
					name.focus();
					return false;
				} else if(tel.value.length >= 1 && !tel.value.match(telPt)) {
					alert('전화번호 양식을 확인해주세요.');
					tel.value = '';
					tel.focus();
					return false;
				}
			}
		}
	</script>
</head>
<body>
	<form action="friendInputListPro.jsp">
		<p>친구 이름 <input type="text" name="name" id="name"></p>
		<p>전화 번호 <input type="text" name="tel" id="tel"></p>
		<p><input type="submit" value="추가"></p>
	</form>
	<table>
		<tr>
			<td>순번</td><td>이름</td><td>전화</td>
		</tr>
		<%
			FriendDao dao = FriendDao.getInstance();
			ArrayList<FriendDto> fdto = dao.friendList();
			if(fdto.isEmpty()) {
				out.println("<tr><td colspan='3'><h3>저장된 친구 목록이 없습니다</h3></td></tr>");
			} else {
				for(FriendDto d : fdto){
					int num = d.getNum();
					String name = d.getName();
					String tel  = d.getTel();
					if(tel==null){
						tel = "";
					}
					out.println("<tr><td>"+ num + "</td><td>" + name + "</td><td>" + tel + "</td></tr>");
				}
			}
		%>
	</table>
</body>
</html>