import Home from "./Home";
import ProfileForm from './components/ProfileForm';
import Navbar from "./components/Navbar";
import {BrowserRouter, Route, Routes} from "react-router-dom"

function App() {
  return (
    <div className="app">
      <Navbar/>
      <BrowserRouter>
        <Routes>
          <Route index element={<Home/>}/>
          <Route path="/profile" element={<ProfileForm/>}/>
          <Route path="/home" element={<Home/>}/>
        </Routes>
      </BrowserRouter>
    </div>
  )
}

export default App;
