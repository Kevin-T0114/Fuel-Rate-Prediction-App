import Home from './pages/Home';
import Profile from './pages/Profile';
import Register from './components/Registration';
import Login from './components/Login';
import Navbar from './components/Navbar';
import QuoteForm from './components/QuoteForm';
import {BrowserRouter, Route, Routes} from "react-router-dom"

function App() {
  return (
    <div className="app">
      <Navbar/>
      <BrowserRouter>
        <Routes>
          <Route index element={<Home/>}/>
          <Route path="/profile" element={<Profile/>}/>
          <Route path="/home" element={<Home/>}/>
          <Route path='/registration' element={<Register/>}/>
          <Route path='/login' element={<Login/>}/>
          <Route path='/quote' element={<QuoteForm/>}/>
        </Routes>
      </BrowserRouter>
    </div>
  )
}

export default App;
