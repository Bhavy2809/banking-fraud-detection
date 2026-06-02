package com.bhavy.banking_fraud_system.service;
import com.bhavy.banking_fraud_system.dto.LoginRequest;
import com.bhavy.banking_fraud_system.dto.AuthResponse;

import com.bhavy.banking_fraud_system.dto.RegisterRequest;

public interface AuthService {

    void register(RegisterRequest request);

    AuthResponse login(LoginRequest request);
}