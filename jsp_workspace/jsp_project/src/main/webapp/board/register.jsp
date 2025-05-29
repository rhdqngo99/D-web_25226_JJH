<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Register page</h1>
	<form action="/brd/insert" method="post" enctype="multipart/form-data">
		title : <input type="text" name="title" placeholder="title..."> <br>
		writer : <input type="text" name="writer" value="${ses.id }" readonly="readonly" placeholder="writer..."> <br>
		content<br>
		<textarea rows="20" cols="30" name="content">content...</textarea><br>
		첨부파일 <br>
		<input type="file" name="imageFile"><br>
		
		<!-- insert 버튼을 클릭하면 action의 주소 (/brd/insert) 주소로 데이터를 이동 -->
		<button type="submit">insert</button>
		<button type="reset">reset</button>
	</form>
</body>
</html>