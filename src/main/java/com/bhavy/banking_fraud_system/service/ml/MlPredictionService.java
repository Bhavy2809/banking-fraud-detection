package com.bhavy.banking_fraud_system.service.ml;

import org.springframework.stereotype.Service;

@Service
public class MlPredictionService {

    public double predictFraudProbability(
            Double amount) {

        if(amount > 100000)
            return 0.95;

        if(amount > 50000)
            return 0.60;

        return 0.10;
    }
}