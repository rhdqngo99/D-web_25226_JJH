<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="../layout/header.jsp"></jsp:include>

<div class="container-md">
	<h3>User List Page</h3>
	<br>
	<div class="row justify-content-center">
	<c:forEach items="${userList }" var="uvo">
	<div class="col">
		<div class="card" style="width: 18rem;">
			<img src="/resources/image/kia.webp" class="card-img-top" alt="...">
			<div class="card-body">
			  <h5 class="card-title">${uvo.nickName }</h5>
			  <p class="card-text">${uvo.email } </p>
			  <p class="card-text">(${uvo.regDate })</p>
			  <p class="card-text"><small>Last login  ${uvo.lastLogin} ago</small></p>
			  <div>
				  <c:forEach items="${uvo.authList }" var="auths">
					  <span class="badge rounded-pill text-bg-info">${auths.auth }</span>  
				  </c:forEach>	  
			  </div>
			</div>
		</div>
	</div>
	</c:forEach>
	</div>
</div>
<jsp:include page="../layout/footer.jsp"></jsp:include>