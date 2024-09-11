package com.app.ip_info.service;


import com.app.ip_info.entity.User;
import com.app.ip_info.exception.UsernameAlreadyExistsException;
import com.app.ip_info.model.LoginRequest;
import com.app.ip_info.model.RegisterRequest;
import com.app.ip_info.model.Role;
import com.app.ip_info.repository.UserRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Log4j2
public class AuthenticationServiceImpl implements AuthenticationService{

    @Autowired
    private  UserRepository userRepository;
    @Autowired
    private  PasswordEncoder passwordEncoder;
    @Autowired
    private  AuthenticationManager authenticationManager;


    @Override
    public User signup(RegisterRequest input) {
        Optional<User> existingUser = userRepository.findByUsername(input.getUsername());
        log.info("User found: {}", existingUser);
        if (existingUser.isPresent()) {
            throw new UsernameAlreadyExistsException("Username already exists: " + input.getUsername(), "USERNAME_ALREADY_EXISTS");
        }
        User user = User.builder()
                .username(input.getUsername())
                .password(passwordEncoder.encode(input.getPassword()))
                .role(Role.valueOf("USER"))
                .build();


        return userRepository.save(user);
    }
    @Override
    public User authenticate(LoginRequest input) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        input.getUsername(),
                        input.getPassword()
                )
        );

        return userRepository.findByUsername(input.getUsername())
                .orElseThrow();
    }

    @Override
    public List<User> getAllUsers() {
        try {
            return userRepository.findAll();
        } catch (Exception e) {
            log.error("Error fetching users", e);
            throw e;
        }
    }

    @Override
    public void deleteUserById(Long userId) {
        userRepository.deleteById(userId);
    }
}