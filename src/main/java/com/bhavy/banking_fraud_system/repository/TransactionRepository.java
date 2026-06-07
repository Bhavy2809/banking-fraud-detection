package com.bhavy.banking_fraud_system.repository;
import java.time.LocalDateTime;
import java.util.List;
import com.bhavy.banking_fraud_system.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import org.springframework.stereotype.Repository;import org.springframework.data.domain.Pageable;
@Repository
public interface TransactionRepository
        extends JpaRepository<Transaction, Long> {

    List<Transaction> findByIsFraudTrue();
    List<Transaction> findByOrderByFraudScoreDesc(Pageable pageable);
    long countByIsFraud(boolean isFraud);

    List<Transaction> findByTransactionTimeAfter(
            LocalDateTime dateTime
    );
    List<Transaction> findTop5ByIsFraudTrueOrderByTransactionTimeDesc();
    List<Transaction> findByIsFraudTrueAndTransactionTimeAfter(
            LocalDateTime dateTime
    );
}