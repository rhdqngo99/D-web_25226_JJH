import React, { useRef, useState } from 'react';

// input의 값이 여러개 일 경우
const InputSample2 = () => {
    const [inputs, setInputs] = useState({
        // 여기서 사용할 이름 생성
        name:'',
        nick :''
    });

    const {name, nick} = inputs;

    const onChange = (e)=>{
        console.log(e.target.name); // name 속성은 변수명으로 사용 / value = 값
        const {name, value} = e.target; //e.targer의 name과  value 속성을 추출
        setInputs({
            // 기존값 복사
            ...inputs, 
            [name] : value // name 키를 가진 value 값을 저장
        })
    }

    const onClick = ()=>{
        setInputs({
            name:'',
            nick:''
        })
        // name input 창을 선택
        // useRef() 대상에 대한 할일을 설정
        nameInput.current.focus();
    }

    // document.getElementBy** 같은 역할을 하는 HOOK
    // useRef() : 특정 DOM을 선택할 때 사용
    const nameInput = useRef();

    return (
        <div>
            <input 
                type="text" 
                onChange={onChange} 
                value={name} 
                name='name' 
                placeholder='이름' 
                autoFocus 
                // useRef() 설정
                ref={nameInput}/>
            <input 
                type="text" 
                onChange={onChange} 
                value={nick} 
                name='nick' 
                placeholder='닉네임'/>
            {/* 초기화 버튼을 누르면 input value가 초기화되고, name에 포커스를 맞추기 */}
            <button onClick={onClick}>초기화</button>
            <div>
                <b>값 : {name}({nick})</b>
            </div>
        </div>
    );
};

export default InputSample2;