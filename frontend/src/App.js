import Home from './pages/Home';
import Profile from './pages/Profile';
import Register from './components/Registration';
import Login from './components/Login';
import Navbar from './components/Navbar';
import QuoteForm from './components/QuoteForm';
import {BrowserRouter, Route, Routes} from "react-router-dom"
import QuoteHistory from './components/QuoteHistory';

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
          <Route path='/history' element={<QuoteHistory/>}/>
          <Route path='form' element={<QuoteForm/>}/>
        </Routes>
      </BrowserRouter>
    </div>
  )
}

export default App;
