<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../layout/header.jsp"></jsp:include>

<div class="container-md">
<br>
	<h3>Board Register Page</h3>
	
	<form action="/board/insert" method="post">
		<div class="mb-3">
		  <label for="exampleFormControlInput1" class="form-label">title</label>
		  <input type="text" class="form-control" name="title" id="exampleFormControlInput1" placeholder="title">
		</div>
		<div class="mb-3">
		  <label for="exampleFormControlInput1" class="form-label">writer</label>
		  <input type="text" class="form-control" name="writer" id="exampleFormControlInput1" placeholder="writer">
		</div>
		<div class="mb-3">
		  <label for="exampleFormControlTextarea1" class="form-label">content</label>
		  <textarea class="form-control" name="content" id="exampleFormControlTextarea1" rows="3"></textarea>
		</div>
		
		<button type="submit" class="btn btn-success">Register</button>
	</form>
</div>

<jsp:include page="../layout/footer.jsp"></jsp:include>