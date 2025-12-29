package com.creativefitness.gymapp.service;

import com.creativefitness.gymapp.dto.AuthRequest;
import com.creativefitness.gymapp.dto.AuthResponse;
import com.creativefitness.gymapp.dto.RegisterRequest;
import com.creativefitness.gymapp.model.Role;
import com.creativefitness.gymapp.model.User;
import com.creativefitness.gymapp.repository.UserRepository;
import com.creativefitness.gymapp.security.JwtUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtils jwtUtils;
    private final AuthenticationManager authenticationManager;

    public AuthResponse register(RegisterRequest request) {
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email already exists");
        }
        var user = User.builder()
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(request.getRole() != null ? request.getRole() : Role.MEMBER)
                .build();
        userRepository.save(user);
        var jwtToken = jwtUtils.generateToken(user);
        return AuthResponse.builder().token(jwtToken).message("User registered successfully").build();
    }

    public AuthResponse authenticate(AuthRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        var user = userRepository.findByEmail(request.getEmail()).orElseThrow();
        var jwtToken = jwtUtils.generateToken(user);
        return AuthResponse.builder().token(jwtToken).message("Login successful").build();
    }
}
