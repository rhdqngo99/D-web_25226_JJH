<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Board Detail Page</h1>

<table>
	<tr>
		<th>no.</th>
		<td>${bvo.bno }</td>
	</tr>
	<tr>
		<th>title</th>
		<td>${bvo.title }</td>
	</tr>
	<tr>
		<th>writer</th>
		<td>${bvo.writer }</td>
	</tr>
	<tr>
		<th>regdate</th>
		<td>${bvo.regdate }</td>
	</tr>
	<tr>
		<th>moddate</th>
		<td>${bvo.moddate }</td>
	</tr>
	<tr>
		<th>content</th>
		<td>${bvo.content }</td>
	</tr>
</table>
<a href="/brd/modify?bno=${bvo.bno }"><button type="button">modify</button></a>
<a><button type="button">remove</button></a>

</body>
</html>