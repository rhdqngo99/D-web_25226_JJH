<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="../layout/header.jsp"></jsp:include>

<div class="container-md">
	<h3>User Login Page</h3>
	<form action="/user/login" method="post">
		<div class="mb-3">
			<label for="e" class="form-label">Email address</label>
			<input type="text" class="form-control" name="email" id="e" placeholder="name@example.com">
		</div>
		<div class="mb-3">
			<label for="p" class="form-label">Password</label>
			<input type="text" class="form-control" name="pwd" id="p" placeholder="password...">
		</div>
		<!-- 로그인 실패시 에러 메시지 출력 -->
		<c:if test="${errmsg ne null}">
			<div class="text-danger">${errmsg } / ${email }</div>
		</c:if>
		
		<button type="submit" class="btn btn-primary">login</button>
	</form>
	
</div>
<jsp:include page="../layout/footer.jsp"></jsp:include>