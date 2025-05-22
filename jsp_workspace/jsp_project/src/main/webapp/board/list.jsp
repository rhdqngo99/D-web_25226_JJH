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
			<td><a href="/brd/detail?bno=${bvo.bno }">${bvo.title }</a></td>
			<td>${bvo.writer }</td>
			<td>${bvo.regdate }</td>
		</tr>	
	</c:forEach>
</table>

<a href="/index.jsp">index.jsp로 이동</a>

</body>
</html>