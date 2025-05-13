import axios from 'axios';
import React, { useEffect, useState } from 'react';

async function get(id) {
    try {
        const response = await axios.get(
            `https://jsonplaceholder.typicode.com/users/${id}`);
            return response.data;
    } catch (error) {
        console.log(error);
    }
}

const UserOne = () => {
    const id = 1;

    const [users, setUser] = useState(null);
    console.log(user);
    useEffect(()=>{
        // getUser(id);
        setUser(getUser(id));
        console.log(usertmp);
    } ,[id]);

    if(!user) return <div>error...</div>

    return (
        <div className='userOne'>
            <h2>{users.name}</h2>
        </div>
    );
};

export default UserOne;