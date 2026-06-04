package com.bhavy.banking_fraud_system.service;

import com.bhavy.banking_fraud_system.dto.TransactionRequest;
import java.util.List;
import com.bhavy.banking_fraud_system.entity.Transaction;
public interface TransactionService {

    void createTransaction(
            TransactionRequest request
    );

    List<Transaction> getAllTransactions();

    List<Transaction> getFraudTransactions();
}