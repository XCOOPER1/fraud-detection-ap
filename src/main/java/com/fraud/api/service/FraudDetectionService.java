package com.fraud.api.service;

import java.time.Duration;
import java.util.List;

import org.springframework.stereotype.Service;

import com.fraud.api.model.Transaction;
import com.fraud.api.repository.TransactionRepository;

@Service
public class FraudDetectionService {
    private final TransactionRepository transactionRepository;

    public FraudDetectionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public boolean isFraudulent(Transaction transaction) {
        // Rule 1: Large transaction amount (over $5000)
        if (transaction.getAmount() > 5000) {
            return true;
        }

        // Rule 2: More than 3 transactions within 5 minutes
        List<Transaction> recentTransactions = transactionRepository.findByUserId(transaction.getUserId());
        long recentCount = recentTransactions.stream()
                .filter(t -> Duration.between(t.getTimestamp(), transaction.getTimestamp()).toMinutes() < 5)
                .count();
        if (recentCount >= 3) {
            return true;
        }

        // Rule 3: Transactions from different IPs in a short time
        boolean differentIPs = recentTransactions.stream()
                .anyMatch(t -> !t.getIpAddress().equals(transaction.getIpAddress())
                        && Duration.between(t.getTimestamp(), transaction.getTimestamp()).toMinutes() < 10);
        if (differentIPs) {
            return true;
        }

        return false;
    }
}
