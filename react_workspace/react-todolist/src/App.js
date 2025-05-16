import React from 'react';

import TodoList from './components/TodoList';
import AddList from './components/AddList';

function App() {
  return (
    <div className="App">
      <AddList />
      <TodoList />
    </div>
  );
}

export default App;