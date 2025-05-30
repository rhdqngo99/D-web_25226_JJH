<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="container-md">
	<h3>Board List Page</h3>
	<table class="table">
	  <thead>
	    <tr>
	      <th scope="col">#</th>
	      <th scope="col">title</th>
	      <th scope="col">writer</th>
	      <th scope="col">content</th>
	      <th scope="col">reg_date</th>
	      <th scope="col">read_count</th>
	    </tr>
	  </thead>
	  <tbody>
	  	<c:forEach items="${list }" var="bvo">
		    <tr>
		      <th scope="row">${bvo.bno }</th>
		      <td>${bvo.title }</td>
		      <td>${bvo.writer }</td>
		      <td>${bvo.content }</td>
		      <td>${bvo.regDate }</td>
		      <td>${bvo.readCount }</td>
		    </tr>
	  	</c:forEach>
	  </tbody>
	</table>
	
</div>
<jsp:include page="../layout/footer.jsp"></jsp:include>