import React from 'react';
import Table from 'react-bootstrap/Table';
import { Button } from 'react-bootstrap';
import { boardList } from '../data/data';
import { Link } from 'react-router-dom';

const BoardList = () => {
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