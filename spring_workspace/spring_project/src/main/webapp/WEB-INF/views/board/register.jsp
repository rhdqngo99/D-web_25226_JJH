<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>

<jsp:include page="../layout/header.jsp"></jsp:include>

<div class="container-md">
<br>
	<h3>Board Register Page</h3>
	<!-- 로그인이 되었을 때만 들어올 수 있는 페이지 -->
	<sec:authentication property="principal.uvo.nickName" var="authNick"/>
	
	<!-- enctype : multipart/form-dta -->
	<form action="/board/insert" method="post" enctype="multipart/form-data">
		<div class="mb-3">
			<label for="exampleFormControlInput1" class="form-label">Title</label>
			<input type="text" class="form-control" name="title" id="exampleFormControlInput1" placeholder="Title...">
		</div>
		<div class="mb-3">
			<label for="exampleFormControlInput1" class="form-label">Writer</label>
			<input type="text" class="form-control" name="writer" value="${authNick }" readonly="readonly" id="exampleFormControlInput1">
		</div>
		<div class="mb-3">
			<label for="exampleFormControlTextarea1" class="form-label">Content</label>
			<textarea class="form-control" name="content" id="exampleFormControlTextarea1" rows="5"></textarea>
		</div>
		
		<!-- 파일 첨부 라인 -->
		<div class="mb-3">
			<label for="file" class="form-label"></label>
			<input type="file" class="form-control" name="files" id="file" multiple="multiple" style="display: none">
			<button type="button" class="btn btn-outline-dark" id="trigger">file</button>
		</div>
		
		<!-- 파일 목록 라인 -->
		<div class="mb-3" id="fileZone"></div>
		
		<button type="submit" class="btn btn-success" id="regBtn">Register</button>
	</form>
	
	<script type="text/javascript" src="/resources/js/boardRegisterFile.js"></script>
</div>
<jsp:include page="../layout/footer.jsp"></jsp:include>