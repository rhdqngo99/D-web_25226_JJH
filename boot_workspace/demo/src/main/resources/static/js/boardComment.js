console.log("Comment js in");
console.log(bnoValue);
console.log(userEmail);

document.getElementById('cmtAddBtn').addEventListener('click',()=>{
    const cmtText = document.getElementById('cmtText');
    const cmtWriter = document.getElementById('cmtWriter');

    if(cmtText == "" || cmtText == null){
        alert('댓글입력');
        cmtText.focus();
        return false;
    }
    const cmtData = {
        bno : bnoValue,
        content : cmtText.value,
        writer : cmtWriter.innerText
    }

    postCommentToServer(cmtData).then(result =>{
        if(result === "1"){
            alert("댓글등록성공");
            cmtText.value="";
        }
        // 댓글 호출
    })
});

async function postCommentToServer(cmtData) {
    try {
        const url = "/comment/post";
        const config={
            method:'post',
            headers : {
                'content-type' : 'application/json; charset=utf-8'
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