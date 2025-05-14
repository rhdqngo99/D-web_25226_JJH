import React, { useEffect, useState } from 'react';
import axios from 'axios';
import UserOne from './UserOne';

const User = () => {
    // 'https://jsonplaceholder.typicode.com/users' 경로에서 데이터를 가져오기
    // 비동기로 가져오기  async ()
    // useEffect() : 컴포넌트가 마운트 됐을 때(처음 나타날 때), 언마운트 됐을 때(사라질 때)
    // 업데이트 될 때(특정 props가 변경될 때) 
    const [users, setUsers] = useState(null);
    const [loading, setLoading] = useState(false);
    const [error, setError] = useState(null);

    // id를 저장할 변수 : 내가 선택한 유저
    const [selectedId, setSelectedId] = useState(null);

    const fetchUser = async ()=>{
        try {
            // 요청이 시작되기 전 error, users, loading 값 셋팅
            setError(null);
            setUsers(null);
            setLoading(true);

            // 데이터 가져오기
            const response = await axios.get('https://jsonplaceholder.typicode.com/users');
            console.log(response);
            setUsers(response.data); //response.data 에 값이 들어있음.

        } catch (error) {
            setError(error);
        }
        // 로딩이 끝나고 난다음 설정 변경
        setLoading(false);
    }

    useEffect(()=>{
        fetchUser();  // 처음 마운트 될 때 함수 호출
    },[]); //deps의 배열을 비우게 되면, 처음 나타날 때 함수를 호출. 

    if(loading) return <div>loading...</div>
    if(error) return <div>error...</div>
    if(!users) return <div>null</div>
    
    // 선택한 유저가 있다면...
    // if(selectedId !== null) {
    //     return <UserOne id={selectedId} />
    // }
    

    return (
        <div className='user'>
            <ul>
                {
                    users.map(user => (
                        <li 
                            key={user.id}
                            //추가되는 부분
                            onClick={()=>setSelectedId(user.id)}
                            style={{
                                cursor:'pointer',
                                backgroundColor: selectedId === user.id ? 'lightblue' : 'transparent'
                            }}
                        >
                                {user.username}({user.name}) / {user.email}
                        </li>
                    ))
                }
            </ul>
            <button onClick={fetchUser}>불러오기</button>
            {/* 조건부 랜더링 &&  */}
            {/* 조건 && (...) : 조건이 null이거나, false가 아니라면 괄호안의 값이 랜더링 */}
            {
                selectedId && (
                    <div>
                        <hr />
                        <UserOne id={selectedId} />
                        <button onClick={()=>setSelectedId(null)}>닫기</button>
                    </div>
                )
            }

        </div>
    );
};

export default User;