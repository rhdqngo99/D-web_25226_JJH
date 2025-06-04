<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="../layout/header.jsp"></jsp:include>

<div class="container-md">
	<h3>Board Detail Page</h3>
	<div class="mb-3">
		 <label for="exampleFormControlInput1" class="form-label">title</label>
		 <input type="text" class="form-control" name="title" value="${bvo.title }" id="exampleFormControlInput1" placeholder="title">
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
		
	<a href="/board/modify?bno=${bvo.bno }"><button type="button" class="btn btn-success">modify</button></a>
	<a href="/board/remove?bno=${bvo.bno }"><button type="button" class="btn btn-danger">delete</button></a>
	<a href="/board/list"><button type="button" class="btn btn-primary">list</button></a>
	<br><br>
<!-- comment line -->
	<!-- post -->
	<div class="input-group mb-3">
		<span class="input-group-text" id="cmtWriter">writer</span>
		<input type="text" id="cmtText" class="form-control" placeholder="Add Comment..." aria-label="Username" aria-describedby="basic-addon1">
		<button type="button" id="cmtAddBtn" class="btn btn-secondary">post</button>
	</div>
	<br>
	<!-- print -->
	<ul class="list-group list-group-flush" id="cmtListArea">
		<li class="list-group-item">
			<div class="mb-3">
				<div class="fw-bold">writer</div>
				content
			</div>
			<span class="badge text-bg-primary">regDate</span>
		</li>
	</ul>
	
	<!-- 댓글 더보기 버튼 : 한 페이지에 5개 댓글 표시 더 있으면 더보기 버튼 활성화 / 없으면 사라짐 -->
	<div class="mb-3">
		<button type="button" id="moreBtn" data-page="1"
		class="btn btn-dark" style="visibility: hidden;">MORE +</button>
	</div>
	
	<script type="text/javascript">
		const bnoValue = `<c:out value="${bvo.bno}" />`;
		console.log(bnoValue);
	</script>
	<script type="text/javascript" src="/resources/js/boardDetailComment.js"></script>
	
	<!-- Modal -->
	<div class="modal fade" id="myModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
	  <div class="modal-dialog">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h1 class="modal-title fs-5" id="exampleModalLabel">Modal title</h1>
	        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
	      </div>
	      <div class="modal-body">
	        ...
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
	        <button type="button" class="btn btn-primary">Save changes</button>
	      </div>
	    </div>
	  </div>
	</div>
	
	<!-- detail.jsp 열면 댓글 출력 -->
	<script type="text/javascript">
		spreadCommentList(bnoValue);
	</script>

</div>
<jsp:include page="../layout/footer.jsp"></jsp:include>