const Quote = ({quote}) => {
    return (
    <tr>
        <td>{quote.gallonsRequested}</td>
        <td>{quote.address.toUpperCase()}</td>
        <td>{quote.deliveryDate}</td>
        <td>${quote.pricePerGallon}</td>
        <td>${quote.totalPrice}</td>
    </tr>
    )
}

export default Quote