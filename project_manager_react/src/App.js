import logo from './logo.svg';
import './App.css';
import Dashboard from './components/Dashboard';

function App() {
  return (
    <div className="App">
      <header className="App-header">
      <h1>Welcome to Emeka's Project Manager App</h1>
        <img src={logo} className="App-logo" alt="logo" />
        <p>
          Project
        </p>
        <a
          className="App-link"
          href="https://reactjs.org"
          target="_blank"
          rel="noopener noreferrer"
        >
          Learn React
        </a>
        <Dashboard/>
      </header>
    </div>
  );
}

export default App;
// Edit <code>src/App.js</code> and save to reload.
