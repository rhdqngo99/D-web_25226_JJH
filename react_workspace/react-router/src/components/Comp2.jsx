import React, { useState } from 'react';

const Comp2 = () => {

    const [count, setCount] = useState(0);

    const onIncre = ()=>{
        setCount(
            number => number < 10 ? number+1 : 10
        );
    }
    const onDecre = ()=>{
        setCount(
            number => number > 0 ? number-1 : 0
        );
    }
    const [text, setText] = useState('');
    // const onChange = (e)=>{
    //      setTest(e.target.value);    
    // }
    
    const [color, setColor] = useState('');

    return (
        <div className='comp comp2'>
            <h2>Comp2.jsx area</h2>
            {/* count */}
            <h2>{count}</h2>
            <button onClick={onIncre}>+</button>
            <button onClick={onDecre}>-</button>
            <hr />

            {/* input */}
            {/* <input type="text" name='text' value={text} onChange={onChange} /> */}
            <input 
                type="text" 
                name='text' 
                value={text} 
                onChange={(e)=>{setText(e.target.value)}} />
            <h3>input text : {text} </h3>

            <br />
            <hr />
            <br />

            <h2 style={{color:'wheat', backgroundColor:color}}>BackgroundColor Change Example</h2>
            <input type="color" onChange={(e)=>{setColor(e.target.value)}} />
        </div>
    );
};

export default Comp2;