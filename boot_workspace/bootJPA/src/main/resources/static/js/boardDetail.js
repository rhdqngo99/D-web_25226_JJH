console.log("boardDetail.js in");
console.log(bnoValue);

// listBtn을 클릭하면 /board/list로 이동
document.getElementById('listBtn').addEventListener('click',()=>{
    location.href = "/board/list"
});

// delBtn을 클릭하면 /board/remove로 이동 (bno를 가지고 가야함.)
document.getElementById('delBtn').addEventListener('click',()=>{
    location.href="/board/remove?bno="+bnoValue;
});

// modBtn을 클릭하면 title, content만 readOlny를 풀기
document.getElementById('modBtn').addEventListener('click',()=>{
    document.getElementById('t').readOnly = false;
    document.getElementById('c').readOnly = false;

    // 실제 submit 기능을 하는 버튼 생성
    let modBtn = document.createElement("button"); // <button></button>
    modBtn.setAttribute('type', 'submit'); // <button type="submit"></button>
    modBtn.setAttribute('id', 'regBtn');  // <button type="submit" id="regBtn"></button>
    // <button type="submit" id="regBtn" class="btn btn-warning">Submit</button>
    modBtn.classList.add('btn', 'btn-warning');
    modBtn.innerText = "Submit";

    // Form 태그의 가장 마지막 요소로 추가
    document.getElementById('modForm').appendChild(modBtn);
    document.getElementById('modBtn').remove(); // 버튼 객체를 삭제
    document.getElementById('delBtn').remove();

    //file 업로드 버튼 비활성화 해지
    document.getElementById('trigger').disabled = false;

    //file-x (class) 버튼을 보이게 설정 : style="visibility: hidden => visible로 변환"
    let fileDelBtn = document.querySelectorAll(".file-x");
    console.log(fileDelBtn);
    fileDelBtn.forEach(btn =>{
        btn.style.visibility = "visible";
        // file-x 버튼을 클릭하면 비동기로 uuid를 보내서 DB상에서 파일 삭제
        btn.addEventListener('click',(e)=>{
            let uuid = btn.dataset.uuid;
            // 비동기 전송
            fileRemoveToServer(uuid).then(result =>{
                if(result == "1"){
                    alert("파일삭제 성공");
                    e.target.closest('li').remove();
                }
            })
        })
    });
});

async function fileRemoveToServer(uuid) {
    try {
        const url = `/board/file/${uuid}`;
        const config = {
            method: 'delete'
        }
        const resp = await fetch(url, config);
        const result = await resp.text();
        return result;
    } catch (error) {
        console.log(error);
    }
}