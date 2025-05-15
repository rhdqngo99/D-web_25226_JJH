import React, { useEffect, useState } from 'react';
import Table from 'react-bootstrap/Table';
import { Button } from 'react-bootstrap';
// import { boardList } from '../data/data';
import { Link } from 'react-router-dom';
import axios from 'axios';

const BoardList = () => {

    // 비동기로 board 테이블에 있는 전체 값을 가져오기
    const [boardList, setBoardList] = useState(null);

    const getBoardData = async ()=>{
        const response = await axios.get('/list'); // server.js res.send 값이 들어옴
        setBoardList(response.data);
        console.log(response);
    }

    //useEffect : 마운트 될때와 업데이트 될 때 호출(실행)
    //useEffect((function), deps)
    // deps : 배열 형태, 배열안에서 검사하고자 하는 특정 값, 빈배열
    //  [] 빈배열 : 마운트 될 때만 실행
    //  [name] : name이 업데이트 될 때마다 실행
    //  x : 랜더링 될 때마다 실행

    useEffect(()=>{
        getBoardData();
    }, []);

    if(!boardList) return <div>내용이 없습니다.</div>

    return (
        <div className='boardList board'>
            <h2>Board List Page</h2>

            <Table striped bordered hover>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Title</th>
                        <th>Writer</th>
                        <th>Reg_date</th>
                    </tr>
                </thead>
                <tbody>
                    {
                        boardList.map(b=>(
                            <tr key={b.id}>
                                <td>{b.id}</td>
                                <td>
                                    <Link to={`/view/${b.id}`}> {b.title} </Link>
                                </td>
                                <td>{b.writer}</td>
                                <td>{b.reg_date}</td>
                            </tr>
                        ))
                    }
                    
                </tbody>
            </Table>

            {/* 글쓰기 버튼 추가 */}
            <Link to={'/write'}> 
                <Button variant="primary">글쓰기</Button> 
            </Link>
        </div>
    );
};

export default BoardList;