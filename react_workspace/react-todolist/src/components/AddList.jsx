import React, { useState, useCallback } from 'react';
import { useDispatch } from 'react-redux';
import shortId from 'shortid';
import { ADD_TODO_LIST } from '../reducers/index';

const AddList = () => {
  const [value, setValue] = useState('');
  const dispatch = useDispatch();

  const onChangeInput = useCallback(
    (e) => {
      setValue(e.target.value);
    },
    [value],
  );

  const onAddList = useCallback(() => {
    if (value === '') {
      return alert('내용을 입력해주세요.');
    }
    dispatch({
      type: ADD_TODO_LIST,
      payload: {
        id: shortId.generate(),
        title: value,
        done: false
      },
    });
    setValue('');
  }, [value]
);

  return (
    <div className="add-box">
      <input type="text" value={value} onChange={onChangeInput} />
      <button onClick={onAddList}>추가</button>
    </div>
  );
};

export default AddList;