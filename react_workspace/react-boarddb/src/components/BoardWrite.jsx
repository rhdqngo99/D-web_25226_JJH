import React, { useState } from 'react';
import Form from 'react-bootstrap/Form';
import Button from 'react-bootstrap/Button';
import axios from 'axios';

const BoardWrite = () => {

    // 게시글 객체 생성
    const [form, setForm] = useState({
        title:'',
        writer:'',
        content:''
    });

    const { title, writer, content } = form;

    const onChange = (e)=>{
        setForm({
            ...form,
            [e.target.name] : e.target.value
        })
    }

    const onSubmit = async ()=>{
        // 등록 : form 객체를 서버로 보내 DB로 등록
        if(title === ''){
            alert('제목을 입력해주세요.');
            return;
        }
        if(writer === ''){
            alert('작성자를 입력해주세요.');
            return;
        } 
        if(content === ''){
            alert('내용을 입력해주세요.');
            return;
        }
        const response = await axios.post('/insert', form);
        //console.log(response.data);
        window.location.href="/";
    }

    const onReset = ()=>{
        // 취소
        setForm({
            title:'',
            writer:'',
            content:''
        })
    }

    return (
        <div className='boardWrite board'>
            <h2>Board Write Page</h2>
            {/* 제목 작성자 내용 */}
            <Form>
                <Form.Group className="mb-3" controlId="formGroupEmail">
                    <Form.Label>Title</Form.Label>
                    <Form.Control type="text" 
                        name='title' 
                        value={title} 
                        onChange={onChange}
                        placeholder="Title..." />
                    <Form.Label>Writer</Form.Label>
                    <Form.Control type="text" 
                        name='writer' 
                        value={writer} 
                        onChange={onChange}
                        placeholder="Write..." />
                </Form.Group>
                <Form.Group className="mb-3" controlId="formGroupPassword">
                    <Form.Label>Content</Form.Label>
                    <Form.Control as="textarea" 
                        name='content' 
                        value={content}
                        rows={10} 
                        onChange={onChange}
                        aria-label="With textarea" 
                        placeholder='Content...'/>
                </Form.Group>
            </Form>

            <div className='text-center'>
                <Button variant="success" onClick={onSubmit}>등록</Button>
                <Button variant="warning" onClick={onReset}>취소</Button>
            </div>
        </div>
    );
};

export default BoardWrite;