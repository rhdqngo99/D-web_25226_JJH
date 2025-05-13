import React, { useRef, useState } from 'react';
import UserList1 from './UserList1';
import CreateUser from './CreateUser';

const UserList2 = () => {

    // users의 변화를 주기 위해 (등록, 삭제, 수정) useState()로 관리
    const [users, setUsers] = useState(
        [
            {
                id:1,
                username:'hong',
                email:'publicHong@gmail.com',
                active: true
            },
            {
                id:2,
                username:'kim',
                email:'kimTester@gmail.com',
                active: false
            },
            {
                id:3,
                username:'lee',
                email:'publicLee@gmail.com',
                active: false
            },
        ]
    );

    const nextId = useRef(4); // 추가할 때 사용될 id 값 설정

    // CreateUser 값을 관리.
    const [inputs, setInputs] = useState(
        {
            username : '',
            email:''
        }
    );

    const {username, email} = inputs; // 구조분해

    //onChange() 설정
    const onChange = (e)=>{
        const {name, value} = e.target; //target의 속성 name="" / value=""
        setInputs({
            ...inputs,  //기존 input 복사
            [name]:value
        });
    }
    console.log(inputs)

    //onCreate() 설정
    const onCreate = ()=>{
        //onChange() 실행 후 input 값이 생기면 배열에 추가
        const user = {
            id:nextId.current,  // 객체의 현재값
            username:username, // 값이 같으면 생략가능 username
            email:email,
            active:false
        }
        //push / pop는 안씀 : 원본데이터가 변경되는 값은 쓰지않음. 
        setUsers([...users, user]);
        // setUsers([...users].concat(user)) : 성능개선 시 편함.

        // nextId 값을 1증가
        nextId.current += 1; // 현재 값의 1증가 값으로 설정

        // 추가 후 inputs 객체 초기화
        setInputs({
            username:'',
            email:''
        })
    }

    // onRemove() 설정
    const onRemove = (id)=>{
        // 파라미터의 값으로 가져온 id 값 (User에서 user.id로 가져온 값)
        console.log(id);
        // users id 값이 id와 일치하지 않는 원소만 추출하여 새로운 배열을 만들어 사용
        setUsers(users.filter(user => user.id !== id));
    }

    //onToggle 설정
    const onToggle = (id)=>{
        // 현재 클릭한 유저의 active 를 자신의 값과 반대로 설정
        setUsers(
            users.map(user => user.id === id ? 
                {...user, active: !user.active} : user)
        )
    }

    // 활성 사용자수 설정
    const countActiveUser = ()=>{
        return users.filter(user => user.active).length;
    }

    const count = countActiveUser();

    return (
        <div>
            <CreateUser 
                username = {username}
                email = {email}
                onChange={onChange} 
                onCreate={onCreate}/>
            <UserList1 users={users} onRemove={onRemove} onToggle={onToggle}/>
            {/* 활성사용자(초록색)의 인원수 */}
            <div>활성 사용자수 : {count} 명</div>
        </div>
    );
};

export default UserList2;