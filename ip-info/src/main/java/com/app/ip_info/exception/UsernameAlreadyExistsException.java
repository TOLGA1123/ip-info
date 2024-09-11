package com.app.ip_info.exception;

import lombok.Getter;

@Getter
public class UsernameAlreadyExistsException extends RuntimeException {
    private final String errorCode;
    public UsernameAlreadyExistsException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
}