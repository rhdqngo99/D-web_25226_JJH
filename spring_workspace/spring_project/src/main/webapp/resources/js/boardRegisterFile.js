console.log("boardRegisterFile.js in");

// file button trigger 
document.getElementById('trigger').addEventListener('click', ()=>{
    document.getElementById('file').click();
});

// 파일에 대한 정규표현식 작성
// 1. 실행파일 업로드 금지  2. 20MB 파일 사이즈 이상은 금지
const regExp = new RegExp("\.(exe|jar|msi|dll|sh|bat)$");
const maxSize = 1024*1024*20; 

function fileValidation(fileName, fileSize){
    if(regExp.test(fileName)){
        return 0;
    }else if(fileSize > maxSize){
        return 0;
    }else{
        return 1;
    }
}

document.addEventListener('change', (e)=>{
    if(e.target.id == 'file'){  // input file에 변화가 생겼다면....
        // type="file" element에 저장된 file 정보를 가져오는 property => files
        const fileObj = document.getElementById('file').files;
        console.log(fileObj);

        // 내가 등록한 파일의 목록을 fileZone 영역에 추가 => valid 해서 정보를 같이 표시
        const div = document.getElementById('fileZone');
        div.innerHTML=""; // 만약 새로 추가되는 목록이 있다면 삭제하고 재처리
        // 한번 disabled 되면 혼자 false가 될수 없음. (버튼 원상복구)
        document.getElementById('regBtn').disabled = false;

        let isOk =1; // vaild 검증을 통과했는지의 여부
        // 파일이 여러가 입력 가능 => 모두다 vaild를 통과해야 등록가능 
        // 모든 결과가 1이여야 register 버튼을 활성화 => 누적곱을 통해 검증
        let ul = `<ul class="list-group list-group-flush">`;
            // 개별 파일에 대한 검증 / 결과표시
            for(let file of fileObj){
                let vaildResult = fileValidation(file.name, file.size); // 개별결과
                isOk *= vaildResult; // 전체 누적
                ul += `<li class="list-group-item">`;
                ul += `<div class="mb-3">`;
                ul += `${vaildResult ? '<div class="fw-bold text-success">업로드 가능</div>' : '<div class="fw-bold text-danger">업로드 불가능</div>'}`;
                ul += `${file.name} </div>`;
                ul += `<span class="badge text-bg-${vaildResult ? 'success' : 'danger'}">${file.size} Bytes</span>`;
                ul += `</li>`;
            }
            ul+= `</ul>`

            div.innerHTML = ul;
            if(isOk == 0){
                // 하나라도 검증을 통과하지 못한 파일이 있다면 regBtn 비활성화
                document.getElementById('regBtn').disabled = true;
            }
    }
})