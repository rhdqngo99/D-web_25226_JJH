import React from 'react';
import { useSelector } from 'react-redux';
import TodoItem from './TodoItem';

const todoList = () => {

    const item = useSelector((state) => state.post);
	
    return (
        <ul>
            {item.map((item) => (
                <TodoItem key={item.id} item={item} />
            ))}
        </ul>
    );
};

export default todoList;