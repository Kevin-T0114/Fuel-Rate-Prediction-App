import { useState } from 'react';
import Quote from './Quote';
import './QuoteHistory.css';

function CreateTable(userDetails){
    let today = new Date();
    let date = today.getDate();
    let month = today.getMonth() + 1;
    let year = today.getFullYear();
    let data = userDetails.userDetails.quotes
    console.log(data)
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

 export default function QuoteHistory(userCredentials){

    const [historyRequested, setRequest] = useState(false);
    const [error, setError] = useState(null)
    const [purchases, setPurchases] = useState([])

    const connection = async(e) => {
        e.preventDefault()
        const response = await fetch("/api/quotes")
        const json = await response.json()
        if (!response.ok) {
            setError(json.error)
            console.log('unsuccessful connection')
        }
        if (response.ok){
            setPurchases(json)
            setRequest(true)
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