<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="${conPath }/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<form action="${conPath }/empSch">
		이름 <input type="text" name="schname" value="${param.schname.toUpperCase().trim() }">
		직책 <input type="text" name="schjob" value="${fn:toUpperCase(fn:trim(param.schjob)) }">
		<input type="submit" value="검색">
	</form>
	<table>
		<tr>
			<th>사번</th><th>이름</th><th>직책</th><th>상사사번</th>
			<th>입사일</th><th>급여</th><th>상여</th><th>부서</th>
		</tr>
		<c:if test="${edtos.size() eq 0 }">
			<tr><td colspan="8">검색 가능한 사원이 없습니다</td></tr>
		</c:if>
		<c:if test="${edtos.size() != 0 }">
			<c:forEach var="emp" items="${edtos }">
				<tr>
					<td>${emp.empno }</td>
					<td>
						<c:if test="${emp.sal > 2400 }">
							<img src="${conPath }/img/hot.gif">
						</c:if>
						<c:if test="${emp.mgr eq 0 }">
							<b style="color: red;">${emp.ename }
						</c:if>
						<c:if test="${emp.mgr != 0 }">
							${emp.ename }
						</c:if>
					</td>
					<td>${emp.job }</td>
					<td>${emp.mgr }</td>
					<td>
						<fmt:formatDate value="${emp.hiredate }" pattern="yyyy년 MM월 dd일 (E)"/>
					</td>
					<td>
						<fmt:formatNumber value="${emp.sal }" groupingUsed="true"/>
					</td>
					<td>
						${emp.comm eq 0 ? "-" : emp.comm }
					</td>
					<td>${emp.deptno }</td>
				</tr>
			</c:forEach>
		</c:if>
	</table>
</body>
</html>