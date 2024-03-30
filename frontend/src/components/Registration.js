import React, { useState, useEffect } from 'react';
import { useNavigate } from 'react-router-dom';
import { Link } from 'react-router-dom';
import './Registration.css'

function UserTaken({takenUser, submitted}){
    if(!submitted){
        return;
    }
    else if(takenUser){
        return <p className='incorrectText'>Username already taken; Please try again</p>;
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
        return <p className='incorrectText'>Passwords do not match; Please try again</p>;
    }  
}

function RegisterForm({userCredentials, setUserCredentials}){
    const [userName, setUsername] = useState('');
    const [passWord, setPassword] = useState('');
    const [vfyPassword, setVfyPassword] = useState('');
    const [matchPass, setMatchPass] = useState(false);
    const [submitPressed, setSubmitted] = useState(false);
    const [userDoesExist, setUserDoesExist] = useState(false);
    let userExists = false;
    const navigate = useNavigate()

    function match(){
        if(passWord === vfyPassword){
            setMatchPass(true);
            navigate('/login')
        }
        else{
            setPassword('');
            setVfyPassword('');
            setMatchPass(false);
        }
    }

    return(
        <form className='registrationForm' onSubmit={ async e => {
            e.preventDefault();
            setSubmitted(true);
            const registrationInfo = {
                userName,
                passWord,
                vfyPassword,
                userExists
            };
            try{
                const res = await fetch('/api/v1/Registration', {
                    method: 'POST',
                    headers: {
                        'Content-Type': 'application/json'
                    },
                    body: JSON.stringify(registrationInfo),
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
                const res2 = await fetch('/api/v1/Registration')
                if(!res2.ok){
                    throw(Error(res2.statusText));
                }
                const data = await res2.json();  
                console.log(data);
                userExists = data.userExists;
                setUserDoesExist(userExists);
            }
            catch(error){
                console.error(error);
                console.error('fetch request unsuccessful!')
            }
            if(!userExists){
                match();
            }
        }}>
            <p className='user'> <b>Username</b> </p>
            <input className='registrationInput' type='text' placeholder='Username' value={userName} onChange={e => setUsername(e.target.value)} required/>
            <UserTaken takenUser={userDoesExist} submitted={submitPressed}/>
            <p className='pass'><b>Password</b></p> 
            <input className='registrationInput' type='text' placeholder='Password' value={passWord} onChange={e => setPassword(e.target.value)} required/>
            <p className='rePass'><b>Re-enter Password</b></p> 
            <input className='registrationInput' type='text' placeholder='Re-enter Password' value={vfyPassword} onChange={e => setVfyPassword(e.target.value)} required/>
            <PasswordVerify takenUser={userDoesExist} matched={matchPass} submitted={submitPressed} />
            <button className='registrationButton' type='submit'>Register</button> 
            <a href='/Login' className='loginLink'>Return to Login</a>

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