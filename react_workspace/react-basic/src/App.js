import './App.css';
import Count from './components/Count';
import Hello from './components/Hello';
import HelloProps from './components/HelloProps';
import InputSample from './components/InputSample';
import InputSample2 from './components/InputSample2';
import Start from './components/Start';
import UserList from './components/UserList';
import UserList2 from './components/UserList2';

function App() {
  return (
    <div className="App">
      <Start />
      <Hello />
      <HelloProps name="react" color="red" />
      <hr />
      <Count />
      <hr />
      <InputSample />
      <hr />
      <InputSample2 />
      <hr />
      <UserList />
      <hr />
      <UserList2 />
      <br />
      <br />
      <br />
      <br />
      <br />

    </div>
  );
}

export default App;