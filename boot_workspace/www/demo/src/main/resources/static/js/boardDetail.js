console.log("boardDetail.js in");
document.getElementById('modBtn').addEventListener('click',()=>{
    
    //title, content의 readonly를 해지  readOnly = true / false
    document.getElementById('t').readOnly = false;
    document.getElementById('c').readOnly = false;

    // modBtn, delBtn 버튼 삭제
    document.getElementById('modBtn').remove();
    document.getElementById('delBtn').remove();

    //update 버튼을 regBtn 이름으로 type="submit"인 버튼 추가
    // <button type="submit" id="regBtn" class="btn btn-warning">update</button>
    let regBtn = document.createElement('button');  //<button></button>
    // button 속성 추가
    regBtn.setAttribute('type','submit');
    regBtn.setAttribute('id','regBtn');
    regBtn.classList.add('btn','btn-warning');
    regBtn.innerHTML='update';
    // form 태그의 마지막 자식으로 추가 - form 태그의 가장 마지막에 추가
    document.getElementById('modForm').appendChild(regBtn);
});