package com.fraud.api.model;  // Updated package name

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    private double amount;
    private String location;
    private String ipAddress;
    private LocalDateTime timestamp;

    private boolean flaggedAsFraud = false;
    
    public boolean isFlaggedAsFraud() {
        return flaggedAsFraud;
    }

    
    public void setFlaggedAsFraud(boolean flaggedAsFraud) {
        this.flaggedAsFraud = flaggedAsFraud;
    }
   
    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
    
    public double getAmount() {
        return amount;
    }
    
    public Long getUserId() {
        return userId;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
    
    public String getIpAddress() {
        return ipAddress;
    }

}
