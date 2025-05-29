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
	<h1>Hello jsp World~!!</h1>
	
	<h3><a href="/brd/register">게시판 글쓰기</a></h3>
	<h3><a href="/brd/list">게시판 목록 보기</a></h3>
	
	<div>
		<h3><a href="/mem/register">회원가입</a></h3>
	</div>
	
	<div>
	<c:if test="${ses.id eq null }">
		<form action="/mem/login">
			id : <input type="text" name="id" placeholder="id...">
			pwd : <input type="password" name="pwd" placeholder="pwd...">
			<button type="submit">login</button>
		</form>
	</c:if>
	</div>
	
	<%-- ne: 아니면, eq: 같으면 --%>
	<div>
		<c:if test="${ses.id ne null }">
			${ses.id }(${ses.email })님이 login 했습니다.<br>
			마지막 접속일 : ${ses.lastlogin } <br>
			<form action="/brd/list" method="post">
				<input type="hidden" name="type" value="w">
				<input type="hidden" name="keyword" value="${ses.id }">
				<input type="hidden" name="pageNo" value="1">
				<input type="hidden" name="qty" value="10">
				<button type="submit">내가 쓴 글 보기</button>
			</form>
			<a href="/mem/logout"> <button>logout</button> </a>
			<a href="/mem/modify"> <button>회원정보수정</button> </a>
			<a href="/mem/list"> <button>회원리스트</button> </a>
		</c:if>
	</div>
	
	<script type="text/javascript">
		const msg_login = `<c:out value="${msg_login}"/>`;
		if(msg_login === '-1'){
			alert("로그인 정보가 일치하지 않습니다.");
		}
		
		const msg_update = `<c:out value="${msg_update}"/>`;
		if(msg_update === 'ok'){
			alert("새로운 정보로 로그인하세요.");
		}
		
		const msg_delete = `<c:out value="${msg_delete}"/>`;
		if(msg_delete === 'ok'){
			alert("탈퇴가 정상적으로 이루어졌습니다.");
		}
	</script>
	
</body>
</html>