import React, { useState } from 'react';
import './Login.css'


function MatchedUser({userExist, submitted}){
    if(!submitted){
        return;
    }
    if(!userExist){
        return <p className='incorrectText'>User not found; Please try again</p>
    }
}

function MatchedPass({userExist, correctPassword, submitted}){
    if(!submitted){
        return;
    }
    if(!userExist){
        return;
    }
    if(!correctPassword){
        return <p className='incorrectText'>Incorrect password; Please try again</p>
    }
}


function LoginForm({userCredentials}){
    const [userName, setUsername] = useState('');
    const [passWord, setPassword] = useState('');
    const [userExists, setUserExists] = useState(false);
    const [correctPass, setCorrectPass] = useState(false);
    const [submitPressed, setSubmitted] = useState(false);
    let existingUser = false;
    let correctPassword = false;

    function verification(){
        if(userName === 'Adam'){
            existingUser = true;
            setUserExists(existingUser);
        }
        else{
            existingUser = false;
            setUserExists(existingUser);
        }
        if(passWord === 'Yes'){
            correctPassword = true;
            setCorrectPass(correctPassword);
        }
        else{
            correctPassword = false;
            setCorrectPass(correctPassword);
        }
    }

    function completeLogin(){
        if(existingUser){
            if(correctPassword){
                alert('Login complete!'); {/* LINKPROFILE MANAGEMENT */}
            }
            else{
                setPassword('');
            }
        }
        else if(!correctPassword){
            setPassword('');
        }
    }


    return(
        <form className='loginForm' onSubmit={e => {
            e.preventDefault();
            setSubmitted(true);
            verification();
            completeLogin();
        }}>
            <p><b>Username</b></p> 
            <input className='loginInput' type='text' placeholder='Username' value={userName} onChange={e => setUsername(e.target.value)} required/>
            <MatchedUser userExist={userExists} submitted={submitPressed}/>
            <p><b>Password</b> </p>
            <input className='loginInput' type='password' placeholder='Password' value={passWord} onChange={e => setPassword(e.target.value)} required/>
            <MatchedPass userExist={userExists} correctPassword={correctPass} submitted={submitPressed}/>
            <p><button className='loginButton' type='submit'>Login</button> <a href='/registration' className='registrationLink'>Create Account</a></p>
        </form>
    );
}

function Login(){
    return (
        <div>
            <h1 className='loginHeader'>Login</h1>
            <LoginForm />
        </div>
    );
}

export default Login;