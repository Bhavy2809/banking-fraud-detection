package com.bhavy.banking_fraud_system.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "transactions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String senderAccount;

    private String receiverAccount;

    private Double amount;

    private LocalDateTime transactionTime;

    private Integer fraudScore;

    private Boolean isFraud;

    private String status;
}