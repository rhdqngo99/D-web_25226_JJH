<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/resources/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="/resources/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<nav class="navbar navbar-expand-lg bg-body-tertiary">
<div class="container-fluid">
  <a class="navbar-brand" href="#">
    <img src="/resources/image/pochacco.png" alt="Bootstrap" width="50" height="50">
  </a>
  <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav me-auto mb-2 mb-lg-0">
      <li class="nav-item">
        <a class="nav-link active" aria-current="page" href="/">Home</a>
      </li>
      <li class="nav-item">
        <a class="nav-link active" aria-current="page" href="/board/register">Board Register</a>
      </li>
      <li class="nav-item">
        <a class="nav-link active" aria-current="page" href="/board/list">Board List</a>
      </li>
      <sec:authorize access="isAnonymous()">
	      <li class="nav-item">
	        <a class="nav-link active" aria-current="page" href="/user/register">Join</a>
	      </li>
	      <li class="nav-item">
	        <a class="nav-link active" aria-current="page" href="/user/login">Login</a>
	      </li>      
      </sec:authorize>
      <sec:authorize access="isAuthenticated()">
      <!-- 인증객체가 만들어져 있는 상태 (로그인이 이루어진 상태) -->
      <!-- 인증 객체를 가져오기 => 현재 로그인 정보 : principal -->
      <sec:authentication property="principal" var="pri"/>
	      <li class="nav-item">
	      	<form action="/user/logout" method="post" id="logoutForm">
		        <a href="" class="nav-link active" id="logoutLink" aria-current="page">Logout</a>
	      	</form>
	      </li>
	      <li class="nav-item">
	        <a class="nav-link active" aria-current="page" href="/user/modify">(${pri.username })Modify</a>
	      </li>  
		<c:if test="${pri.uvo.authList.stream().anyMatch(authVO -> authVO.auth.equals('ROLE_ADMIN')).get() }">
	      <li class="nav-item">
	        <a class="nav-link active" aria-current="page" href="/user/list">UserList(ADMIN)</a>
	      </li>
	    </c:if>    
      </sec:authorize>
      
    </ul>
    
  </div>
</div>
</nav>

<script type="text/javascript">
document.getElementById('logoutLink').addEventListener('click',(e)=>{
    e.preventDefault(); // 기존 a 태그의 링크를 없애는 역할
    document.getElementById('logoutForm').submit();
})

</script>