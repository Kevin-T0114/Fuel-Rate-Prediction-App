import home from '../images/home icon 2.png'

const Navbar = () => {
    return (
        <div className="navbar">
            <span className="material-symbols-outlined">account_circle</span>
            <a href="/profile" className="profile">Profile</a>
            <a href="/login" className="login">Login</a>
            <a href="/registration" className="register">Register</a>
            <img src={home} className='home' onClick={() => window.open('/home', '_self')}></img>
            <a href='/form' className='qForm'>Make a Quote</a>
            <a href='/history' className='qHistory'>Quote History</a>
        </div>
    )
}

export default Navbar
