const Quote = ({quote}) => {
    return (
    <tr>
        <td>{quote.deliveryDate}</td>
        <td>{quote.address.toUpperCase()}</td>
        <td>{quote.gallonsRequested}</td>
        <td>${quote.pricePerGallon}</td>
        <td>${(quote.totalPrice).toFixed(2)}</td>
    </tr>
    )
}

export default Quote