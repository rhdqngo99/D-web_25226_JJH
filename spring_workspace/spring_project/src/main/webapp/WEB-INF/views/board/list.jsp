<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="../layout/header.jsp"></jsp:include>
<div class="container-md">
	<h3>Board List Page</h3>
	<br>
	<!-- search line -->
	
		 <form class="d-flex" role="search" action="/board/list" method="get">
	 	<select class="form-select me-2" name="type" aria-label="Default select example">
			<option ${ph.pgvo.type eq null ? 'selected' : '' }>Choose...</option>
			<option value="t" ${ph.pgvo.type eq 't' ? 'selected' : '' }>Title</option>
			<option value="w" ${ph.pgvo.type eq 'w' ? 'selected' : '' }>Writer</option>
			<option value="c" ${ph.pgvo.type eq 'c' ? 'selected' : '' }>Content</option>
			<option value="tw" ${ph.pgvo.type eq 'tw' ? 'selected' : '' }>Title + Writer</option>
			<option value="tc" ${ph.pgvo.type eq 'tc' ? 'selected' : '' }>Title + Content</option>
			<option value="wc" ${ph.pgvo.type eq 'wc' ? 'selected' : '' }>Writer + Content</option>
			<option value="twc" ${ph.pgvo.type eq 'twc' ? 'selected' : '' }>All</option>
		</select>
        <input class="form-control me-2" name="keyword" value="${ph.pgvo.keyword }" type="search" placeholder="Search" aria-label="Search" />
        <input type="hidden" name="pageNo" value="1">
        <input type="hidden" name="qty" value="${ph.pgvo.qty }">
        <button type="submit" class="btn btn-success position-relative">
			Search
			<span class="position-absolute top-0 start-100 translate-middle badge rounded-pill text-bg-warning">
			  ${ph.totalCount }
			  <span class="visually-hidden">unread messages</span>
			</span>
		</button>
     </form>
	<br>
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
		      <td><a href="/board/detail?bno=${bvo.bno }">${bvo.title }</a></td>
		      <td>${bvo.writer }</td>
		      <td>${bvo.content }</td>
		      <td>${bvo.regDate }</td>
		      <td>${bvo.readCount }</td>
		    </tr>
	  	</c:forEach>
	  </tbody>
	</table>
	
	<!-- Paging line -->
	<nav aria-label="Page navigation example">
		<ul class="pagination justify-content-center">
		  <!-- 이전 -->
		  <li class="page-item ${ph.prev eq false ? 'disabled':'' }">
		    <a class="page-link" href="/board/list?pageNo=${ph.startPage-1 }&qty=${ph.pgvo.qty}&type=${ph.pgvo.type}&keyword=${ph.pgvo.keyword}" aria-label="Previous">
		      <span aria-hidden="true">&laquo;</span>
		    </a>
		  </li>
		  
		  <c:forEach begin="${ph.startPage }" end="${ph.endPage }" var="i">
			  <li class="page-item ${ph.pgvo.pageNo eq i ? 'active':'' }"><a class="page-link" href="/board/list?pageNo=${i }&qty=${ph.pgvo.qty}&type=${ph.pgvo.type}&keyword=${ph.pgvo.keyword}">${i }</a></li>		  
		  </c:forEach>
		  
		  <!-- 다음 -->
		  <li class="page-item ${ph.next eq false ? 'disabled':'' }">
		    <a class="page-link" href="/board/list?pageNo=${ph.endPage+1 }&qty=${ph.pgvo.qty}&type=${ph.pgvo.type}&keyword=${ph.pgvo.keyword}" aria-label="Next">
		      <span aria-hidden="true">&raquo;</span>
		    </a>
		  </li>
		</ul>
	</nav>

</div>
<jsp:include page="../layout/footer.jsp"></jsp:include>