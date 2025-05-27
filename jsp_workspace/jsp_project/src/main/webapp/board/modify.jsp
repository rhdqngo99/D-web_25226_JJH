<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Board Modify Page</h1>

<form action="/brd/update" method="post" enctype="multipart/form-data">
<input type="hidden" name="bno" value="${bvo.bno}">
<input type="hidden" name="imageFile" value="${bvo.imageFile }">
<div>
	<img alt="" src="/_fileUpload/${bvo.imageFile }">
</div>
	<table>
	<tr>
		<th>no.</th>
		<td>${bvo.bno}</td>
	</tr>
	<tr>
		<th>title</th>
		<td> <input type="text" name="title" value="${bvo.title }"> </td>
	</tr>
	<tr>
		<th>writer</th>
		<td><input type="text" name="writer" value="${bvo.writer }" readonly></td>
	</tr>
	<tr>
		<th>regdate</th>
		<td>${bvo.regdate}</td>
	</tr>
	<tr>
		<th>moddate</th>
		<td>${bvo.moddate}</td>
	</tr>
	<tr>
		<th>content</th>
		<td> <textarea rows="15" cols="30" name="content" >${bvo.content }</textarea> </td>
	</tr>
</table>
<button type="submit">update</button>
<a href="/brd/list"><button type="button">list</button></a>
</form>

</body>
</html>