<%@page import="com.lec.customer.CustomerDto"%>
<%@page import="java.sql.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href='<%=conPath %>/css/join.css' rel='stylesheet'>
</head>
<body>
	<%!
		String id, name, tel, email, address, gender;
		Date birth;
	%>
	<%
		CustomerDto customer = (CustomerDto)session.getAttribute("customer");
		if(customer==null){
			response.sendRedirect("login.jsp?method=modify");
		} else {
			id      = customer.getCid();
			name    = customer.getCname();
			tel     = customer.getCtel();
			email   = customer.getCemail();
			address = customer.getCaddress();
			birth   = customer.getCbirth();
			gender  = customer.getCgender();
		}
	%>
	<div id="joinForm_wrap">
		<div id="join_title">정보수정</div>
		<form action="modifyPro.jsp" method="post">
			<table>
				<tr>
					<th><label for="cid">아이디</label></th>
					<td><input type="text" name="cid" id="cid" class="cid" value="<%=id %>" readonly="readonly"></td>
				</tr>
				<tr>
					<th><label for="cpw">현재 비밀번호</label></th>
					<td><input type="password" name="coldpw" id="cpw" class="cpw" required="required"></td>
				</tr>
				<tr>
					<th><label for="cpwChk">새 비밀번호확인</label></th>
					<td><input type="password" name="cpw" id="cpwChk" class="cpwChk" placeholder="비밀번호 수정을 원하지 않으면 입력하지 마세요"></td>
				</tr>
				<tr>
					<th><label for="cname">이름</label></th>
					<td><input type="text" name="cname" id="cname" class="cname" required="required" value="<%=name %>"></td>
				</tr>
				<tr>
					<th><label for="ctel">전화</label></th>
					<td><input type="text" name="ctel" id="ctel" class="ctel" value='<%=tel==null ? "" : tel %>'></td>
				</tr>
				<tr>
					<th><label for="cemail">이메일</label></th>
					<td><input type="text" name="cemail" id="cemail" class="cemail" value='<%=email==null ? "" : email %>'></td>
				</tr>
				<tr>
					<th><label for="caddress">주소</label></th>
					<td><input type="text" name="caddress" id="caddress" class="caddress" value='<%=address==null ? "" : address%>'></td>
				</tr>
				<tr>
					<th><label for="cbirth">생년월일</label></th>
					<td><input type="date" name="tempBirth" id="cbirth" class="cbirth" value='<%=birth==null ? "" : birth.toString() %>'></td>
				</tr>
				<tr>
					<th>성별</th>
					<td>
						<%if("m".equals(gender)) {%>
							<input type="radio" name="cgender" value="m" id="m" checked="checked"><label for="m">남자</label>
							<input type="radio" name="cgender" value="f" id="f"><label for="f">여자</label>
						<%} else if("f".equals(gender)) {%>
							<input type="radio" name="cgender" value="m" id="m"><label for="m">남자</label>
							<input type="radio" name="cgender" value="f" id="f" checked="checked"><label for="f">여자</label>
						<%} else {%>
							<input type="radio" name="cgender" value="m" id="m"><label for="m">남자</label>
							<input type="radio" name="cgender" value="f" id="f"><label for="f">여자</label>
						<%} %>
					</td>
				</tr>
				<tr>
					<td colspan="2"> </td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="수정하기" class="joinBtn_style">
						<input type="reset" value="다시하기" class="joinBtn_style">
						<input type="button" value="이전으로" onclick="history.back();" class="joinBtn_style">
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>