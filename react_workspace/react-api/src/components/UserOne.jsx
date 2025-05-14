import axios from 'axios';
import React, { useEffect, useState } from 'react';

async function getUser(id) {
    try {
        const response = await axios.get(
            `https://jsonplaceholder.typicode.com/users/${id}`);
        return response.data;
    } catch (error) {
        console.log(error);
    }
}

const UserOne = ({id}) => {

    const [user, setUser] = useState(null);
    
    useEffect(()=>{
        //수정되는 코드
        // const tmp = getUser(id);
        // setUser(tmp);
        // console.log(user);
        const fetchUser = async ()=> {
            const tmp = await getUser(id);
            setUser(tmp);
        };
        fetchUser();
        console.log(user);
    } ,[id]);

    if(!user) return <div>error...</div>

    return (
        <div className='userOne'>
            <h2>{user.name}</h2>
            <p><b>Email: {user.email} </b></p>
            <p><b>Username: {user.username} </b></p>
            <p><b>Phone: {user.phone} </b></p>
            <p><b>Website: {user.website} </b></p>
            <p><b>Company: {user.company.name} </b></p>
        </div>
    );
};

export default UserOne;