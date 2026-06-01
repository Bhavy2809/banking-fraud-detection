package com.bhavy.banking_fraud_system.service.impl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.bhavy.banking_fraud_system.service.AuthService;
import com.bhavy.banking_fraud_system.dto.RegisterRequest;import com.bhavy.banking_fraud_system.repository.UserRepository;import com.bhavy.banking_fraud_system.entity.User;
import com.bhavy.banking_fraud_system.entity.Role;
import java.time.LocalDateTime;
@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;

    @Override
    public void register(RegisterRequest request) {

        if(userRepository.findByEmail(request.getEmail()).isPresent()){
            throw new RuntimeException("Email already exists");
        }

        User user = User.builder()
                .fullName(request.getFullName())
                .email(request.getEmail())
                .password(request.getPassword())
                .role(Role.USER)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();

        userRepository.save(user);
    }
}