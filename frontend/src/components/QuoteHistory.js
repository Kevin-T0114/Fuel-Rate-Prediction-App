import { useState } from 'react';
import './QuoteHistory.css';

function CreateTable(userDetails){
    let today = new Date();
    let date = today.getDate();
    let month = today.getMonth() + 1;
    let year = today.getFullYear();
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
                <tr>
                    <th scope="row">6</th>
                    <td>12345 ADDRESS LN</td>
                    <td>06/05/2003</td>
                    <td>$$$</td>
                    <td>$$$$</td>
                </tr>
                <tr>
                    <th scope="row">10</th>
                    <td>12345 ADDRESS LN</td>
                    <td>08/04/2004</td>
                    <td>$$$</td>
                    <td>$$$$</td>
                </tr>
                <tr>
                    <th scope="row">80</th>
                    <td>12345 ADDRESS LN</td>
                    <td>03/24/2005</td>
                    <td>$$$</td>
                    <td>$$$$</td>
                </tr>
            </tbody>
        </table>
    );
}

 export default function QuoteHistory(userCredentials){

    const [historyRequested, setRequest] = useState(false);

    function onHistoryRequest(userCredentials){
        setRequest(true);
    }

    return(
        <div className='pageStyle'>
            <h1>Quote History</h1>
            <button className='showButton' onClick= {() => onHistoryRequest(userCredentials)}>
                Show History
            </button>
            {historyRequested && <CreateTable userDetails={userCredentials}/>}
        </div>
    );
 }