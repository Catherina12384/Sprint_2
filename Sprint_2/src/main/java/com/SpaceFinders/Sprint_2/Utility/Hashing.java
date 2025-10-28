package com.SpaceFinders.Sprint_2.Utility;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;



public class Hashing{
     private static final PasswordEncoder encoder = new BCryptPasswordEncoder();
    public static String encryptPassword(String password){
        return encoder.encode(password);
    }

    public static boolean decryptPassword(String passwordEntered, String passwordHash){

        return encoder.matches(passwordEntered, passwordHash);
    }
}