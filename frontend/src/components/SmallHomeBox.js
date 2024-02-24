import QuoteForm from "./QuoteForm"
import { Link } from "react-router-dom"

const SmallHomeBox = () => {
    return (
        <div className="smallHomeBox">
            <div className="smallHomeBoxText">
                <h3>View Fuel Quote History Here!</h3>
            </div>
            <div className="fuelCalculator">
                <Link to='/history'>
                    <button>Click to View!</button>
                </Link>
            </div>
        </div>
    )
}

export default SmallHomeBox