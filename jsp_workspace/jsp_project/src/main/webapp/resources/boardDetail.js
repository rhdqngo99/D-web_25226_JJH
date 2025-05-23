
console.log("boardDetail.js in");
console.log(bnoValue);

// 댓글 등록
document.getElementById('cmtAddBtn').addEventListener('click',()=>{
	const cmtText = document.getElementById('cmtText');
	const cmtWriter = document.getElementById('cmtWriter');
	
	if(cmtText.value == null || cmtText.value == ""){
		alert('댓글을 입력해주세요.');
		return;
	}else{
		//댓글 객체
		let cmtData = {
			bno : bnoValue,
			writer : cmtWriter.value,
			content : cmtText.value
		}
			cmtWriter.value = "";
			cmtText.value="";
			cmtText.focus();
			
		// 댓글 비동기로 전송
		postCommentToServer(cmtData).then(result => {
			console.log(result);
			if(result == '1'){
				alert('댓글 등록 성공~!!');
			}else{
				alert('댓글 등록 실패');
			}
			printCommentList(cmtData.bno);
		});
	}
});

 // 댓글 등록 비동기
async function postCommentToServer(cmtData){
	try{
		// 보낼때 (json) => url, headers(contentType), body(cmtData)
		const url = "/cmt/post";
		const config ={
			method: 'post',
			headers:{
				'content-Type' : 'application/json; charset=utf-8'
			},
			body: JSON.stringify(cmtData)
		}
		const resp = await fetch(url, config);
		const result = await resp.text(); // isOk 값을 리턴
		return result;
		
	}catch(e){
		console.log(e);
	}
}

// 댓글 리스트 요청 비동기
async function getCommentListFromServer(bno){
	try{
		const resp = await fetch("/cmt/list?bno="+bno);
		const result = await resp.json(); // 댓글리스트 [{...},{...},{...}...]
		return result;
	}catch(e){
		console.log(e);
	}
}

function printCommentList(){
	getCommentListFromServer(bnoValue).then(result => {
		console.log(result);	
		const div = document.getElementById('commentLine');
		let str = "";
		if(result.length > 0){
			// 댓글이 있는 경우
			for(let cmt of result){
				str += `<div>`;
				str += `<div>${cmt.cno}, ${cmt.writer}(${cmt.regdate})</div>`;
				str += `<div>`;
				str += `<button type="button" data-cno=${cmt.cno} class="mod">수정</button>`;
				str += `<button type="button" data-cno=${cmt.cno} class="del">삭제</button>`;
				str += `<input type="text" class="cmtText" value="${cmt.content}">`;
				str += `</div></div>`;
			}
			div.innerHTML = str;
		}else{
			// 댓글이 없는 경우
			div.innerHTML = `<div>comment가 없습니다.`;
		}
	})
}

// 댓글 수정
async function updateCommentToServer(cmtData){
	try{
		const url = "/cmt/modify";
		const config = {
			method : 'post',
			headers:{
				'content-Typy' : 'application/json; charset=utf-8' 
			},
			body: JSON.stringify(cmtData)
		}
		const resp = await fetch(url, config);
		const result = await resp.text(); // isOk
		return result;
		 
	}catch(e){
		console.log(e);
	}
}

// 댓글 삭제 비동기 cno 주고 삭제 요청 /cmt/remove?cno=
async function removeCommentToServer(cno){
	try{
		const resp = await fetch("/cmt/remove?cno="+cno);
		const result = await resp.text(); // isOk
		return result;
		
	}catch(e){
		console.log(e);
	}
}

document.addEventListener('click',(e)=>{
	let cno = e.target.dataset.cno; //data-cno 값 추출
	console.log(cno);
	//  수정버튼일 경우
	if(e.target.classList.contains('mod')){
		// 수정 : cno, content
		// closest 내 타겟을 기준으로 나에게 가장 가까운 태그를 찾기
		let div = e.target.closest('div');
		console.log(div);
		let cmtText = div.querySelector(".cmtText").value;
		
		let cmtData={
			cno : cno,
			content : cmtText
		}
		console.log(cmtData);
		
		// update 요청
		updateCommentToServer(cmtData).then(result =>{
			console.log(result);
			printCommentList(bnoValue);
		})
	}
	
	// 삭제 버튼일 경우
	if(e.target.classList.contains('del')){
		removeCommentToServer(cno).then(result =>{
			console.log(result);
			printCommentList(bnoValue);
		})
	}
})