<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<jsp:include page="../layout/header.jsp"></jsp:include>

<div class="container-md">

	<h3>Board Detail Page</h3>
	
	<%-- bdto > bvo / flist > bdto.bvo.bno 값을 저장하는 변수처럼 사용 --%>
	<c:set value="${bdto.bvo }" var="bvo"></c:set>
	
	<%-- <c:set value="${bdto.flist }" var="flist"></c:set> --%>
	<div class="mb-3">
		<label for="exampleFormControlInput1" class="form-label">Bno</label>
		<input type="text" class="form-control" name="bno" value="${bvo.bno }" readonly="readonly" id="exampleFormControlInput1" placeholder="Title...">
	</div>
	<div class="mb-3">
		<label for="exampleFormControlInput1" class="form-label">Title</label>
		<input type="text" class="form-control" name="title" value="${bvo.title }" readonly="readonly" id="exampleFormControlInput1" placeholder="Title...">
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
		<textarea class="form-control" name="content" readonly="readonly" id="exampleFormControlTextarea1" rows="5">${bvo.content }</textarea>
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
				</li>
			</c:forEach>
		</ul>
	</div>
	
	<sec:authorize access="isAuthenticated()">
	<sec:authentication property="principal.uvo.nickName" var="authNick"/>
	<c:if test="${bvo.writer eq authNick }">
		<a href="/board/modify?bno=${bvo.bno }"><button type="button" class="btn btn-success">modify</button></a>
		<a href="/board/remove?bno=${bvo.bno }"><button type="button" class="btn btn-danger">delete</button></a>
	</c:if>
	</sec:authorize>
	<a href="/board/list" ><button type="button" class="btn btn-primary">list</button></a>
	<br><br>
	<!-- comment line -->
	<!-- post -->
	<sec:authorize access="isAuthenticated()">
	<sec:authentication property="principal.uvo.nickName" var="authNick"/>
	<c:set value="${authNick }" var="nick"></c:set>
		<div class="input-group mb-3">
			<span class="input-group-text" id="cmtWriter">${authNick }</span>
			<input type="text" id="cmtText" class="form-control" placeholder="Add Comment..." aria-label="Username" aria-describedby="basic-addon1">
			<button type="button" id="cmtAddBtn" class="btn btn-secondary">post</button>
		</div>
	</sec:authorize>
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
		class="btn btn-outline-dark" style="visibility: hidden;">MORE +</button>
	</div>
	
	<!-- Modal -->
	<div class="modal fade" id="myModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
	  <div class="modal-dialog">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h1 class="modal-title fs-5" id="exampleModalLabel"></h1>
	        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
	      </div>
	      <div class="modal-body">
	        <input type="text" id="cmtTextMod" class="form-control">
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
	        <button type="button" id="cmtModBtn" class="btn btn-primary">changes</button>
	      </div>
	    </div>
	  </div>
	</div>
	
	<script type="text/javascript">
		const bnoValue = `<c:out value="${bvo.bno}" />`;
		const loginNick = `<c:out value="${nick}" />`; 
		console.log(bnoValue);
		console.log(loginNick);
	</script>
	<script type="text/javascript" src="/resources/js/boardDetailComment.js"></script>
	
	<!-- detail.jsp 열면 댓글 출력 -->
	<script type="text/javascript">
		spreadCommentList(bnoValue);
	</script>
</div>
<jsp:include page="../layout/footer.jsp"></jsp:include>