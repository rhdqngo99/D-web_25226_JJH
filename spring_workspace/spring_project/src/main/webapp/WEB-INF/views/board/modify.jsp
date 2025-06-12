<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="../layout/header.jsp"></jsp:include>

<div class="container-md">
	<h3>Board Modify Page</h3>
	<c:set value="${bdto.bvo }" var="bvo"></c:set>
	<form action="/board/update" method="post" enctype="multipart/form-data">
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
			<label for="exampleFormControlInput1" class="form-label">cmtQty</label>
			<input type="text" class="form-control" name="cmtQty" value="${bvo.cmtQty }" readonly="readonly" id="exampleFormControlInput1" >
		</div>
		<div class="mb-3">
			<label for="exampleFormControlInput1" class="form-label">fileQty</label>
			<input type="text" class="form-control" name="fileQty" value="${bvo.fileQty }" readonly="readonly" id="exampleFormControlInput1">
		</div>
		<div class="mb-3">
			<label for="exampleFormControlTextarea1" class="form-label">Content</label>
			<textarea class="form-control" name="content" id="exampleFormControlTextarea1" rows="5">${bvo.content }</textarea>
		</div>
		
		<!-- file upload print -->
	<div class="mb-3">
		<ul class="list-group list-group-flush">
		<!-- 파일 갯수만큼 li 반복 타입이 1이면 그림을 표시 아니면 그냥 파일모양으로 표시 -->
			<c:forEach items="${bdto.flist }" var="fvo">
				<li class="list-group-item">
				<c:choose>
					<c:when test="${fvo.fileType > 0 }">
						<!-- 그림 파일 -->
						<div>
							<img alt="" src="/upload/${fvo.saveDir }/${fvo.uuid}_${fvo.fileName}">
						</div>
					</c:when>
					<c:otherwise>
						<!-- 일반파일 : 다운로드 가능 -->
						<a href="/upload/${fvo.saveDir }/${fvo.uuid}_${fvo.fileName}" download="${fvo.fileName }">
							<!-- 파일모양 아이콘 -->
							<svg xmlns="http://www.w3.org/2000/svg" width="30" height="30" fill="currentColor" class="bi bi-file-arrow-down-fill" viewBox="0 0 16 16">
							  <path d="M12 0H4a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h8a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2M8 5a.5.5 0 0 1 .5.5v3.793l1.146-1.147a.5.5 0 0 1 .708.708l-2 2a.5.5 0 0 1-.708 0l-2-2a.5.5 0 1 1 .708-.708L7.5 9.293V5.5A.5.5 0 0 1 8 5"/>
							</svg>
						</a>
					</c:otherwise>
				</c:choose>
					<div class="mb-3">
						<div class="fw-bold">${fvo.fileName }</div>
					</div>
					<span class="badge text-bg-primary">${fvo.regDate } / ${fvo.fileSize } Bytes</span>
					<button type="button" class="btn btn-outline-danger btn-sm file-x" data-uuid="${fvo.uuid}">x</button>
				</li>
			</c:forEach>
		</ul>
	</div>
		
		<!-- 그림 추가 버튼 (register.jsp) -->
		<!-- 파일 첨부 라인 -->
		<div class="mb-3">
			<label for="file" class="form-label"></label>
			<input type="file" class="form-control" name="files" id="file" multiple="multiple" style="display: none">
			<button type="button" class="btn btn-outline-dark" id="trigger">file</button>
		</div>
		
		<!-- 파일 목록 라인 -->
		<div class="mb-3" id="fileZone"></div>
		
		<button type="submit" class="btn btn-success" id="regBtn">update</button>
		<a href="/board/list"><button type="button" class="btn btn-primary">list</button></a>
	</form>
	
	<script type="text/javascript" src="/resources/js/boardRegisterFile.js"></script>
	<script type="text/javascript" src="/resources/js/boardModify.js"></script>
</div>
<jsp:include page="../layout/footer.jsp"></jsp:include>