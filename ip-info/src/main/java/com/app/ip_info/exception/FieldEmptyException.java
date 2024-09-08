package com.app.ip_info.exception;

import lombok.Getter;

@Getter
public class FieldEmptyException extends RuntimeException {
    private final String errorCode;
    public FieldEmptyException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

}
