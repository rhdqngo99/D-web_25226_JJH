console.log("boardRegister.js in");

document.getElementById('trigger').addEventListener('click',()=>{
    document.getElementById('file').click();
});

// 실행파일 막기, 10MB 이상 파일 사이즈 제한
const regExp = new RegExp("\.(exe|sh|bat|jar|dll|msi)$"); // 실행파일 막기
const maxSize = 1024*1024*10;

function fileValid(fileName, fileSize){
    if (regExp.test(fileName)){
        return 0;
    } else if (fileSize > maxSize){
        return 0;
    }else {
        return 1;
    }
};

document.addEventListener('change',(e)=>{
    if(e.target.id == 'file'){
        // multiple : 파일 객체가 배열로 들어옴
        const fileObject = document.getElementById('file').files;
        console.log(fileObject);

        // 등록버튼 비활성화 풀기
        document.getElementById('regBtn').disabled = false;

        const div = document.getElementById('fileZone');
        // 이전 잘못된 파일들 제거
        div.innerHTML = "";

        let ul = `<ul class="list-group list-group-flush">`;
        let isOk = 1; // 모든 첨부파일에 대해 통과하는지 체크 *= 누적
        for(let file of fileObject){
            let vaild = fileValid(file.name, file.size);
            isOk *= vaild;
            ul+= `<li class="list-group-item">`;
            ul+= `<div class="mb-3">`;
            ul+= `${vaild ? '<div class="fw-bold">업로드 가능</div>' : '<div class="fw-bold text-danger">업로드 불가능</div>'}`;
            ul+= `${file.name}`;
            ul+= `<span class="badge rounded-pill text-bg-${vaild? 'success':'danger'}">${file.size}Bytes</span>`;
            ul+= `</div>`;
            ul += `</li>`;
        }
        ul += `</ul>`;
        fileZone.innerHTML = ul;

        if(isOk == 0 ){
            document.getElementById('regBtn').disabled = true;
        }
    }
})