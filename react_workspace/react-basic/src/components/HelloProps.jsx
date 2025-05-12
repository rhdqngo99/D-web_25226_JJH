import React from "react";

//props : prosperties의 약자
// 컴포넌트에서 전달할 값을 있을 경우 props를 사용
// props 객체로 전달 받음

// function helloProps(props){
//     // porps로 name 변수를 받아올 예정
//     //<></> react 태그가 <div></div>면 안될경우
//     return (
//         <div className="helloProps">
//             <div style={{color:props.color}}>Hello.jsx area props = {props.name}</div>
//         </div>
//     );
// };

// 구조분해 : 배열이나 객체의 속성을 해체하여 그 값을 개별 변수에 담는 javascipt 표현식
// props => name, color
function HelloProps({name, color}){
    // porps로 name 변수를 받아올 예정
    //<></> react 태그가 <div></div>면 안될경우 사용
    return (
        <div className="helloProps">
            <div style={{color:color}}>Hello.jsx area props = {name}</div>
        </div>
    );
};

export default HelloProps;