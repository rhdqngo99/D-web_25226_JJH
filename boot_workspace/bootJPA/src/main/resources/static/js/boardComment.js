console.log("boardComment js in");

let cmtWriter = document.querySelectorAll(".cmtWriter");
console.log(cmtWriter[0].innerText);

const csrfToken = document.querySelector('meta[name="_csrf"]').getAttribute('content');
const csrfHeader = document.querySelector('meta[name="_csrf_header"]').getAttribute('content');
console.log(csrfToken);

document.getElementById('cmtAddBtn').addEventListener('click',()=>{
    const cmtText = document.getElementById('cmtText');
    const cmtWriter = document.getElementById('cmtWriter');

    if(cmtText == null || cmtText.value == ''){
        alert("댓글입력요망!");
        cmtText.focus();
        return false;
    }
    let cmtData = {
        bno : bnoValue,
        writer : cmtWriter.innerText,
        content : cmtText.value
    }
    //전송
    postCommentToServer(cmtData).then(result =>{
        if(result == "1"){
            alert("댓글 등록 성공!!");
            cmtText.value="";
            cmtText.focus();
        }
        // 댓글 출력 호출
        spreadCommentList(cmtData.bno);
    })
});

// 화면에 출력 함수
function spreadCommentList(bno, page=1){
    commentListFromServer(bno, page).then(result =>{
        console.log(result);
        const ul = document.getElementById('cmtListArea');
        if(result.list.length > 0){
            if(page == 1){
                ul.innerHTML=""; // 기존 샘플값 비우기.
            }
            for(let cvo of result.list){
                let li = `<li data-cno="${cvo.cno}" class="list-group-item">`;
                li +=`<div class="ms-2 me-auto">`;
                li +=`<div class="fw-bold">${cvo.writer}</div>`;
                li +=`${cvo.content}`;
                li +=`</div>`;
                li +=`<span class="badge bg-dark rounded-pill">${cvo.regDate}</span>`;
                if(cmtWriter[0].innerText !== "로그인을 해주세요." && userEmail === cvo.writer){
                    li +=`<button type="button" class="btn btn-outline-warning mod" data-bs-toggle="modal" data-bs-target="#myModal">e</button>`;
                    li +=`<button type="button" class="btn btn-outline-danger del">x</button>`;
                }
                li +=`</li>`;
                ul.innerHTML += li;
            }

            //page 처리
            let moreBtn = document.getElementById('moreBtn');
            // 전체 페이지가 현재 페이지보다 크다면...  (나와야 할 페이지가 존재한다면...)
            if(result.pageNo < result.totalPage){
                moreBtn.style.visibility = "visible"; // 표시
                moreBtn.dataset.page = page + 1;
            }else{
                moreBtn.style.visibility = "hidden"; // 숨김
            }

        }else{
            let li = `<li class="list-group-item">Comment List Empty</li>`;
            ul.innerHTML = li;
        }
    })
}

document.addEventListener('click',(e)=>{
    if(e.target.id == 'moreBtn'){
        spreadCommentList(bnoValue, parseInt(e.target.dataset.page));
    }

    let li = e.target.closest('li');

    if(e.target.classList.contains('mod')){
        //수정 : 수정할 데이터(content)를 찾아서 => modal 창에 띄우기
        // nextSibling : 같은 부모의 다음 형제 찾기
        let cmtText = li.querySelector('.fw-bold').nextSibling;
        let cmtWriter = li.querySelector('.fw-bold').innerText;
        console.log(cmtText);

        // 객체의 값을 스트링 형태로 선택된 것이 아님. => nodeValue
        document.getElementById('cmtTextMod').value = cmtText.nodeValue;
        document.getElementById('cmtWriterMod').innerText = cmtWriter;
        // cmtModBtn (수정버튼)에 data-cno 값을 속성으로 추가
        document.getElementById('cmtModBtn').setAttribute('data-cno', li.dataset.cno);
    }
    if(e.target.id == 'cmtModBtn'){
        // 모달 수정 버튼
        let cmtModData = {
            cno : e.target.dataset.cno,
            content : document.getElementById('cmtTextMod').value
        }

        //비동기로 수정 보내기
        modifyCommentToServer(cmtModData).then(result =>{
            if(result == "1"){
                alert('댓글 수정 성공!!');
            }
            // 모달창 닫기
            document.querySelector('.btn-close').click();
            spreadCommentList(bnoValue);
        })

    }
    if(e.target.classList.contains('del')){
        //삭제
        removeCommentToServer(li.dataset.cno).then(result =>{
            if(result == "1"){
                alert('댓글 삭제 성공!!');
            }
            spreadCommentList(bnoValue);
        })
    }
})

// -비동기 데이터 함수-----------
//수정
async function modifyCommentToServer(cmtModData) {
    try {
        const url = `/comment/modify`;
        const config = {
            method : 'put',
            headers:{
                'content-type' : 'application/json; charset=utf-8',
                [csrfHeader] : csrfToken
            },
            body : JSON.stringify(cmtModData)
        }
        const resp = await fetch(url, config);
        const result = await resp.text();
        return result;
    } catch (error) {
        console.log(error);
    }
}

// 삭제
async function removeCommentToServer(cno) {
    try {
        const url = `/comment/remove/${cno}`;
        const config = {
            method:'delete',
            headers : {
                [csrfHeader] : csrfToken
            }
        }
        const resp = await fetch(url, config);
        const result = await resp.text();
        return result;
    } catch (error) {
        console.log(error);
    }
}
async function postCommentToServer(cmtData) {
    try {
        const url = "/comment/post";
        const config={
            method : 'post',
            headers:{
                'content-type':'application/json; charset=utf-8',
                [csrfHeader] : csrfToken
            },
            body: JSON.stringify(cmtData)
        };
        const resp = await fetch(url, config);
        const result = await resp.text();
        return result;
    } catch (error) {
        console.log(error);
    }
}

// list
async function commentListFromServer(bno, page) {
    try {
        const resp = await fetch(`/comment/list/${bno}/${page}`);
        const result = await resp.json();
        return result;
    } catch (error) {
        console.log(error);
    }
}