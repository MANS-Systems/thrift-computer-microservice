package com.nimatullo.transactionservice.dto;

import com.nimatullo.transactionservice.models.TransactionStatus;

import java.time.LocalDate;
import java.util.UUID;

public class TransactionCreated {
    private UUID transactionId;
    private TransactionStatus status;
    private LocalDate timeOfTransaction;

    public TransactionCreated(UUID transactionId, TransactionStatus status) {
        this.transactionId = transactionId;
        this.status = status;
        this.timeOfTransaction = LocalDate.now();
    }

    public UUID getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(UUID transactionId) {
        this.transactionId = transactionId;
    }

    public TransactionStatus getStatus() {
        return status;
    }

    public void setStatus(TransactionStatus status) {
        this.status = status;
    }

    public LocalDate getTimeOfTransaction() {
        return timeOfTransaction;
    }

    public void setTimeOfTransaction(LocalDate timeOfTransaction) {
        this.timeOfTransaction = timeOfTransaction;
    }
}
