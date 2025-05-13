import React from 'react';
import { student, students  } from '../data/data';
import Student from './Student';

const Comp1 = () => {
    return (
        <div className='comp comp1'>
            <h2>Comp1.jsx area</h2>

            {/* Student.jsx 컴포넌트 생성 */}
            {/* student 객체를 Student.jsx 컴포넌트로 출력 */}

            <Student std={student} />

            {/* students 객체를 Student.jsx 컴포넌트로 출력 */}
            {
                students.map(s=> <Student std={s}/>)
            }
        </div>
    );
};

export default Comp1;