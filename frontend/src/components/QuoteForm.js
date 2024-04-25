import { useEffect, useState } from 'react';
import axios from 'axios';
const user = sessionStorage.getItem("username");
const userSend = {
    User: String(user)
}
try {
    axios.post('/api/quotes/user', userSend)
        .then(res => {
            console.log(res.data)
        })
} catch (error) {
    console.error(error.response.data);
}

const QuoteForm = () => {
    let deliveryDate = "0-0-2000";
    let gallon = 0;
    let suggestedPrice = 0;
    let amountDue = 0;
    let deliveryAddress = "";
    let firstRender = 1;
    var clicked = 1;

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
            const { data } = await axios.get("/api/quotes/location");
            setAddress(data);
            deliveryAddress = data;
        };
        try {
            useEffect(() => {
                getData();
            }, []);
        } catch (error) {
            console.error(error.response.data);
        }

        console.log(deliveryAddress);
        //document.getElementById('element').innerHTML = deliveryAddress;
        return (<label>{address} </label>);
        //imported from clients profile
    }

    function DeliveryDate() {
        return (
            <div>
                <label for="delivery">Enter Delivery Date: </label>
                <input type="date" id="delivery" name="DeliveryDate"/>
            </div>

        );
    }
    function SuggestedPricePerGallon() {
        return (
            <label>$37.00</label>
        );
    }

    function clicking() {
        console.log("helloooooo")
        clicked = 1;
    }
    function unclicking() {
        clicked = 0;
    }
    function FormRequest() {
        const userSend = {
            User: String(user)
        }
        try {
            axios.post('/api/quotes/user', userSend)
                .then(res => {
                    console.log(res.data)
                })
        } catch (error) {
            console.error(error.response.data);
        }

        const [amount, setAmount] = useState('');
        const [suggest, setSuggest] = useState('');
        //const [price, setPrice] = useState('');
        //setPrice(0);
        const userGallons = {
            GallonsRequested: String(gallon)
        }
        //setSuggest(0);
        //setAmount(0);
        
            try {
                axios.post('/api/quotes/price', userGallons)
                    .then(res => {
                        while (firstRender > 0) {
                            if (firstRender > 0) {
                                setSuggest(res.data.toFixed(2));
                            }
                            amountDue = (gallon * suggest).toFixed(2);
                            if (amountDue != 0) {
                                setAmount(amountDue);
                            }
                            firstRender = firstRender - 1;
                        }
                    })

                //setSuggest(suggestedPrice);

                //console.log(price);
            } catch (error) {
                console.error(error.response.data);
            }
            
        
        /*
        try {
            getData(userGallon);
        }  catch (error) {
            console.error(error.response.data);
        }
        */
        
        function handleSubmit(e) {
            // Prevent the browser from reloading the page
            e.preventDefault();
            // Read the form data
            const form = e.target;
            const formData = new FormData(form);

            // Or you can work with it as a plain object:
            const formJson = Object.fromEntries(formData.entries());
            //console.log(formJson);
            //setPrice(0);
            
            //console.log(formJson.DeliveryDate);
            //console.log(formJson.Gallons);
            //console.log(user);
            if (formJson.DeliveryDate !== "" && formJson.Gallons != 0) {
                const userGallons = {
                    GallonsRequested: String(formJson.Gallons)
                }
                let sug = 0;
                const getData = async () => {
                    try {
                        await axios.post('/api/quotes/price', userGallons)
                            .then(res => {
                                sug = res.data;
                            })
                    } catch (error) {
                        console.error(error.response.data);
                    }
                    setSuggest(sug.toFixed(2));
                    amountDue = (gallon * suggest).toFixed(2);
                    setAmount(amountDue);
                    function setGallons() {
                        gallon = formJson.Gallons;
                        console.log(gallon);
                    }
                    setGallons();
                    //suggestedPrice = price;
                    deliveryDate = formJson.DeliveryDate;
                    console.log(clicked);
                    if (clicked == 1) {
                        const QuoteRec = {
                            Gallons: String(gallon),
                            Address: String(deliveryAddress),
                            Date: deliveryDate,
                            Price: String(sug.toFixed(2)),
                            Due: String(amountDue),
                            User: String(user)
                        }
                        try {
                            axios.post('/api/quotes/result', QuoteRec)
                                .then(res => {
                                    console.log(res.data)
                                })
                        } catch (error) {
                            console.error(error.response.data);
                        }
                        //console.log(suggestedPrice);
                    }
                    firstRender = 3;
                }
                getData();
            }
            firstRender = 3;
        }
        return (
            <div>
                <form method="post" onSubmit={handleSubmit}>
                    <label>Address: <DeliveryAddress /><br /></label>
                    <GallonRequest />
                    <DeliveryDate />
                    <p>Price Per Gallon: ${suggest}</p>
                    <p>Amount Due: ${amount}</p>

                    <button type="reset">Reset Form</button>
                    <button type="submit" onClick={clicking} value="1">Submit Quote</button>
                    <button type="submit" onClick={unclicking} value="0">Get Quote</button>
                </form>
                
            </div>
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