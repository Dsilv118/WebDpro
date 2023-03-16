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
	<c:set var="SUCCESS" value="1"/>
	<c:set var="FAIL" value="0"/>
	<c:if test="${modifyResult eq SUCCESS }">
		<script>alert('${param.fid}번글 수정 성공');</script>
	</c:if>
	<c:if test="${modifyResult eq FAIL }">
		<script>
			alert('${param.fid}번글 수정 실패');
			history.back();
		</script>
	</c:if>
	<jsp:include page="../main/header.jsp"/>
	<div id="content_form">
		<table>
			<caption>상세보기</caption>
			<tr><th>작성자</th><td>${BoardContent.mname }(${BoardContent.mid })님</td></tr>
			<tr><th>제목</th><td>${BoardContent.ftitle }</td></tr>
			<tr><th>본문</th><td>${BoardContent.fcontent }</td></tr>
			<tr><th>첨부파일</th><td>${BoardContent.ffilename }</td></tr>
			<tr>
				<td colspan="2">
					<c:if test="${member.mid == BoardContent.mid }">
						<button class="btn" onclick="location.href='boardModifyView.do?fid=${param.fid }&pageNum=${param.pageNum }'">수정</button>
						<button class="btn" onclick="location.href='boardDelete.do?fid=${param.fid }&pageNum=${param.pageNum }'">삭제</button>	
						<button class="btn" onclick="location.href='boardReplyView.do?fid=${param.fid }&pageNum=${param.pageNum }'">답변</button>			
					</c:if>
					<c:if test="${not empty member and member.mid != BoardContent.mid}">
						<button class="btn" onclick="location.href='boardReplyView.do?fid=${param.fid }&pageNum=${param.pageNum }'">답변</button>
						<button class="btn" onclick="location.href='boardList.do?pageNum=${param.pageNum }'">목록</button>
					</c:if>
					<c:if test="${not empty admin }">
						<button class="btn" onclick="location.href='boardDelete.do?fid=${param.fid }&pageNum=${param.pageNum }'">삭제</button>	
						<button class="btn" onclick="location.href='boardReplyView.do?fid=${param.fid }&pageNum=${param.pageNum }'">답변</button>
					</c:if>
					<button class="btn" onclick="location.href='boardList.do?pageNum=${param.pageNum }'">목록</button>
				</td>
			</tr>
		</table>
	</div>
	<jsp:include page="../main/footer.jsp"/>
</body>
</html>