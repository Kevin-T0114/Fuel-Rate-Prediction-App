import Home from "./Home";
import {BrowserRouter, Route, Routes} from "react-router-dom"
import img from './images/bmw.jpg'

function App() {
  return (
    <div>
      <Home/>
      <img src={img} alt="bmw" className="bmw"></img>
    </div>
  )
}

export default App;
