import React, { useState } from 'react';
import './Login.css'
import { useNavigate } from "react-router-dom";


function MatchedUser({userExist, submitted}){
    if(!submitted){
        return;
    }
    if(!userExist){
        return <p className='incorrectText'>User not found; Please try again</p>
    }
    else{
        return;
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
    const [submitPressed, setSubmitted] = useState(false);
    const [userDoesExist, setUserDoesExist] = useState(false);
    const [passCorrect, setPassCorrect] = useState(false);
    let userExists = false;
    let correctPass = false;
    const navigate = useNavigate();

    // function verification(){
    //     if(userName === 'Adam'){
    //         existingUser = true;
    //         setUserExists(existingUser);
    //     }
    //     else{
    //         existingUser = false;
    //         setUserExists(existingUser);
    //     }
    //     if(passWord === 'Yes'){
    //         correctPassword = true;
    //         setCorrectPass(correctPassword);
    //     }
    //     else{
    //         correctPassword = false;
    //         setCorrectPass(correctPassword);
    //     }
    // }

    function completeLogin(){
        if(userExists){
            if(correctPass){
                navigate('/profile');
            }
            else{
                setPassword('');
            }
        }
        else if(!correctPass){
            setPassword('');
        }
    }


    return(
        <form className='loginForm' onSubmit={async e => {
            e.preventDefault();
            setSubmitted(true);
            //verification();
            const loginInfo = {
                userName,
                passWord,
                userExists,
                correctPass
            };
            try{
                const res = await fetch('/api/v1/Login', {
                    method: 'POST',
                    headers: {
                        'Content-Type': 'application/json'
                    },
                    body: JSON.stringify(loginInfo),
                    }
                );
                if(!res.ok){
                    throw(Error(res.statusText));
                }
            }
            catch(error){
                console.error(error);
                console.error('fetch request unsuccessful!')
            }
            try{  //preparing for a get request from the database
                const res2 = await fetch('/api/v1/Login')
                if(!res2.ok){
                    throw(Error(res2.statusText));
                }
                const data = await res2.json();  
                console.log(data);
                userExists = data.userExists;
                correctPass = data.correctPass;
                setUserDoesExist(userExists);
                setPassCorrect(correctPass);
            }
            catch(error){
                console.error(error);
                console.error('fetch request unsuccessful!')
            }
            completeLogin();
        }}>
            <p><b>Username</b></p> 
            <input className='loginInput' type='text' placeholder='Username' value={userName} onChange={e => setUsername(e.target.value)} required/>
            <MatchedUser userExist={userDoesExist} submitted={submitPressed}/>
            <p><b>Password</b> </p>
            <input className='loginInput' type='password' placeholder='Password' value={passWord} onChange={e => setPassword(e.target.value)} required/>
            <MatchedPass userExist={userDoesExist} correctPassword={passCorrect} submitted={submitPressed}/>
            <button className='loginButton' type='submit'>Login</button>
            <a href='/registration' className='registrationLink'>Create Account</a>
            
            
            
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