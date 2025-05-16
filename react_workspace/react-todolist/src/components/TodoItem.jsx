import React, { useState, useCallback } from 'react';
import { useDispatch } from 'react-redux';
import { 
  REMOVE_TODO_LIST,
  CHANGE_TODO_LIST,
  DONE_TOGGLE
} from '../reducers/index';

import {
  RemoveButton,
  EditButton,
  CancelButton,
  EditSuccess,
  ButtonGroup,
  ListMode,
  EditMode,
  CheckInput,
} from '../style';

const TodoItem = ({ item }) => {
  const dispatch = useDispatch();
  const [mode, setMode] = useState(true);
  const [text, setText] = useState(item.title);

  const [done, setDone] = useState(item.done);
	
  const onChangeCheck = useCallback(
    (id) => {
      dispatch({
        type: DONE_TOGGLE,
        payload: {
          id: id,
          done: !done,
        },
      });
      setDone(!done);
    },
    [done],
  );

  return (
    <li>
      {mode ? (
        <ListMode>
          <CheckInput type="checkbox" checked={done} onChange={() => onChangeCheck(item.id)} />
          {item.done ? <strike>{item.title}</strike> : <p>{item.title}</p>}
          <ButtonGroup>
            <RemoveButton onClick={() => onRemove(item.id)}>삭제</RemoveButton>
            <EditButton onClick={onClickChange}>수정</EditButton>
          </ButtonGroup>
        </ListMode>
      ) : (
        <EditMode>
          <input value={text} onChange={onChangeText} />
          <ButtonGroup>
            <CancelButton onClick={onCancleChange}>취소</CancelButton>
            <EditSuccess onClick={() => onChange(item.id, text)}>수정완료</EditSuccess>
          </ButtonGroup>
        </EditMode>
      )}
    </li>
  );
};

export default TodoItem;