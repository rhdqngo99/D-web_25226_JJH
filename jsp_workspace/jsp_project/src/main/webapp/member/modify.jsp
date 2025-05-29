<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Member modify Page</h1>

<form action="/mem/update" method="post">
	id : <input type="text" name="id" value="${ses.id }" placeholder="id..." readonly="readonly"><br>
	pwd : <input type="password" name="pwd"  value="${ses.pwd }" placeholder="password..."> <br>
	email : <input type="text" name="email" value="${ses.email }" placeholder="email..."> <br>
	phone : <input type="text" name="phone" value="${ses.phone }" placeholder="phone..."> <br>
	regdate : <input type="text" name="regdate" value="${ses.regdate }" readonly="readonly">
	lastlogin : <input type="text" name="lastlogin" value="${ses.lastlogin }" readonly="readonly">
	<button type="submit">modify</button>
	<a href="/mem/remove"><button type="button">delete</button></a> 
</form>

<script type="text/javascript">

const msg_update = `<c:out value="${msg_update}"/>`;
if(msg_update === 'fail'){
	alert("정보가 수정되지 않았습니다.");
}
</script>
</body>
</html>