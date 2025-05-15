import React from 'react';
import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';
import { Link, useParams } from 'react-router-dom';
import { boardList } from '../data/data';

const BoardModify = () => {
    const { id } = useParams();
    //id 에 해당하는 배열의 번지의 객체를 뿌려주기
    //findIndex : 특정 조건을 만족하는 요소의 index 리턴
    const idx = boardList.findIndex(b => b.id === Number(id));
    const board = boardList[idx];
    console.log(board);

    return (
        <div className='boardModify board'>
            <h2>Board Modify Page</h2>
            <h3>{id} 게시글 수정</h3>
            <Form>
                <Form.Group className="mb-3" controlId="formGroupEmail">
                    <Form.Label>Title</Form.Label>
                    <Form.Control type="text" placeholder="Title..." value={board.title}/>
                    <Form.Label>Write</Form.Label>
                    <Form.Control type="text" placeholder="Write..." value={board.writer} readOnly/>
                </Form.Group>
                <Form.Group className="mb-3" controlId="formGroupPassword">
                    <Form.Label>Content</Form.Label>
                    <Form.Control as="textarea" value={board.contents} rows={10} aria-label="With textarea" placeholder='Content...'/>
                </Form.Group>
            </Form>

            
            <Button variant="warning">수정완료</Button>
            <Link to={'/'}>
                <Button variant="primary">리스트로...</Button>
            </Link>
        </div>
    );
};

export default BoardModify;