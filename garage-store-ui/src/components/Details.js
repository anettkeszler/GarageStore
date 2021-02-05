import React, {useState, useEffect} from 'react';
import axios from 'axios';
import {Link, Redirect} from 'react-router-dom';
import Form from './Form';
import '../App.css';
import '../Details.css';


const youtubeEmbedPath = "https://www.youtube.com/embed";

function Details(props) {
    console.log("props", props);
    const id = props.match.params.id;
    console.log("id: ", id);

    const [details, setDetails] = useState({});
    const [loaded, setLoaded] = useState(false);
    const [redirect, setRedirect] = useState(false);


    console.log("props: " , props);

    useEffect(() => {
        axios.get(`http://localhost:8762/stuff/${id}`).then((response) => {
            const data = response.data;
            setDetails(data);
            setLoaded(true);
            console.log("data arrived", data);
        });
    }, []);

    function setSoldStatus() {
        axios.put(`http://localhost:8762/stuff/${id}/sold`)
            .then((response) => {
                console.log("response:", response)
                if (response.status===200) {
                    setRedirect(true);
                }
            });
    }

    if (!loaded) {
        return (<div>Please wait...</div>);
    }

    if (redirect) {
        return <Redirect to={`/`}/>
    }

    const { name, price, image, soldStatus } = details.stuff; // destruct
    const { stuffDetailsResult } = details;
    console.log("stuffdetailsresult", stuffDetailsResult);
    const {purchaseYear, description, youtubeVideoUrl } = stuffDetailsResult;
    const embedUrl = `${youtubeEmbedPath}/${youtubeVideoUrl}`;

    return (
        <div className='details-style'>
            <h1>{name}</h1>
            <div className='buttons-container'>
                <Link className='btn-link' name={name} to={{pathname: `/update/${id}`}}>
                    UPDATE
                </Link>
                {soldStatus ?
                   ""  : <Link className='btn-button' value="SOLD" onClick={setSoldStatus}>
                        SOLD
                    </Link>
                }
            </div>
            <div className='detail-card'>
                <div className='detail-card-top'>
                    <img src={image} alt="alternative text" width="200" height="150" className='detail-card-image'/>
                    {soldStatus ?
                        <div className='detail-card-price-red'>SOLD price: {price}$</div> :
                        <div className='detail-card-price'>ACTUAL price: {price}$ - LAST chance</div>
                    }
                    <div className='detail-card-year'>Purchase year: {purchaseYear}</div>
                    <div className='detail-card-description'>Description: {description}</div>
                </div>
                <div className='detail-card-bottom'>
                    <iframe className='detail-card-youtube-url' width="642" height="379" src={embedUrl} frameBorder="0"
                            allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"
                            allowFullScreen></iframe>
                </div>

            </div>

        </div>
    );
}

export default Details;