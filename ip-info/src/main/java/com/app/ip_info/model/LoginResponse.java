package com.app.ip_info.model;

import lombok.*;

public class LoginResponse {
    private String token;
    private Long expiresIn;

    public LoginResponse setToken(String token) {
        this.token = token;
        return this;
    }

    public LoginResponse setExpiresIn(Long expiresIn) {
        this.expiresIn = expiresIn;
        return this;
    }

    // Getter methods
    public String getToken() {
        return token;
    }

    public Long getExpiresIn() {
        return expiresIn;
    }
}