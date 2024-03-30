// import ProfileForm from "../components/ProfileForm";
// import tunnel from "../images/tunnel.jpg"

// const Profile = () => {
//     return (
//         <div>
//             <ProfileForm/>
//         </div>
//     )
// }

// export default Profile

// Profile.js
import React, { useState } from 'react';
import ProfileForm from '../components/ProfileForm'; // Update the path to ProfileForm if necessary

function Profile() {
  // Initialize userProfile state
  const [userProfile, setUserProfile] = useState({
    fullName: '',
    address1: '',
    address2: '',
    city: '',
    state: '',
    zipcode: ''
  });

  // Define a function to update userProfile state
  const updateUserProfile = (updatedProfile) => {
    setUserProfile(updatedProfile);
  };

  return (
    <div>
      <h1>Profile Page</h1>
      {/* Pass userProfile and updateUserProfile as props to ProfileForm */}
      <ProfileForm userProfile={userProfile} setUserProfile={updateUserProfile} />
    </div>
  );
}

export default Profile;
