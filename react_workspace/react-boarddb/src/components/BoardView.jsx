import axios from 'axios';
import React, { useEffect, useState } from 'react';
import Button from 'react-bootstrap/Button';
import Card from 'react-bootstrap/Card';
import { Link, useParams } from 'react-router-dom';
// import { boardList } from '../data/data';

const BoardView = () => {

    const { id } = useParams();

    //id 에 해당하는 배열의 번지의 객체를 뿌려주기
    //findIndex : 특정 조건을 만족하는 요소의 index 리턴
    // const idx = boardList.findIndex(b => b.id === Number(id));
    // const board = boardList[idx];
    // console.log(board);

    const [board, setBoard] = useState(null);

    const getBoard = async () =>{
        const response = await axios.get(`/view/${id}`);
        // response.data  [{},{}]  
        // 값이 하나더라도 배열의 객체 형태로 리턴
        setBoard(response.data[0]);
    }

    useEffect(()=>{
        getBoard()
    },[]);

    const onDelete = async ()=>{
        // id를 경로에 달아서 파라미터로 보내기.
        const response = await axios.get(`/del/${id}`);
        // list로 이동
        window.location.href="/";
    }

    if(!board) return <div>loading...</div>

    return (
        <div className='boardView board'>
            <h2>Board View Page</h2>

            <h3>{id} 게시글 </h3>

            <Card style={{ width: '80%', margin: '50px auto' }}>
                <Card.Body>
                    <Card.Title>[{board.id}] {board.title}</Card.Title>
                    <Card.Text>
                        {board.contents}
                    </Card.Text>
                </Card.Body>
                <Card.Body>
                    create on {board.reg_date}  by  {board.writer}
                </Card.Body>
            </Card>

            <Link to={`/modify/${board.id}`}>
                <Button variant="warning">수정</Button>
            </Link>
            <Button variant="danger" onClick={onDelete}>삭제</Button>

        </div>
    );
};

export default BoardView;