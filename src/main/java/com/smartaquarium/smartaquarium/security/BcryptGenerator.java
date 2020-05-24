package com.smartaquarium.smartaquarium.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BcryptGenerator {
    private String hashedPassword;
    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public String passwordEncoder(String password)
    { return hashedPassword = passwordEncoder.encode(password);}

    public boolean isPasswordMatch(String password, String userPassword){
        return passwordEncoder.matches(password,userPassword);
    }
}
