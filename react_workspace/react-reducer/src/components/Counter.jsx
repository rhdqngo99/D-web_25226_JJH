import React, { useReducer, useState } from 'react';

function reducer(state, action){
    switch(action.type){
        case 'INCREMENT':
            return state + 1;
        case 'DECREMENT':
            return state - 1;
        default:
            return state;
    }

}

const Counter = () => {
    // const [number, setNumber] = useState(0);
    const [number, dispatch] = useReducer(reducer, 0);

    const onIncre = ()=>{
        // setNumber(n => n+1);
        dispatch({type: 'INCREMENT'});
    }
    const onDecre = ()=>{
        // setNumber(n=> n-1);
        dispatch({type: 'DECREMENT'});
    }
    return (
        <div className='counter'>
            <h1>{number}</h1>
            <button onClick={onIncre}>+</button>
            <button onClick={onDecre}>-</button>
        </div>
    );
};

export default Counter;