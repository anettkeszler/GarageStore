import React from 'react';
import {Link} from 'react-router-dom';
import '../NavBar.css';

function NavBar() {
    return(
        <header className='navbar-header'>
            <ul className='list-style'>
                <li className='list-item-style'>
                    <Link className='link-style' to='/'>HOME</Link>
                </li>
                <li className='list-item-style'>
                    <Link className='link-style' to='/add'>ADD NEW STUFF</Link>
                </li>
                <li className='list-item-style'>
                    <Link className='link-style' to='/about'>ABOUT US</Link>
                </li>
            </ul>
        </header>
    );
}

export default NavBar;