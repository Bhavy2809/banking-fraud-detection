package com.bhavy.banking_fraud_system.service.impl;

import com.bhavy.banking_fraud_system.dto.TransactionRequest;
import com.bhavy.banking_fraud_system.entity.Transaction;
import com.bhavy.banking_fraud_system.repository.TransactionRepository;
import com.bhavy.banking_fraud_system.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl
        implements TransactionService {

    private final TransactionRepository transactionRepository;

    @Override
    public void createTransaction(
            TransactionRequest request) {

        Transaction transaction =
                Transaction.builder()
                        .senderAccount(
                                request.getSenderAccount()
                        )
                        .receiverAccount(
                                request.getReceiverAccount()
                        )
                        .amount(
                                request.getAmount()
                        )
                        .transactionTime(
                                LocalDateTime.now()
                        )
                        .fraudScore(0.0)
                        .isFraud(false)
                        .status("SUCCESS")
                        .build();

        transactionRepository.save(transaction);
    }
}