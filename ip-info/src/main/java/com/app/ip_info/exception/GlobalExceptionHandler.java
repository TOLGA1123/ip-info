package com.app.ip_info.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(IpAddressNotFoundException.class)
    @ResponseBody
    public ResponseEntity<String> handleIpAddressNotFoundException(IpAddressNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(IpAddressAlreadyExistsException.class)
    @ResponseBody
    public ResponseEntity<String> handleIpAddressAlreadyExistsException(IpAddressAlreadyExistsException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.CONFLICT);
    }
    @ExceptionHandler(FieldEmptyException.class)
    @ResponseBody
    public ResponseEntity<String> handleFieldEmptyException(FieldEmptyException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseEntity<String> handleGeneralException(Exception ex) {
        return new ResponseEntity<>("An error occurred: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(UsernameAlreadyExistsException.class)
    public ResponseEntity<String> handleUsernameAlreadyExistsException(UsernameAlreadyExistsException ex) {
        // Return a meaningful error message and status code
        return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
    }
}
