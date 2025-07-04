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
<h1>Board Detail Page</h1>

<div>
	<img alt="" src="/_fileUpload/${bvo.imageFile }">
</div>

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
<c:if test="${bvo.writer eq ses.id }">
	<a href="/brd/modify?bno=${bvo.bno }"><button type="button">modify</button></a>
	<a href="/brd/remove?bno=${bvo.bno }"><button type="button">remove</button></a>
</c:if>

<a href="/brd/list"><button type="button">list</button></a>

<!-- comment line -->
<hr>
<div>
	<h3>comment line</h3>
	<input type="text" id="cmtWriter" value="${ses.id }" placeholder="writer..."><br>
	<input type="text" id="cmtText" placeholder="Add comment...">
	<button type="button" id="cmtAddBtn">comment post</button>
</div>
<br>
<hr>

<!-- comment print -->
<div id="commentLine">
	<div>
		<div>cno, bno, writer, regdate</div>
		<div>
			<button type="button">수정</button> <button type="button">삭제</button><br>
			<input type="text" value="content...">
		</div>
	</div>
</div>

<script type="text/javascript">
	const bnoValue = `<c:out value="${bvo.bno}" />`;
	const loginUser = `<c:out value="${ses.id}" />`;
	console.log(bnoValue);
	console.log(loginUser);
</script>

<script type="text/javascript" src="/resources/boardDetail.js"></script>

<script type="text/javascript">
	printCommentList(bnoValue);
</script>

</body>
</html>