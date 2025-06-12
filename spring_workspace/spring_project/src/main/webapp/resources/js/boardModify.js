console.log("boardModify.js in");
/*
    file-x 버튼을 클릭하면 해당 그림을 삭제
    1. 해당 파일의 uuid를 추출 -> file primary key -> file-x 버튼에 dataset uuid
    2. 컨트롤러로 비동기 전송 => DB에서 삭제
    3. DB 삭제 후 해당 li 라인을 삭제 remove()
*/

const csrfToken= document.querySelector('meta[name="_csrf"]').getAttribute('content');
const csrfHeader= document.querySelector('meta[name="_csrf_header"]').getAttribute('content');

document.addEventListener('click',(e)=>{
    if(e.target.classList.contains("file-x")){
        let uuid = e.target.dataset.uuid;
        removeFileToServer(uuid).then(result =>{
            if(result == '1'){
                e.target.closest('li').remove();
            }
        })
    }
});

async function removeFileToServer(uuid) {
    try {
        const url = "/board/file/"+uuid;
        const config={
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