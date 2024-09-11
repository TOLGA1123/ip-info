package com.app.ip_info;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//Use this to bcrypt admin password and insert admin manually to db
public class PasswordEncoder {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String rawPassword = "admin";
        String encodedPassword = encoder.encode(rawPassword);

        System.out.println("Encoded Password: " + encodedPassword);
    }
}