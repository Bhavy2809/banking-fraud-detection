package com.bhavy.banking_fraud_system.service;

import org.springframework.stereotype.Service;

@Service
public class FraudDetectionService {

    public int calculateFraudScore(Double amount) {

        if(amount > 100000) {
            return 90;
        }

        if(amount > 50000) {
            return 60;
        }

        return 10;
    }

    public boolean isFraud(Double amount) {

        return calculateFraudScore(amount) >= 80;
    }
}