package com.bhavy.banking_fraud_system.service;

import com.bhavy.banking_fraud_system.dto.TransactionRequest;

public interface TransactionService {

    void createTransaction(TransactionRequest request);
}