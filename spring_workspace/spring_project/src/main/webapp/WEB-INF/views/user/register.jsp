<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="../layout/header.jsp"></jsp:include>

<div class="container-md">
	<h3>User Join Page</h3>
	<form action="/user/register" method="post">
	<!-- CSRF 토큰 추가 -->
		<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }">
		<div class="mb-3">
			<label for="e" class="form-label">Email address</label>
			<input type="text" class="form-control" name="email" id="e" placeholder="name@example.com">
		</div>
		<div class="mb-3">
			<label for="p" class="form-label">Password</label>
			<input type="text" class="form-control" name="pwd" id="p" placeholder="password...">
		</div>
		<div class="mb-3">
			<label for="n" class="form-label">NickName</label>
			<input type="text" class="form-control" name="nickName" id="n" placeholder="nickName...">
		</div>
		<button type="submit" class="btn btn-primary">JOIN</button>
	</form>
	
</div>
<jsp:include page="../layout/footer.jsp"></jsp:include>