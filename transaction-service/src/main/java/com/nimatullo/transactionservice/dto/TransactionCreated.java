package com.nimatullo.transactionservice.dto;

import com.nimatullo.transactionservice.models.TransactionStatus;

import java.time.LocalDate;
import java.util.UUID;

public class TransactionCreated {
    private UUID transactionId;
    private TransactionStatus status;
    private LocalDate timeOfTransaction;
    private String creditCardNumber;
    private double transactionTotal;

    public TransactionCreated() {
    }

    public TransactionCreated(UUID transactionId, TransactionStatus status, String creditCardNumber, double transactionTotal) {
        this.transactionId = transactionId;
        this.status = status;
        this.timeOfTransaction = LocalDate.now();
        this.creditCardNumber = creditCardNumber;
        this.transactionTotal = transactionTotal;
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

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public double getTransactionTotal() {
        return transactionTotal;
    }

    public void setTransactionTotal(double transactionTotal) {
        this.transactionTotal = transactionTotal;
    }

    public void setTimeOfTransaction(LocalDate timeOfTransaction) {
        this.timeOfTransaction = timeOfTransaction;
    }
}
