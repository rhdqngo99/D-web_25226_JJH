import React from 'react';

// function User(){
// 이렇게 생성해도 됨.
// }

const User = ({user})=>{
    return(
        <div>
            {user.id}. <b>{user.username}</b> <span>({user.email})</span>
        </div>
    )
}

const UserList = () =>{

    const users =[
        {
            id:1,
            username:'hong',
            email:'publicHong@gmail.com'
        },
        {
            id:2,
            username:'kim',
            email:'kimTester@gmail.com'
        },
        {
            id:3,
            username:'lee',
            email:'publicLee@gmail.com'
        },
    ];

    return(
        <div>
            {/* 값이 객체 하나라면 user.id, user.username, user.email */}
            {/* <h2>{users[0].id} / {users[0].username} / {users[0].email}</h2>
            <h2>{users[1].id} / {users[1].username} / {users[1].email}</h2>
            <h2>{users[2].id} / {users[2].username} / {users[2].email}</h2> */}
            
            {/* User의 값을 출력하는 컴포넌트를 하나 생성 */}
            {/* <User user={user[0]}/> 
            <User user={user[1]}/>
            <User user={user[2]}/> */}

            {/* users 값을 반복해서 user에 값을 설정 map() 함수를 사용 */}
            {/* key가 없으면 콘솔상 에러가 남 */}
            {
                users.map(user => (
                    <User user={user} key={user.id} />
                ))
            }

            {/* 만약 key로 사용할 만한 값이 없다면... array index 사용 */}
            {
                users.map((user, index)=>(
                    <User user={user} key={index} />
                ))
            }
        </div>
    );
};

export default UserList;