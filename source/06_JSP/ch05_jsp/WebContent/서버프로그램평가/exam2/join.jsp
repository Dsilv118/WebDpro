<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="join.css" rel="stylesheet">
</head>
<body>
	<div id="joinForm_wrap">
		<div id="join_title">
			회원가입
		</div>
		<form action="joinPro.jsp" method="post">
			<table>
				<tr>
					<th>이름</th>
					<td><input type="text" name="name" class="name"></td>
				</tr>
				<tr>
					<th>아이디</th>
					<td><input type="text" name="id" class="id"></td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td><input type="password" name="pw" class="pw"></td>
				</tr>
				<tr>
					<th>비밀번호확인</th>
					<td><input type="password" name="pwChk" class="pwChk"></td>
				</tr>
				<tr>
					<th>생년월일</th>
					<td><input type="date" name="birth" class="birth"></td>
				</tr>
				<tr>
					<th>취미</th>
					<td><input type="checkbox" name="hobby" value="독서">독서
						<input type="checkbox" name="hobby" value="요리">요리
						<input type="checkbox" name="hobby" value="운동">운동
						<input type="checkbox" name="hobby" value="취침">취침</td>
				</tr>
				<tr>
					<th>성별</th>
					<td><input type="radio" name="gender" value="f">여성
						<input type="radio" name="gender" value="m">남성</td>
				</tr>
				<tr>
					<th>이메일</th>
					<td><input type="text" name="email" class="email"></td>
				</tr>
				<tr>
					<th>메일수신</th>
					<td>
						<select multiple="multiple" class="mailSend">
							<option value="광고">광고</option>
							<option value="배송">배송</option>
							<option value="공지">공지</option>
						</select>
					</td>
				</tr>
			</table>
			<button type="submit" class="joinBtn_style">가입하기</button>
			<button class="joinBtn_style" type="reset">다시하기</button>
			<button class="joinBtn_style" onclick="history.back()">뒤로가기</button>
		</form>
	</div>
	<%@ include file="footer.jsp" %>
</body>
</html>