package com.Registration;

import java.util.Optional;
import java.security.NoSuchAlgorithmException;
import java.security.MessageDigest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ProfileManagement.springboot.UserProfileRepository;

@Service
public class RegistrationService { // figure out what to return

    private final RegistrationRepository registrationRepository;

    @Autowired
    public RegistrationService(RegistrationRepository registrationRepository) {
        this.registrationRepository = registrationRepository;
    }

    private String encryptPassword(String password) {
        String encryptedPassword = "";
        try {
            MessageDigest m = MessageDigest.getInstance("MD5");
            m.update(password.getBytes());
            byte[] bytes = m.digest();
            StringBuilder s = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                s.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            encryptedPassword = s.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return encryptedPassword;
    }

    public Boolean addNewAccount(Registration registration) {
        Optional<Registration> reg = registrationRepository.findById(registration.getuserName());
        if (reg.isPresent()) {
            return false; // return false if username is already in database
        }
        String encryptedPassword = encryptPassword(registration.getpassWord());
        registration.setpassWord(encryptedPassword);
        registrationRepository.save(registration);
        return true; // return true if username is not in database
    }

    public Boolean checkUsername(String user) {
        Optional<Registration> reg = registrationRepository.findById(user);
        if (reg.isPresent()) {
            return true;
        }
        return false;
    }

    public Boolean checkPassword(Registration registration) {
        Optional<Registration> reg = registrationRepository.findById(registration.getuserName());
        if (!reg.isPresent()) {
            return false;
        }
        Registration r = reg.get();
        String encryptedPassword = encryptPassword(registration.getpassWord());
        if (encryptedPassword.equals(r.getpassWord())) {
            return true;
        }
        return false;
    }
}
