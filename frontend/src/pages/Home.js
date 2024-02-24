import SmallHomeBox from '../components/SmallHomeBox'
import Navbar from '../components/Navbar'
import bmw from '../images/bmw.jpg'

const Home = () => {
    return (
        <div>
            {/* <Navbar/> */}
            <img src={bmw} alt="bmw" className="bmw"></img>
            <SmallHomeBox/>
        </div>
    )
}

export default Home