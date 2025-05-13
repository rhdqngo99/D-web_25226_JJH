import React, { useEffect, useState } from 'react';
import axios from 'axios';

const User = () => {
    // 'https://jsonplaceholder.typicode.com/users/' 경로에서 데이터를 가져오기
    // 비동기로 가져오기 async ()
    // useEffect() : 컴포넌트가 마운트 됐을 때(처음 나타날 때), 언마운트 됐을 때(사라질 때)
    // 업데이트 될 때(특징 props가 변결될 때)
    const [users, setUsers] = useState(null);
    const [loading, setLoading] = useState(false);
    const [error, setError] = useState(null);

    const fetchUser = async ()=>{
        try{
            // 요청이 시작되기 전 error, users, loading 값 세팅
            setError(null);
            setUsers(null);
            setLoading(true);

            // 데이터 가져오기
            const response = await axios.get('https://jsonplaceholder.typicode.com/users/');
            console.log(response);
            setUsers(response.data);
        } catch (error){
            setError(error);
        }
        // 로딩이 끝나고 난다음 설정 변경
        setLoading(false);
    }

    useEffect(()=>{
        fetchUser(); // 처음 마운트 될 때 함수 호출
    },[]); //deps의 배열을 비우게 되면, 처음 나타날 때 함수를 호출.

    if(loading) return <div>loading...</div>
    if(error) return <div>error...</div>
    if(!users) return <div>null</div>

    return (
        <div className='user'>
            <ul>
                {
                    users.map(user =>(
                        <li key={user.id}>{user.username}({user.name}) / {user.email} </li>
                    ))
                }
            </ul>
            <button onClick={fetchUser}>불러오기</button>
        </div>
    );
};

export default User;