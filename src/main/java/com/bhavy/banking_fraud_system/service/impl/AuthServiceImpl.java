package com.bhavy.banking_fraud_system.service.impl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.bhavy.banking_fraud_system.service.AuthService;
import com.bhavy.banking_fraud_system.dto.RegisterRequest;import com.bhavy.banking_fraud_system.repository.UserRepository;import com.bhavy.banking_fraud_system.entity.User;
import com.bhavy.banking_fraud_system.entity.Role;
import java.time.LocalDateTime;import org.springframework.security.crypto.password.PasswordEncoder;import com.bhavy.banking_fraud_system.dto.LoginRequest;
import com.bhavy.banking_fraud_system.dto.AuthResponse;
@RequiredArgsConstructor
@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    @Override
    public AuthResponse login(LoginRequest request) {

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() ->
                        new RuntimeException("User not found"));

        if (!passwordEncoder.matches(
                request.getPassword(),
                user.getPassword())) {

            throw new RuntimeException("Invalid password");
        }

        return new AuthResponse("Login Successful");
    }
    @Override
    public void register(RegisterRequest request) {

        if(userRepository.findByEmail(request.getEmail()).isPresent()){
            throw new RuntimeException("Email already exists");
        }

        User user = User.builder()
                .fullName(request.getFullName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();

        userRepository.save(user);
    }
}