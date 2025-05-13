import React, { useState } from "react";

//HOOK : class를 별도로 작성하지 않고도 상태를 관리할 수 있는 기능들을 가지고 있음.
// useState() : 변수의 상태를 관리하는 훅(HOOK) 
// 변경되는 변수를 관리하기 위해서는 변수명, set변수명을 같이 관리

const Count = () => {
    //useState(init); [변수, set변수]
    // const numberState = useState(0);
    // const number = numberState[0];
    // const setNumber = numberState[1];
    
    const [number, setNumber] = useState(0);

    const onIncrease = ()=>{
        // console.log('111');
        // setNumber(number + 1);
        // 함수형업데이트 : 컴포넌트에 최적화를 할 때 사용
        if(number >= 10){
            setNumber(10);
        }else{
            setNumber(pre => pre +1);
        }
    }
    const onDecrease = ()=> {
        console.log('222');
        // setNumber(number - 1);
        // 함수형업데이트 : 컴포넌트에 최적화를 할 때 사용
        setNumber(pre => pre -1);
    }

    return(
        <div className='count'>
            <h1>{number}</h1>
            {/* on이벤트명 = {실행하고 싶은 함수} */}
            {/* 실행하고 싶은 함수는 함수 자체를 넣어줘야 함. () 실행하면 안됨. */}
            <button onClick={onIncrease}>+</button>
            <button onClick={onDecrease}>-</button>
        </div>
    );
};

export default Count;