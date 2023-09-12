import logo from './logo.svg';
import './App.css';
import Button from './components/Button/Button';
import Card from './components/Card/Card';

const AppCopy = ({showImage, buttonAction}) => {
  return !showImage ? (
    <div className="App">
      <header className="App-header">
        <Card><img src={logo} className="App-logo" alt="logo" /></Card>        
        <p>
          Edit <code>src/App.js</code> and save to reload.
        </p>
        <a
          className="App-link"
          href="https://reactjs.org"
          target="_blank"
          rel="noopener noreferrer"
        >
          Learn React
        </a>
        <Button disabled={false} name="hide" onclick={buttonAction}></Button>
      </header>
    </div>
  ): (
    <div className="App">
      <header className="App-header">
        <Button disabled={false} name="show" onclick={buttonAction}></Button>
      </header>
    </div>
  );
}

export default AppCopy;
