<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Board List Page</h1>

<!-- search line -->
<%-- jsp 주석 => 다른 소스코드 전부 주석처리가능 --%>
<%-- selected : 화면이 처음 열렸을 때 선택된 상태를 유지 --%>
<%-- ${ == (eq) | != (ne) } --%>
<div>
	<form action="/brd/list" method="get">
		<div>
			<select name="type">
				<option ${ph.pgvo.type eq null ? 'selected' : '' }>Choose...</option>
				<option value="t" ${ph.pgvo.type eq 't' ? 'selected' : '' }>title</option>
				<option value="w" ${ph.pgvo.type eq 'w' ? 'selected' : '' }>writer</option>
				<option value="c" ${ph.pgvo.type eq 'c' ? 'selected' : '' }>content</option>
			</select>
			<input type="text" name="keyword" value="${ph.pgvo.keyword }" placeholder="Search...">
			<input type="hidden" name="pageNo" value="1">
			<input type="hidden" name="qty" value="${ph.pgvo.qty }">
			<button type="submit">Search</button>
			<span>totalCount : ${ph.totalCount }</span>
			<a href="/brd/list">검색해지</a>
		</div>
	</form>
</div>

<table>
	<tr>
		<th>no.</th>
		<th>title</th>
		<th>wirter</th>
		<th>regdate</th>
	</tr>
	
	
	<c:forEach items="${list }" var="bvo">
		<tr>
			<td>${bvo.bno }</td>
			<td>
				<a href="/brd/detail?bno=${bvo.bno }">
				<img alt="" src="/_fileUpload/_th_${bvo.imageFile }">
					${bvo.title }
				</a>
			</td>
			<td>${bvo.writer }</td>
			<td>${bvo.regdate }</td>
		</tr>	
	</c:forEach>
</table>

<!-- paging line -->
<div>
	<c:if test="${ph.prev }">
		<a href="/brd/list?pageNo=${ph.startPage-1 }&qty=${ph.pgvo.qty}&type=${ph.pgvo.type}&keyword=${ph.pgvo.keyword}"> ‹ </a>
	</c:if>
	
	<c:forEach begin="${ph.startPage }" end="${ph.endPage }" var="i">
		<a href="/brd/list?pageNo=${i }&qty=${ph.pgvo.qty}&type=${ph.pgvo.type}&keyword=${ph.pgvo.keyword}">${i }</a>
	</c:forEach>
	
	<c:if test="${ph.next }">
		<a href="/brd/list?pageNo=${ph.endPage+1 }&qty=${ph.pgvo.qty}&type=${ph.pgvo.type}&keyword=${ph.pgvo.keyword}"> › </a>
	</c:if>
</div>

<a href="/index.jsp">index.jsp로 이동</a>

</body>
</html>










