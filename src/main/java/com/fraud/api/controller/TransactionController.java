package com.fraud.api.controller;

import com.fraud.api.model.Transaction;
import com.fraud.api.repository.TransactionRepository;
import com.fraud.api.service.FraudDetectionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    private final TransactionRepository transactionRepository;
    private final FraudDetectionService fraudDetectionService;

    public TransactionController(TransactionRepository transactionRepository, FraudDetectionService fraudDetectionService) {
        this.transactionRepository = transactionRepository;
        this.fraudDetectionService = fraudDetectionService;
    }

    // POST mapping to submit a transaction
    @PostMapping
    public ResponseEntity<String> submitTransaction(@RequestBody Transaction transaction) {
        transaction.setTimestamp(LocalDateTime.now());

        boolean isFraud = fraudDetectionService.isFraudulent(transaction);
        transaction.setFlaggedAsFraud(isFraud);

        transactionRepository.save(transaction);

        if (isFraud) {
            return ResponseEntity.ok("Transaction flagged as fraud!");
        }
        return ResponseEntity.ok("Transaction processed successfully.");
    }

    // GET mapping to retrieve transactions by userId
    @GetMapping("/{userId}")
    public List<Transaction> getUserTransactions(@PathVariable Long userId) {
        return transactionRepository.findByUserId(userId);
    }
}
