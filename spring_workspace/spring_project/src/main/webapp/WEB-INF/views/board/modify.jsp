<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="../layout/header.jsp"></jsp:include>

<div class="container-md">
	<h3>Board Detail Page</h3>
	<form action="//">
		<div class="mb-3">
			 <label for="exampleFormControlInput1" class="form-label">Bno</label>
			 <input type="text" class="form-control" name="bno" value="${bvo.bno }" id="exampleFormControlInput1" placeholder="title">
		</div>
		<div class="mb-3">
			 <label for="exampleFormControlInput1" class="form-label">writer</label>
			 <input type="text" class="form-control" name="writer" value="${bvo.writer }" id="exampleFormControlInput1" placeholder="writer">
		</div>
		<div class="mb-3">
			 <label for="exampleFormControlInput1" class="form-label">regDate</label>
			 <input type="text" class="form-control" name="regDate" value="${bvo.regDate }" id="exampleFormControlInput1" placeholder="writer">
		</div>
		<div class="mb-3">
			 <label for="exampleFormControlInput1" class="form-label">readCount</label>
			 <input type="text" class="form-control" name="readCount" value="${bvo.readCount }" id="exampleFormControlTextarea1" rows="3"></input>
		</div>
		<div class="mb-3">
			 <label for="exampleFormControlTextarea1" class="form-label">content</label>
		  <textarea class="form-control" name="content" id="exampleFormControlTextarea1" rows="3">${bvo.content }</textarea>
		</div>
		
		<button type="button" class="btn btn-success">update</button>
		<a href="/board/list"><button type="button" class="btn btn-success">list</button></a>
	</form>

</div>
<jsp:include page="../layout/footer.jsp"></jsp:include>