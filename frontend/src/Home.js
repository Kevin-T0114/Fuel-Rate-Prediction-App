import Navbar from "./components/Navbar"
import SmallHomeBox from "./components/SmallHomeBox"
import bmw from './images/bmw.jpg'

const Home = () => {
    return (
        <div>
            <img src={bmw} alt="bmw" className="bmw"></img>
            <SmallHomeBox/>
        </div>
    )
}

export default Home