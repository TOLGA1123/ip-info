package com.app.ip_info.exception;

import lombok.Getter;

@Getter
public class IpAddressAlreadyExistsException extends RuntimeException {
    private final String errorCode;
    public IpAddressAlreadyExistsException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

}
