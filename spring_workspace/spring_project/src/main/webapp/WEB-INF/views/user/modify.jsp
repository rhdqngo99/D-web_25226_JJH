<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<jsp:include page="../layout/header.jsp"></jsp:include>

<div class="container-md">
	<h3>User Modify Page</h3>
	<br>
	<sec:authentication property="principal.uvo" var="uvo"/>
	<form action="/user/modify" method="post">
		<div class="card" style="width: 18rem;">
		<img src="/resources/image/kia.webp" class="card-img-top" alt="...">
		<div class="card-body">
		  <h5 class="card-title">
		  	<input type="hidden" class="form-control" name="email" value="${uvo.email }">
		  	<input type="text" class="form-control" name="nickName" value="${uvo.nickName }">
		  	<input type="text" class="form-control" name="pwd" placeholder="password...">
		  </h5>
		  <p class="card-text">${uvo.email } </p>
		  <p class="card-text">(${uvo.regDate })</p>
		  <p class="card-text"><small>Last login  ${uvo.lastLogin} ago</small></p>
		  <div>
			  <c:forEach items="${uvo.authList }" var="auths">
				  <span class="badge rounded-pill text-bg-info">${auths.auth }</span>  
			  </c:forEach>	  
		  </div>
		  <br>
		  <button type="submit" class="btn btn-primary btn-sm">Modify</button>
		  <a href="/user/remove"><button type="button" class="btn btn-danger btn-sm">Delete</button></a>
		</div>
	</div>
	</form>
	
</div>
<jsp:include page="../layout/footer.jsp"></jsp:include>