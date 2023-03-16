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
		<form action="boardModify.do" method="post" method="post" enctype="multipart/form-data">
			<input type="hidden" name="pageNum" value="${param.pageNum }">
			<input type="hidden" name="fid" value="${param.fid }">
			<table>
				<caption>${param.fid }번 글 수정하기</caption>
				<tr>
					<th>작성자</th>
					<td><input type="text" name="mname" value="${BoardModify.mname }" required="required" autofocus="autofocus"></td>
				</tr>
				<tr>
					<th>제목</th>
					<td><input type="text" name="ftitle" value="${BoardModify.ftitle }" required="required"></td>
				</tr>
				<tr>
					<th>본문</th>
					<td><textarea rows="5" name="fcontent">${BoardModify.fcontent }</textarea></td>
				</tr>
				<tr>
					<th>파일첨부</th>
					<td><input type="file" name="ffilename" value="${BoardModify.ffilename }"></td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="저장" class="btn">
						<input type="reset" value="취소" class="btn">
						<input type="button" value="목록" class="btn" onclick="location.href='${conPath}/list.do?pageNum=${param.pageNum }'">
					</td>
				</tr>
			</table>
		</form>
	</div>
	<jsp:include page="../main/footer.jsp"/>
</body>
</html>