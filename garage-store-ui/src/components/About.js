import React from 'react';
import '../App.css';
import '../About.css';


function About() {
    return (
        <div className='about-style'>
            <h1>WELCOME TO THE GARAGE STORE COMPANY!</h1>
            <div className='about-body'>
                <div className='about-container'>
                    <h2>- OUR MISSION - </h2>
                    <p>To provide the highest quality to our buyers.</p>
                    <h2>Who We Are?</h2>
                    <p>Here at The Garage Store we like to provide eco-friendly, resale alternatives to every day products. From shoes to beauty, we have a variety of different products to help make your every day choices kinder to the environment!</p>
                    <h2>About Us</h2>
                    <p><strong>Krissz (Founder, Developer)</strong>: " "</p>
                    <p><strong>Netti (Frontend Developer)</strong> : " I've always been slightly eco conscious but it wasn't until I had my child that I really became hyper aware of all the waste that I was producing, especially every time I threw away disposable nappies and wipes, and what it was doing to the environment (eek!)..."</p>
                    <p><strong>Eszkis (Developer)</strong>: " "</p>
                    <p><strong>Omar (DevOps)</strong>: " "</p>
                    <h2>Contact</h2>
                    <p><strong>Our mailing address is</strong>: 10 Nagymezo Street, 1065 Budapest, GarageStore office</p>
                    <p><strong>Phone</strong>: 0036701234567</p>
                    <p><strong>Email</strong>: garage@store.com</p>
                </div>
            </div>
        </div>
    );
}

export default About;