import React from 'react';
import { useParams } from 'react-router-dom';

// 경로 /param/:id
const Param = () => {
    // :id를 받는 작업이 필요 useParams()
    const { id } = useParams();

    return (
        <div className='comp param'>
            <h2>요청 id : {id}</h2>
        </div>
    );
};

export default Param;