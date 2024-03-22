import React, { useState } from 'react';
import { Link } from 'react-router-dom';
import './Registration.css'

function UserTaken({takenUser, submitted}){
    if(!submitted){
        return;
    }
    else if(takenUser){
        return <p>Username already taken; Please try again</p>;
    }
}

function PasswordVerify({takenUser, matched, submitted}){
    if(!submitted){
        return;
    }
    else if(takenUser){
        return;
    }
    else if(!matched){
        return <p>Passwords do not match; Please try again</p>;
    }  
}

function RegisterForm({userCredentials, setUserCredentials}){
    const [userName, setUsername] = useState('');
    const [passWord, setPassword] = useState('');
    const [vfyPassword, setVfyPassword] = useState('');
    const [matchPass, setMatchPass] = useState(false);
    const [userExists, setUserExists] = useState(false);
    const [submitPressed, setSubmitted] = useState(false);
    let existingUser = false;

    function checkUser(){
        if(userName === 'Adam'){
            existingUser = true;
            setUserExists(existingUser);
        }
        else{
            existingUser = false;
            setUserExists(existingUser);
        }
    }

    function match(){
        if(passWord === vfyPassword){
            alert('Registration complete!'); {/*LINK BACK TO LOGIN PAGE */}
            setMatchPass(true);
        }
        else{
            setPassword('');
            setVfyPassword('');
            setMatchPass(false);
        }
    }


    return(
        <form className='registrationForm' onSubmit={e => {
            e.preventDefault();
            setSubmitted(true);
            checkUser();
            if(!existingUser){
                match();
            }
        }}>
            <p className='user'> <b>Username</b> </p>
            <input className='registrationInput' type='text' placeholder='Username' value={userName} onChange={e => setUsername(e.target.value)} required/>
            <UserTaken takenUser={userExists} submitted={submitPressed}/>
            <p className='pass'><b>Password</b></p> 
            <input className='registrationInput' type='text' placeholder='Password' value={passWord} onChange={e => setPassword(e.target.value)} required/>
            <p className='rePass'><b>Re-enter Password</b></p> 
            <input className='registrationInput' type='text' placeholder='Re-enter Password' value={vfyPassword} onChange={e => setVfyPassword(e.target.value)} required/>
            <PasswordVerify takenUser={userExists} matched={matchPass} submitted={submitPressed} />
            <Link to='/login'>
                <button className='registrationButton' type='submit'>Register</button>
            </Link>
        </form>
    );
}

function Register(){
    return (
        <div>
            <h1 className='registrationHeader'>Register</h1>
            <RegisterForm />
        </div>
    );
}

export default Register;