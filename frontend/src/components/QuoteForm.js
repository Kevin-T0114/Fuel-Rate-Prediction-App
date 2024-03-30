import { useEffect, useState } from 'react';
import axios from 'axios';
const QuoteForm = () => {

    let deliveryDate = "0-0-2000";
    let gallon;
    let suggestedPrice = 0;
    let amountDue = 0;
    let deliveryAddress = "";
    function GallonRequest() {

        return (
            <div>
                <label for="gallons">Enter Gallons Requested: </label>
                <input type="number" id="gallons" name="Gallons" placeholder="0.0" step="0.01" min="0" />
            </div>
        );
        //field to  be entered
    }

    function DeliveryAddress() {
        const [address, setAddress] = useState();
        const getData = async () => {
            const { data } = await axios.get("/api/form/location");
            setAddress(data);
            deliveryAddress = data;
        };
        useEffect(() => {
            getData();
        }, []);
        
        console.log(deliveryAddress);
        //document.getElementById('element').innerHTML = deliveryAddress;
        return (<label>{address} </label>);
        //imported from clients profile
    }

    function DeliveryDate() {
        return (
            <div>
                <label for="delivery">Enter Delivery Date: </label>
                <input type="date" id="delivery" name="DeliveryDate" />
            </div>
            
        );
    }

    function SuggestedPricePerGallon() {
        return (
            <label>$37.00</label>
        );
    }

    function FormRequest() {
        const [amount, setAmount] = useState('');
        const [suggest, setSuggest] = useState('');
        const [price, setPrice] = useState();
        const getData = async () => {
            const { data } = await axios.get("/api/form/price");
            setPrice(data);
            deliveryAddress = data;
        };
        useEffect(() => {
            getData();
        }, []);
        function handleSubmit(e) {
            // Prevent the browser from reloading the page
            e.preventDefault();

            // Read the form data
            const form = e.target;
            const formData = new FormData(form);

            
            // Or you can work with it as a plain object:
            const formJson = Object.fromEntries(formData.entries());
            //console.log(formJson);

            console.log(formJson.DeliveryDate);
            console.log(formJson.Gallons);
            suggestedPrice = price;
            gallon = formJson.Gallons;
            deliveryDate = formJson.DeliveryDate;
            amountDue = (gallon * suggestedPrice).toFixed(2);
            setSuggest(suggestedPrice);
            setAmount(amountDue);

            const QuoteRec = {
                Gallons: String(gallon),
                Address: deliveryAddress,
                Date: deliveryDate,
                Price: String(suggestedPrice),
                Due: String(amountDue)
            }
            try { 
                axios.post('/api/form/result', QuoteRec)
                    .then(res => {
                        console.log(res.data)
                    })
            } catch (error) {
                console.error(error.response.data);     
            }
        }
        return (
            <form method="post" onSubmit={handleSubmit}>
                <label>Address: <DeliveryAddress /><br /></label>
                <GallonRequest />
                <DeliveryDate />
                <p>Price Per Gallon: ${suggest}</p>
                <p>Amount Due: ${amount}</p>
                
                <button type="reset">Reset Form</button>
                <button type="submit">Calculate Price</button>
            </form>
        );
    }
    const myStyle = {
        backgroundImage:
            "url('https://images.unsplash.com/photo-1516199423456-1f1e91b06f25?q=80&w=1149&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D')",
        height: "105vh",
        marginTop: "-70px",
        fontSize: "50px",
        backgroundSize: "cover",
        backgroundRepeat: "no-repeat",
        color: "white",
    };
    return (
        <div className="quote" style={myStyle}>         
            <h1>
                Quote Form
            </h1>
            <FormRequest />            
        </div> 
    );
    
}

export default QuoteForm;

