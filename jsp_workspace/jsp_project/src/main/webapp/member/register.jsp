<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>회원가입 페이지</h1>
<form action="/mem/insert" method="post">
	id : <input type="text" name="id" placeholder="id..."><br>
	pwd : <input type="password" name="pwd" placeholder="password..."> <br>
	email : <input type="text" name="email" placeholder="email..."> <br>
	phone : <input type="text" name="phone" placeholder="phone..."> <br>
	<button type="submit">join</button>
</form>

</body>
</html>