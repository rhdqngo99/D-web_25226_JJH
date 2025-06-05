<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="../layout/header.jsp"></jsp:include>

<div class="container-md">
	<h3>Board Modify Page</h3>
	<form action="/board/update" method="post">
		<div class="mb-3">
			<label for="exampleFormControlInput1" class="form-label">Bno</label>
			<input type="text" class="form-control" name="bno" value="${bvo.bno }" readonly="readonly" id="exampleFormControlInput1" placeholder="Title...">
		</div>
		<div class="mb-3">
			<label for="exampleFormControlInput1" class="form-label">Title</label>
			<input type="text" class="form-control" name="title" value="${bvo.title }" id="exampleFormControlInput1" placeholder="Title...">
		</div>
		<div class="mb-3">
			<label for="exampleFormControlInput1" class="form-label">Writer</label>
			<input type="text" class="form-control" name="writer" value="${bvo.writer }" readonly="readonly" id="exampleFormControlInput1" placeholder="writer...">
		</div>
		<div class="mb-3">
			<label for="exampleFormControlInput1" class="form-label">regDate</label>
			<input type="text" class="form-control" name="regDate" value="${bvo.regDate }" readonly="readonly" id="exampleFormControlInput1" placeholder="regDate...">
		</div>
		<div class="mb-3">
			<label for="exampleFormControlInput1" class="form-label">readCount</label>
			<input type="text" class="form-control" name="readCount" value="${bvo.readCount }" readonly="readonly" id="exampleFormControlInput1" placeholder="readCount">
		</div>
		<div class="mb-3">
			<label for="exampleFormControlTextarea1" class="form-label">Content</label>
			<textarea class="form-control" name="content" id="exampleFormControlTextarea1" rows="5">${bvo.content }</textarea>
		</div>
		
		<button type="submit" class="btn btn-success">update</button>
		<a href="/board/list"><button type="button" class="btn btn-primary">list</button></a>
	</form>
	
</div>
<jsp:include page="../layout/footer.jsp"></jsp:include>