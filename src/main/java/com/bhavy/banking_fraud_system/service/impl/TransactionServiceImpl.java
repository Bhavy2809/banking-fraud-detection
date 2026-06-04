package com.bhavy.banking_fraud_system.service.impl;
import com.bhavy.banking_fraud_system.service.FraudDetectionService;
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
    private final FraudDetectionService fraudDetectionService;
    @Override
    public void createTransaction(
            TransactionRequest request) {

        int fraudScore =
                fraudDetectionService.calculateFraudScore(
                        request.getAmount()
                );

        boolean isFraud =
                fraudDetectionService.isFraud(
                        request.getAmount()
                );

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
                        .fraudScore(fraudScore)
                        .isFraud(isFraud)
                        .status("SUCCESS")
                        .build();

        transactionRepository.save(transaction);
    }
}