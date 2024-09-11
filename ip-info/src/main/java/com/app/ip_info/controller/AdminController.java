package com.app.ip_info.controller;

import com.app.ip_info.entity.User;
import com.app.ip_info.exception.UsernameAlreadyExistsException;
import com.app.ip_info.model.RegisterRequest;
import com.app.ip_info.service.AuthenticationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AuthenticationServiceImpl authenticationService;

    @PostMapping("/signup")
    public ResponseEntity<User> register(@RequestBody RegisterRequest registerRequest) {
        User registeredUser = authenticationService.signup(registerRequest);

        return ResponseEntity.ok(registeredUser);
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return authenticationService.getAllUsers();
    }
    @DeleteMapping("/users/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long userId) {
        authenticationService.deleteUserById(userId);
        return ResponseEntity.noContent().build();
    }
}
