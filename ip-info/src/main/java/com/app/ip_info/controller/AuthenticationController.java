package com.app.ip_info.controller;

import com.app.ip_info.entity.User;
import com.app.ip_info.model.LoginRequest;
import com.app.ip_info.model.LoginResponse;
import com.app.ip_info.service.AuthenticationServiceImpl;
import com.app.ip_info.service.JwtService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/auth")
@RestController
@Slf4j
public class AuthenticationController {
    private final JwtService jwtService;

    private final AuthenticationServiceImpl authenticationService;

    public AuthenticationController(JwtService jwtService, AuthenticationServiceImpl authenticationService) {
        this.jwtService = jwtService;
        this.authenticationService = authenticationService;
    }


    @PostMapping("/login")
    public ResponseEntity<LoginResponse> authenticate(@RequestBody LoginRequest loginRequest) {
        log.info("Attempting to authenticate user: {}", loginRequest.getUsername());

        User authenticatedUser = authenticationService.authenticate(loginRequest);

        if (authenticatedUser != null) {
            String jwtToken = jwtService.generateToken(authenticatedUser);

            LoginResponse loginResponse = new LoginResponse()
                    .setToken(jwtToken)
                    .setExpiresIn(jwtService.getExpirationTime())
                    .setRole(authenticatedUser.getRole());

            log.info("Authentication successful. JWT Token: {}", jwtToken);

            return ResponseEntity.ok(loginResponse);
        } else {
            log.warn("Authentication failed for user: {}", loginRequest.getUsername());
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

}

