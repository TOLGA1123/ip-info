package com.app.ip_info.exception;

import lombok.Getter;

@Getter
public class IpAddressNotFoundException extends RuntimeException {
    private final String errorCode;
    public IpAddressNotFoundException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

}
