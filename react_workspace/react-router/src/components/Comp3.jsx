import React, { useState } from 'react';
import { Link } from 'react-router-dom';
import { students } from '../data/data';
import Student from './Student';

const Comp3 = () => {
    // 다른 컴포넌트로 이동 / 데이터를 전달하는 작업
    // 데이터를 전달하는 방법 2가지
    // 1. path variable : /comp1/1
    // 2. queryString : /comp1?id=1&page=2
    
    //Param.jsx /param

    const ids = 10;
    const [id, setId] = useState('');
    const [pw, setPw] = useState('');

    return (
        <div className='comp comp3'>
            <h2>Comp3.jsx area</h2>
            {/* path variable 방법으로 Param.jsx에 값을 전달 */}
            <Link to={{pathname:`/param/${ids}`}}>path variable</Link>
            
            <br /><br /><hr />
            {
                students.map(s => (
                    <Link to={{pathname:`/param/${s.name}`}}><Student std={s} /></Link>
                ))
            }

            <br /><br /><hr />
            <Link to={"/param?num=5&page=3&id=11&pw=123"}>params</Link>

            <br /><br /><hr />
            <Link to={{
                    pathname:'/param',
                    search:'?num=100&page=30'
            }}>queryString params</Link>

            <br /><br /><hr />
            {/* useState를 이용 / input 태그로 id, pw를 입력받고 전송 버튼을 클릭하면 */}
            {/* Param2 에 id/pw 출력 */}
            <input type="text" name='id' value={id} onChange={(e)=>{setId(e.target.value)}} />
            <input type="text" name='id' value={pw} onChange={(e)=>{setPw(e.target.value)}} />
            <Link to={{
                pathname:'/param',
                search:`?id=${id}&pw=${pw}`
            }}><button>전송</button></Link>
            
        </div>
    );
};

export default Comp3;