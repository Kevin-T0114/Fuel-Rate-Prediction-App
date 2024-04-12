import Home from './pages/Home';
import Profile from './pages/Profile';
import Register from './components/Registration';
import Login from './components/Login';
import Navbar from './components/Navbar';
import QuoteForm from './components/QuoteForm';
import {BrowserRouter, Route, Routes, Navigate, Outlet} from "react-router-dom"
import QuoteHistory from './components/QuoteHistory';


const PrivateRoutes = () => {
  let token = (/true/i).test(sessionStorage.getItem("auth"));
  return (
    token ? <Outlet/> : <Navigate to="/login"/>
  )
}

function App() {
  return (
    <div className="app">
      <Navbar/>
      <BrowserRouter>
        <Routes>
          <Route index element={<Home/>}/>
          <Route path="/home" element={<Home/>}/>
          <Route path='/login' element={<Login/>}/>
          <Route path='/registration' element={<Register/>}/>
          <Route element={<PrivateRoutes/>}>
            <Route path="/profile" element={<Profile/>}/>
            <Route path='/history' element={<QuoteHistory/>}/>
            <Route path='form' element={<QuoteForm/>}/>
          </Route>
        </Routes>
      </BrowserRouter>
    </div>
  )
}

export default App;
