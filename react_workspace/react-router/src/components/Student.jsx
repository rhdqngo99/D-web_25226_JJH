import React from 'react';

const Student = ({std}) => {

    //구조분해
    const {name, age, adder, phone} = std
    return (
        <div className='student'>
            <h3> {name}({age}) : {phone} </h3>
        </div>
    );
};

export default Student;