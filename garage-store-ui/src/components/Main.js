import React, {useState, useEffect} from 'react';
import { Link} from 'react-router-dom';
import Axios from 'axios';
import '../App.css';
import '../Main.css';

function Main(props) {
    const [stuffs, setStuffs] = useState([{name: "loading..."}]);

    useEffect(() => {
        Axios.get('http://localhost:8762/stuff/all').then(({data}) => {
            setStuffs(data);
            console.log(data);
            }
        );
    },[]);

    return(
        <div className='main-style' >
            <h1>GARAGE STORE</h1>
            <div className='card-container'>
                {stuffs.map(stuff => {
                    const {id, name, image, price, soldStatus } = stuff;
                    return (
                        <Link to={{pathname: `/stuff/${id}`}} className='card'>
                            <div className='card-name' >{name}</div>
                            {soldStatus ?
                                <div className='card-price-red'>SOLD</div> :
                                <div className='card-price'>{price}$</div>
                            }
                            <img className='card-image' src={image} alt="alternative text" width="200" height="150" />
                        </Link>
                    );
                })
                }
            </div>
        </div>
    );
}

export default Main;