import axios from 'axios';
import React, { useEffect, useState } from 'react';
import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';
import { Link, useParams } from 'react-router-dom';
// import { boardList } from '../data/data';

const BoardModify = () => {
    const { id } = useParams();
    // id 에 해당하는 배열의 번지의 객체를 뿌려주기
    // findIndex : 특정 조건을 만족하는 요소의 index 리턴
    // const idx = boardList.findIndex(b => b.id === Number(id));
    // const board = boardList[idx];
    // console.log(board);

    const [ board, setBoard ] = useState(null);
    const [form, setForm] = useState({
        title: '',
        writer: '',
        contents: ''
    });
    
    const getBoard = async () =>{
        const response = await axios.get(`/view/${id}`);
        // response.data  [{},{}]  
        // 값이 하나더라도 배열의 객체 형태로 리턴
        const result = response.data[0];
        setBoard(result);
        
        // form 값도 같이 셋팅
        setForm({
            title:result.title,
            writer:result.writer,
            contents:result.contents
        })
        
        console.log(response.data[0]);
        console.log(board);
    }
    
    useEffect(()=>{
        getBoard()
    },[]);
    
    // onChange
    const { title, writer, contents } = form;
    

    const onChange = (e)=>{
        setForm({
            ...form,
            [e.target.name] : e.target.value
        })
    }

    const onSubmit = async ()=>{
        // 등록 : form 객체를 서버로 보내 DB로 등록
        const response = await axios.post(`/update/${id}`, form);
        //console.log(response.data);
        window.location.href=`/view/${id}`;
    }

    if(!board) return <div>loading...</div>

    return (
        <div className='boardModify board'>
            <h2>Board Modify Page</h2>
            <h3>{id} 게시글 수정</h3>
            <Form>
                <Form.Group className="mb-3" controlId="formGroupEmail">
                    <Form.Label>Title</Form.Label>
                    <Form.Control type="text" 
                        placeholder="Title..." 
                        name='title'
                        value={title}
                        onChange={onChange}
                        />
                    <Form.Label>Write</Form.Label>
                    <Form.Control type="text" 
                        placeholder="Write..." 
                        name='writer'
                        value={writer} 
                        readOnly/>
                </Form.Group>
                <Form.Group className="mb-3" controlId="formGroupPassword">
                    <Form.Label>Content</Form.Label>
                    <Form.Control as="textarea" 
                        name='contents'
                        value={contents} 
                        rows={10} 
                        aria-label="With textarea" 
                        placeholder='Content...'
                        onChange={onChange}
                        />
                </Form.Group>
            </Form>

            
            <Button variant="warning" onClick={onSubmit}>수정완료</Button>
            <Link to={'/'}>
                <Button variant="primary">리스트로...</Button>
            </Link>
        </div>
    );
};

export default BoardModify;