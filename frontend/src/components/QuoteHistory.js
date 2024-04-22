import { useState } from 'react';
import Quote from './Quote';
import './QuoteHistory.css';

function CreateTable(userDetails){
    let today = new Date();
    let date = today.getDate();
    let month = today.getMonth() + 1;
    let year = today.getFullYear();
    let data = userDetails.userDetails
    console.log(userDetails.userDetails.quotes)

    if (Object.keys(data) > 0){
        return(
            <table className='historyTable'>
                <caption>
                    Client Fuel Quote History {month}/{date}/{year}
                </caption>
                <thead>
                    <tr>
                        <th scope ='col'>Gallons Requested</th>
                        <th scope ='col'>Delivery Address</th>
                        <th scope ='col'>Delivery Date</th>
                        <th scope ='col'>Suggested Price / gallon</th>
                        <th scope ='col'>Total Amount Due</th>
                    </tr>
                </thead>
                <tbody>
                    {data.map((data) => (
                        <Quote key={data.id} quote={data}/>
                    ))}
                </tbody>
            </table>
        );
    }

    else {
        return (
            <div className='noResults'>
                <h2>No previous quotes for this user.</h2>
            </div>
        )
    }
}

 export default function QuoteHistory(userCredentials){

    const [historyRequested, setRequest] = useState(false);
    const [error, setError] = useState(null)
    const [purchases, setPurchases] = useState([])
    const user = sessionStorage.getItem("username");

    const connection = async(e) => {
        e.preventDefault()
        const response = await fetch("/api/quotes/getQuotes?" + new URLSearchParams({User: user}))
        const json = await response.json()
        if (!response.ok) {
            setError(json.error)
        }
        if (response.ok){
            setPurchases(json)
            setRequest(true)
            console.log(json)
        }
    }

    return(
        <div className='pageStyle'>
            <h1>Quote History</h1>
            <button className='showButton' onClick= {connection}>
                Show History
            </button>
            {historyRequested && <CreateTable userDetails={purchases}/>}
        </div>
    );
 }