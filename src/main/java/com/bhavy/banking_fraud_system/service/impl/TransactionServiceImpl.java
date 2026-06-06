package com.bhavy.banking_fraud_system.service.impl;
import com.bhavy.banking_fraud_system.service.FraudDetectionService;
import com.bhavy.banking_fraud_system.dto.TransactionRequest;
import com.bhavy.banking_fraud_system.entity.Transaction;
import com.bhavy.banking_fraud_system.repository.TransactionRepository;
import com.bhavy.banking_fraud_system.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.time.LocalDate;
import java.time.LocalDateTime;
import com.bhavy.banking_fraud_system.dto.DashboardResponse;
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
    public List<Transaction> getTodayTransactions() {

        LocalDateTime startOfDay =
                LocalDateTime.now()
                        .toLocalDate()
                        .atStartOfDay();

        return transactionRepository
                .findByTransactionTimeAfter(
                        startOfDay
                );
    }
    @Override
    public long getFraudTransactionsCount() {

        return transactionRepository.countByIsFraud(true);
    }
    @Override
    public DashboardResponse getDashboardStats() {

        long total =
                transactionRepository.count();

        long fraud =
                transactionRepository
                        .countByIsFraud(true);

        double percentage = 0;

        if(total > 0) {

            percentage =
                    ((double) fraud / total) * 100;
        }

        return new DashboardResponse(
                total,
                fraud,
                percentage
        );
    }
    @Override
    public double getFraudPercentage() {

        long total = transactionRepository.count();

        long fraud = getFraudTransactionsCount();

        if(total == 0) {
            return 0;
        }

        return ((double) fraud / total) * 100;
    }@Override
    public List<Transaction> getWeekTransactions() {

        LocalDateTime oneWeekAgo =
                LocalDateTime.now()
                        .minusDays(7);

        return transactionRepository
                .findByTransactionTimeAfter(
                        oneWeekAgo
                );
    }@Override
    public List<Transaction> getMonthTransactions() {

        LocalDateTime oneMonthAgo =
                LocalDateTime.now()
                        .minusDays(30);

        return transactionRepository
                .findByTransactionTimeAfter(
                        oneMonthAgo
                );
    }@Override
    public long getTodayFraudCount() {

        LocalDateTime startOfDay =
                LocalDate.now()
                        .atStartOfDay();

        return transactionRepository
                .findByIsFraudTrueAndTransactionTimeAfter(
                        startOfDay
                )
                .size();
    }@Override
    public long getWeekFraudCount() {

        LocalDateTime oneWeekAgo =
                LocalDateTime.now()
                        .minusDays(7);

        return transactionRepository
                .findByIsFraudTrueAndTransactionTimeAfter(
                        oneWeekAgo
                )
                .size();
    }@Override
    public long getMonthFraudCount() {

        LocalDateTime oneMonthAgo =
                LocalDateTime.now()
                        .minusDays(30);

        return transactionRepository
                .findByIsFraudTrueAndTransactionTimeAfter(
                        oneMonthAgo
                )
                .size();
    }
}