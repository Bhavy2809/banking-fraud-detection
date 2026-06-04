package com.bhavy.banking_fraud_system.service.impl;
import com.bhavy.banking_fraud_system.service.FraudDetectionService;
import com.bhavy.banking_fraud_system.dto.TransactionRequest;
import com.bhavy.banking_fraud_system.entity.Transaction;
import com.bhavy.banking_fraud_system.repository.TransactionRepository;
import com.bhavy.banking_fraud_system.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
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
        System.out.println("REQUEST = " + request);
        System.out.println("AMOUNT = " + request.getAmount());
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
    @Override
    public List<Transaction> getFraudTransactions() {

        return transactionRepository
                .findByIsFraudTrue();
    }
    @Override
    public List<Transaction> getAllTransactions() {

        return transactionRepository.findAll();
    }@Override
    public long getTotalTransactions() {

        return transactionRepository.count();
    }

    @Override
    public long getFraudTransactionsCount() {

        return transactionRepository.countByIsFraud(true);
    }

    @Override
    public double getFraudPercentage() {

        long total = transactionRepository.count();

        long fraud = getFraudTransactionsCount();

        if(total == 0) {
            return 0;
        }

        return ((double) fraud / total) * 100;
    }
}