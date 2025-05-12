import React, { useState } from "react";

const InputSample = () => {
    // input의 value 값을 useState로 관리
    const [text, setText] = useState(''); // 문자 초기값 공백

    const onChange = (e) =>{
        console.log(e.target.value);
        setText(e.target.value);
    }
    const onClick = () => {
        setText('');
    }

    return(
        <div className='inputSample'>
            {/* input의 상태를 관리할 때에는 input 태그의 value값을 설정해주는 것이 중요 */}
            {/* 상태가 변경되었을 때 input 내용이 업데이트되어야 함. => useState() */}
            <input type="text" onChange={onChange} name='text' value={text} />
            <button onClick={onClick}>초기화</button>
            <div>
                <b>값 : {text} </b>
            </div>
        </div>
    );
};

export default InputSample;