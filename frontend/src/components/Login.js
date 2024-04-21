import React, { useState } from 'react';
import './Login.css'
import { useNavigate } from "react-router-dom";


function LoginForm({}){
    const [userName, setUsername] = useState('');
    const [passWord, setPassword] = useState('');
    const [submitPressed, setSubmitted] = useState(false);
    const [passCorrect, setPassCorrect] = useState(true);
    let userExists = false;
    let correctPass = false;
    const navigate = useNavigate();

    function MatchedPass({correctPassword, submitted}){
        if(!submitted){
            return;
        }
        if(!correctPassword){
            return <p className='incorrectText'>Incorrect password; Please try again</p>
        }
    }

    function completeLogin(){
        if(userExists){
            if(correctPass){
                setPassCorrect(true);
                sessionStorage.setItem("username", userName);
                sessionStorage.setItem("auth", true);
                navigate('/profile');
            }
            else{
                setPassCorrect(false);
                setPassword('');
            }
        }
        else if(!correctPass){
            setPassCorrect(false);
            setPassword('');
        }
    }

    return(
        <form className='loginForm' onSubmit={async e => {
            e.preventDefault();
            setSubmitted(true);
            const loginInfo = {
                userName,
                passWord,
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
                const data = await res.json();
                userExists = data[0];
                correctPass = data[1];
            }
            catch(error){
                console.error(error);
                console.error('fetch request unsuccessful!')
            }
            
            completeLogin();
        }}>
            <p><b>Username</b></p> 
            <input className='loginInput' type='text' placeholder='Username' value={userName} onChange={e => setUsername(e.target.value)} required/>
            <p><b>Password</b> </p>
            <input className='loginInput' type='password' placeholder='Password' value={passWord} onChange={e => setPassword(e.target.value)} required/>
            <MatchedPass correctPassword={passCorrect} submitted={submitPressed}/>
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