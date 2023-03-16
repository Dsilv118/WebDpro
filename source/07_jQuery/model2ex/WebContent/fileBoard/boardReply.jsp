<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="${conPath }/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<jsp:include page="../main/header.jsp"/>
	<div id="content_form">
	<form action="${conPath }/boardReply.do" method="post" enctype="multipart/form-data">
		<input type="hidden" name="pageNum" value="${param.pageNum }">
		<input type="hidden" name="fid" value="${BoardReply.fid }"> 
		<input type="hidden" name="mid" value="${BoardReply.mid }"> <!-- 원글 -->
		<input type="hidden" name="fgroup" value="${BoardReply.fgroup }"> <!-- 원글 -->
		<input type="hidden" name="fstep" value="${BoardReply.fstep }"> <!-- 원글 -->
		<input type="hidden" name="findent" value="${BoardReply.findent }" > <!-- 원글 -->  
		<table>
			<table>
				<caption>${BoardReply.fid }번의 답글쓰기</caption>
				<tr>
					<th>작성자</th>
					<td>
						<input type="text" name="fid" maxlength="33" readonly="readonly" value="${member.mname }">
					</td>
				</tr>
				<tr>
					<th>제목</th>
					<td><input type="text" name="ftitle" required="required"></td>
				</tr>
				<tr>
					<th>본문</th>
					<td><textarea rows="5" cols="20" name="fcontent"></textarea></td>
				</tr>
				<tr>
					<th>첨부파일</th>
					<td>
						<input type="file" name="ffilename">
					</td>
				</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="답변글쓰기" class="btn">
					<input type="reset" value="취소" class="btn">
					<input type="button" value="목록" class="btn" onclick="location.href='${conPath}/boardList.do?pageNum=${param.pageNum }'">
				</td>
			</tr>
		</table>
	</form>
	</div>
	<jsp:include page="../main/footer.jsp"/>
</body>
</html>