// ProfileForm.js
import React, { useState } from 'react';

function ProfileForm({ userProfile, setUserProfile }) {
  const [fullName, setFullName] = useState('');
  const [address1, setAddress1] = useState('');
  const [address2, setAddress2] = useState('');
  const [city, setCity] = useState('');
  const [state, setState] = useState('');
  const [zipcode, setZipcode] = useState('');

  const handleSubmit = async (e) => {
    e.preventDefault();

    const updatedUserProfile = {
      ...userProfile,
      profileCompleted: true,
      fullName,
      address1,
      address2,
      city,
      state,
      zipcode
    };

    try {
      const response = await fetch('http://localhost:8080/api/profile/update', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify(updatedUserProfile),
      });

      if (response.ok) {
        alert('Profile updated successfully');
        setUserProfile(updatedUserProfile);
      } else {
        const errorData = await response.json();
        alert('Error updating profile: ' + errorData.message);
      }
    } catch (error) {
      console.error('Error updating profile:', error);
      alert('Error updating profile. Please try again later.');
    }
  };

  const usStates = [
    'AL', 'AK', 'AZ', 'AR', 'CA', 'CO', 'CT', 'DE', 'FL', 'GA', 'HI', 'ID', 'IL', 'IN', 'IA', 'KS', 'KY', 'LA',
    'ME', 'MD', 'MA', 'MI', 'MN', 'MS', 'MO', 'MT', 'NE', 'NV', 'NH', 'NJ', 'NM', 'NY', 'NC', 'ND', 'OH', 'OK',
    'OR', 'PA', 'RI', 'SC', 'SD', 'TN', 'TX', 'UT', 'VT', 'VA', 'WA', 'WV', 'WI', 'WY'
  ];
  
  return (
    <div className='clientManagement'>
      <h1>Client Management</h1>
      <h2>Complete Your Profile</h2>
      <form onSubmit={handleSubmit}>
        <input type="text" placeholder="Full Name (50 Character Limit)" value={fullName} onChange={(e) => setFullName(e.target.value)} maxLength = {50} required />
        <input type="text" placeholder="Address 1 (100 Character Limit)" value={address1} onChange={(e) => setAddress1(e.target.value)} maxLength = {100} required />
        <input type="text" placeholder="Address 2 (100 Character Limit)" value={address2} onChange={(e) => setAddress2(e.target.value)} maxLength = {100} />
        <input type="text" placeholder="City (100 Character Limit)" value={city} onChange={(e) => setCity(e.target.value)} maxLength = {100} required />
        <select value={state} placeholder = "State" onChange={(e) => setState(e.target.value)} required>
          <option value="">Select State</option>
          {usStates.map((state) => (
            <option key={state} value={state}>{state}</option>
          ))}
        </select>
        <input type="text" placeholder="Zipcode (Min 5, 9 Max Character), Digits only" value={zipcode} onChange={(e) => setZipcode(e.target.value)} pattern="[0-9]{5,9}" minLength = {5} maxLength = {9} required 
        onKeyPress={(e) => {
          const isDigit = /^\d$/.test(e.key);
          if(!isDigit){
            e.preventDefault();
          }
        }}/>
        <button type="submit">Save</button>
      </form>
    </div>
  );
}

export default ProfileForm;