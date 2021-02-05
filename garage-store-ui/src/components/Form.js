import React, {useEffect, useState} from 'react';
import { Redirect } from 'react-router-dom';
import axios from 'axios';
import '../App.css';
import '../Form.css';

function Form(props) {
    // console.log(props);
    console.log(props.location.pathname);
    console.log(props.location.pathname.includes("update"));

    const isUpdate = props.location.pathname.includes("update");
    const id = props.match.params.id;

    const [loaded, setLoaded] = useState(false);
    const [buttonText, setButtonText] = useState("Submit");
    const [name, setName] = useState("");
    const [price, setPrice] = useState("");
    const [image, setImage] = useState("");
    const [year, setYear] = useState("");
    const [description, setDescription] = useState("");
    const [youtubeVideoUrl, setYoutubeVideoUrl] = useState("");
    const [updated, setUpdated] = useState(false);
    const [added, setAdded] = useState(false);

    function formHandler() {
        isUpdate ? updateStuff() : addNewStuff();
    }

    const updateStuff = () => {
        console.log("Should write your updateStuff() method here...")
        const payload = updatePayload();

        axios.put(`http://localhost:8762/stuff/${id}/update`, payload)
            .then((response) => {
                    console.log("response:", response)
                if (response.status===200) {
                    setUpdated(true);
                }
            });
    };

    function updatePayload() {
        console.log("addNewStuff() method has been called...");
        const nameValue = document.querySelector("#name").value;
        // alert("this was submitted: " + nameValue)
        const priceValue = document.querySelector("#price").value;
        // alert("this was submitted: " + priceValue);
        const imageUrlValue = document.querySelector("#image").value;
        console.log(imageUrlValue);
        const purchaseYearValue = document.querySelector("#year").value;
        const descriptionValue = document.querySelector("#description").value;
        const youTubeVideoUrlValue = document.querySelector("#youtubeVideoUrl").value;

        const payload = {
            "stuff": {
                "name": nameValue,
                "image": imageUrlValue,
                "price": priceValue
            },
            "stuffDetailsResult": {
                "purchaseYear": purchaseYearValue,
                "description": descriptionValue,
                "youtubeVideoUrl": youTubeVideoUrlValue
            }
        }

        console.log(payload);
        return payload;
    }

    const addNewStuff = () => {
        const payload = updatePayload();

        axios.post(`http://localhost:8762/stuff/add`, payload).then(result => {
            console.log(result);
            console.log(result.data);
            if (result.status===200) {
                setAdded(true);
            }
        }).catch(error => {
            console.log(error);
        })
    };

    function setAllState(data) {
        setName(data.stuff.name);
        setPrice(data.stuff.price);
        setImage(data.stuff.image);
        setYear(data.stuffDetailsResult.purchaseYear);
        setDescription(data.stuffDetailsResult.description);
        setYoutubeVideoUrl(data.stuffDetailsResult.youtubeVideoUrl);
        setButtonText("Update")
        setLoaded(true);
        console.log("data arrived", data);
    }

    function cleanAllState() {
        setName("");
        setPrice("");
        setImage("");
        setYear("");
        setDescription("");
        setYoutubeVideoUrl("");
        setButtonText("Submit");
        setLoaded(true);
    }

    useEffect(() => {
        if (isUpdate) {
            console.log("id before axios fetch: " + id)
            axios.get(`http://localhost:8762/stuff/${id}`)
                .then((response) => {
                    setAllState(response.data);
                });
        }
        return cleanAllState();
    }, [props, isUpdate]);


    if (!loaded) {
        return (<div>Please wait...</div>);
    }

    if (updated) {
        return <Redirect to={`/stuff/${id}`}/>
    }

    if (added) {
        return <Redirect to={`/`}/>
    }

    return(
        <div className='form-style'>
            {isUpdate ?
                <h1>Update your STUFF data</h1> :
                <h1>Upload a new STUFF to sell</h1>
            }
            <div className='form-body'>
                <div className='form-container'>
                    <form  method="POST" action="/stuff/add">
                        <div className='input-container'>
                            <label htmlFor="name" >Name your stuff : </label>
                            <br/>
                            <input contentEditable='true' type="text" id="name" name="name" placeholder="give a name" defaultValue={name} />
                        </div>
                        <div className='input-container'>
                            <label htmlFor="price" >Give the price: </label>
                            <br/>
                            <input type="text" id="price" name="price" placeholder="...what makes you happy." defaultValue={price}/>
                        </div>
                        <div className='input-container'>
                            <label htmlFor="image" >Copy an image url: </label>
                            <br/>
                            <textarea className='img-textarea' type="text" id="image" name="image" placeholder="http://image_example.com" defaultValue={image} maxLength="500"/>
                        </div>
                        <div className='input-container'>
                            <label htmlFor="year" >When did you gain this stuff: </label>
                            <br/>
                            <input type="text" id="year" name="year" placeholder="e.g.: 2020..." defaultValue={year}/>
                        </div>
                        <div className='input-container'>
                            <label htmlFor="description" >Description: </label>
                            <br/>
                            <textarea className='descr-textarea' type="text" id="description" name="description" placeholder="..." defaultValue={description} maxLength="500" />
                        </div>
                        <div className='input-container'>
                            <label htmlFor="youtubeVideoUrl" >Copy video id: </label>
                            <br/>
                            <textarea className='url-textarea' type="text" id="youtubeVideoUrl" name="youtubeVideoUrl" placeholder="Give a YouTube link to obtain more buyers..." defaultValue={youtubeVideoUrl} maxLength="500"/>
                        </div>
                        <input
                            className='button'
                            type="button"
                            value= {buttonText}
                            onClick={formHandler}/>
                    </form>
                </div>
            </div>
        </div>
    );
}

export default Form;