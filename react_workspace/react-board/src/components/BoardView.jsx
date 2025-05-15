import React from 'react';
import Button from 'react-bootstrap/Button';
import Card from 'react-bootstrap/Card';
import { Link, useParams } from 'react-router-dom';
import { boardList } from '../data/data';

const BoardView = () => {

    const { id } = useParams();

    //id 에 해당하는 배열의 번지의 객체를 뿌려주기
    //findIndex : 특정 조건을 만족하는 요소의 index 리턴
    const idx = boardList.findIndex(b => b.id === Number(id));
    const board = boardList[idx];
    console.log(board);

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
                    create on {board.reg_date.substring(0, board.reg_date.indexOf('T'))}  by  {board.writer}
                </Card.Body>
            </Card>

            <Link to={`/modify/${board.id}`}>
                <Button variant="warning">수정</Button>
            </Link>
            <Button variant="danger">삭제</Button>

        </div>
    );
};

export default BoardView;