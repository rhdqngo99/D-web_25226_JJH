import React from 'react';
import Form from 'react-bootstrap/Form';
import Button from 'react-bootstrap/Button';

const BoardWrite = () => {
    return (
        <div className='boardWrite board'>
            <h2>Board Write Page</h2>
            {/* 제목 작성자 내용 */}
            <Form>
                <Form.Group className="mb-3" controlId="formGroupEmail">
                    <Form.Label>Title</Form.Label>
                    <Form.Control type="text" placeholder="Title..." />
                    <Form.Label>Write</Form.Label>
                    <Form.Control type="text" placeholder="Write..." />
                </Form.Group>
                <Form.Group className="mb-3" controlId="formGroupPassword">
                    <Form.Label>Content</Form.Label>
                    <Form.Control as="textarea" rows={10} aria-label="With textarea" placeholder='Content...'/>
                </Form.Group>
            </Form>

            <div className='text-center'>
                <Button variant="success">등록</Button>
                <Button variant="warning">취소</Button>
            </div>
        </div>
    );
};

export default BoardWrite;