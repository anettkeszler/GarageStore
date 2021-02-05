import './App.css';
import React from 'react';
import { BrowserRouter, Switch, Route } from 'react-router-dom';
import NavBar from './components/Navbar';
import Main from './components/Main';
import Details from './components/Details';
import Form from './components/Form';
import About from './components/About';

function App() {
  return (
      <BrowserRouter>
        <NavBar/>
        <Switch>
            <Route exact={true} path='/' component={Main}/>
            <Route exact path='/stuff/:id' component={Details}/>
            <Route exact path='/add' component={Form}/>
            <Route exact path='/update/:id' component={Form}/>
            <Route exact path='/about' component={About}/>
        </Switch>
      </BrowserRouter>
  );
}

export default App;
