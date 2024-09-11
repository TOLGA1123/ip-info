package com.app.ip_info.model;

import lombok.*;

@Getter
public class LoginResponse {
    // Getter methods
    private String token;
    private Long expiresIn;
    private Role role;

    public LoginResponse setToken(String token) {
        this.token = token;
        return this;
    }

    public LoginResponse setExpiresIn(Long expiresIn) {
        this.expiresIn = expiresIn;
        return this;
    }
    public LoginResponse setRole(Role role) {
        this.role = role;
        return this;
    }

}