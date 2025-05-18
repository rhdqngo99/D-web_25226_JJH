import { useState } from 'react';

import OutlineInput from './components/OutlineInput';
import PrimaryButton from './components/PrimaryButton';
import TextButton from './components/TextButton';
import ToDo from './components/ToDo';

const App = () => {
  const [inputValue, setInputValue] = useState('');
  const [toDoList, setToDoList] = useState([]);

  const handleChange = (e) => {
    setInputValue(e.target.value);
  };

  const addToDo = () => {
    setToDoList((current) => [...current, { isComplete: false, value: inputValue }]);
    setInputValue('');
  };

  const toggleComplete = (index) => {
    setToDoList((current) => current.map((item, i) => {
      if (i === index) {
        const newItem = Object.assign({}, item);
        newItem.isComplete = !newItem.isComplete;
        return newItem;
      } else {
        return item;
      }
    }));
  };

  const isUncompletedToDo = toDo => !toDo.isComplete;

  const getUncompletedToDoList = () => toDoList.filter(isUncompletedToDo);

  const removeAllCompletedToDo = () => {
    setToDoList((current) => current.filter(isUncompletedToDo));
  };

  return (
    <div className="app">
      <h1 className="app-title">To Do List</h1>

      <div className="app-form">
        <OutlineInput
          placeholder="이제 뭐함?"
          value={inputValue}
          onChange={handleChange}
        />
        <PrimaryButton
          label="할 일 추가"
          onClick={addToDo}
        />
      </div>

      <div className="app-list">
        {toDoList.map((toDo, index) =>
          <ToDo
            key={index}
            isComplete={toDo.isComplete}
            value={toDo.value}
            onClick={() => toggleComplete(index)}
          />
        )}
      </div>

      <div className="app-footer">
        <p>남은 일 :{getUncompletedToDoList().length}개</p>
        <TextButton
          label="완료 목록 삭제"
          onClick={removeAllCompletedToDo}
        />
      </div>
    </div>
  );
}

export default App;