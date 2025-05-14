import React, { useEffect, useReducer } from 'react';
import axios from 'axios';

function reducer(state, action){
    // LOADING, SUCCESS, ERROR
    switch(action.type){
        case 'LOADING':
            return {
                loading:true,
                data:null,
                error:null
            };
        case 'SUCCESS':
            return {
                loading:false,
                data:action.data,
                error:null
            };
        case 'ERROR':
            return {
                loading:false,
                data:null,
                error:action.error
            };
        default:
            throw new Error(`Unhandled action type : ${action.type}`);
            
    }
}

const Users = () => {
    // react-api => User.jsx를 useReducer로 변경
    const [state, dispatch] = useReducer(reducer, {
        loading:false,
        data:null,
        error:null
    });

    const fetchUsers = async ()=>{
        try {
            // 요청이 시작할 때 LOADING 액션을 호출
            dispatch({type:'LOADING'});
            
            // 데이터 가져오기
            const response = await axios.get('https://jsonplaceholder.typicode.com/users');
            dispatch({type:'SUCCESS', data:response.data});

        } catch (e) {
            //error 
            dispatch({type:'ERROR', error:e})
            
        }
    }

    useEffect(()=>{
        fetchUsers();
    },[]);

    //data:users state.data 를 users의 키워드로 조회
    const {loading, data:users, error} = state; 

    if(loading) return <div>loading...</div>
    if(error) return <div>error...</div>
    if(!users) return <div>null</div>

    return (
        <div className='users'>
            <ul>
                {
                    users.map(user => (
                        <li key={user.id} >
                            {user.username}({user.name}) / {user.email}
                        </li>
                    ))
                }
            </ul>
            <button onClick={fetchUsers}>불러오기</button>
        </div>
    );
};

export default Users;