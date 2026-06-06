package com.bhavy.banking_fraud_system.service;

import com.bhavy.banking_fraud_system.service.ml.MlPredictionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FraudDetectionService {

    private final MlPredictionService mlPredictionService;

    public int calculateFraudScore(Double amount) {

        double probability =
                mlPredictionService
                        .predictFraudProbability(amount);

        return (int)(probability * 100);
    }

    public boolean isFraud(Double amount) {

        return calculateFraudScore(amount) >= 80;
    }
}