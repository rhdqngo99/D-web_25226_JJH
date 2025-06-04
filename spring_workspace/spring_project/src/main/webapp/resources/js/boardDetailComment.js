console.log("boardDetailComment.js in");
console.log(bnoValue);

document.getElementById('cmtAddBtn').addEventListener('click',()=>{
    const cmtText = document.getElementById('cmtText'); //input
    const cmtWriter = document.getElementById('cmtWriter'); // span
    console.log(cmtText.value);

    if(cmtText.value==''){
        alert('댓글을 입력해주세요');
        cmtText.focus();
        return;
    }

    let cmtData = {
        bno: bnoValue,
        writer : cmtWriter.innerText,
        content : cmtText.value
    }

    console.log(cmtData);
    postCommentToServer(cmtData).then(result =>{
        if(result == '1'){
            alert("댓글 등록 성공");
            cmtText.value = "";
            // 댓글 출력
            spreadCommentList(cmtData.bno);
        }
    })
})

function spreadCommentList(bno, page=1){
    getCommentListFromServer(bno, page).then(result =>{
        console.log(result); // ph.cmtList
        // result 출력
        const ul = document.getElementById('cmtListArea');
        if(result.cmtList.length > 0){
            // 댓글이 있을경우
            if(page == 1){
                ul.innerHTML = '';
            }
            for(let cvo of result.cmtList){
                let li = `<li class="list-group-item" data-cno="${cvo.cno}">`;
                    li += `<div class="mb-3">`;
                    li += `<div class="fw-bold">${cvo.writer}</div>`;
                    li += `${cvo.content}`;
                    li += `</div>`;
                    li += `<span class="badge text-bg-primary">${cvo.regDate}</span>`;
                    li += `<button type="button" class="btn btn-outline-warning mod" data-bs-toggle="modal" data-bs-target="#myModal">%</button>`;
                    li += `<button type="button" class="btn btn-outline-warning del">X</button>`;
                    li += `</li>`;
                ul.innerHTML += li;
            }
            // 더보기 버튼을 숨김여부 체크
            let moreBtn = document.getElementById('moreBtn');
            // 더보기 버튼이 표시되는 조건
            // ph => pgvo.pageNo < readEndPage > pageNo => 더보기 버튼 표시
            // 현재 페이지가 전체 페이지보다 작으면 표시
            if(result.pgvo.pageNo < result.realEndPage){
                // style.visivility = "hidden" : 숨김 "visible" :표시
                moreBtn.style.visibility = "visible";  // 버튼표시
                // 페이지 1증가 후 다시 data-page로 달기
                moreBtn.dataset.page = page + 1;
            }else{
                // 현재 페이지가 전체 페이지보다 작지 않다면, 크다면...
                moreBtn.style.visibility = "hidden" ; // 숨김
            }

        }else{
            // 댓글이 없을경우
            ul.innerHTML= `<li class="list-group-item">Comment List Empty</li>`;
        }
    })
}

document.addEventListener('click',(e)=>{
    //내가 선택한 객체 인지 => e.target
    // moreBtn 을 선택했을 때...
    if(e.target.id==='moreBtn'){
        let page = parseInt(e.target.dataset.page); // 문자로 인지. => 숫자로인지
        spreadCommentList(bnoValue, page);
    }
    
    // 수정일경우
    
    // 삭제일경우
    if(e.target.classList.contains('del')){
        // 삭제 버튼이 선택된 경우
        // cno만 있으면 됨.
        let li = e.target.closest('li'); // 내 버튼이 속해있는 li 찾기
        let cno = li.dataset.cno;
        
        // 비동기로 cno 보내서 DB상에서 삭제 isOk 리턴
        removeCommentToServer(cno).then(result =>{
            if(result == '1'){
                console.log("댓글 삭제 성공")
            }else{
                console.log("댓글 삭제 실패")
            }
            // 댓글 출력
            spreadCommentList(bnoValue);
        })
    }
    
})

//delete
async function removeCommentToServer(cno) {
    try {
        const url = `/comment/${cno}`;
        const config = {
            method:'delete'
        }
        const resp = await fetch(url, config);
        const result = await resp.text(); // isOk
        return result;
    } catch (error) {
        console.log(error);
    }
}

//get 
async function getCommentListFromServer(bno, page) {
    try {
        const resp = await fetch(`/comment/${bno}/${page}`);  // path 로 변수 달고 가기 /cmt?bno=bnoValue
        const result = await resp.json(); // List<CommentVO> 리턴
        return result;
    } catch (error) {
        console.log(error);
        
    }
}

// post
async function postCommentToServer(cmtData) {
    try{
        const url ="/comment/post";
        const config={
            method : "post",
            headers: {
                'Content-Type' : 'application/json; charset=utf-8'
            },
            body: JSON.stringify(cmtData)
        };
        const resp = await fetch(url, config);
        const result = await resp.text(); //isOk
        return result; 
    } catch (error) {
        console.log(error);
    }
}