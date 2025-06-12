<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>

<jsp:include page="layout/header.jsp"></jsp:include>

<div class="container-md">
	<h1>
		Hello world!  
	</h1>
	
	<P>  The time on the server is ${serverTime}. </P>
</div>

<script>
	const modify_msg = `<c:out value="${modify_msg}" />`;
	console.log(modify_msg);
	if(modify_msg === 'ok'){
		alert('회원정보가 수정되었습니다. 다시로그인 해주세요.');
	}
	if(modify_msg === 'fail'){
		alert('회원정보 수정이 실패되었습니다. 다시 시도해주세요.');
	}
	
	const remove_msg = `<c:out value="${remove_msg}" />`;
	console.log(remove_msg);
	if(remove_msg === 'ok'){
		alert('회원탈퇴 되었습니다. 안녕히가세요.');
	}
	if(remove_msg === 'fail'){
		alert('회원탈퇴가 실패되었습니다. 다시 시도해주세요.');
	}
	
</script>

<jsp:include page="layout/footer.jsp"></jsp:include>