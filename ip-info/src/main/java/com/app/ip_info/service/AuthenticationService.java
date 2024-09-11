package com.app.ip_info.service;

import com.app.ip_info.entity.User;
import com.app.ip_info.model.LoginRequest;
import com.app.ip_info.model.RegisterRequest;
import com.app.ip_info.repository.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

public interface AuthenticationService {

    User signup(RegisterRequest input);

    User authenticate(LoginRequest input);

    List<User> getAllUsers();
}
