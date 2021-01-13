package com.nimatullo.paymentservice.dto;

import com.nimatullo.paymentservice.model.TransactionStatus;

import java.util.UUID;

public class PaymentAuthorizationRequest {
    private UUID transactionId;
    private TransactionStatus status;
    private String creditCardNumber;
    private double transactionTotal;

    public PaymentAuthorizationRequest() {
    }

    public PaymentAuthorizationRequest(UUID transactionId, TransactionStatus status, String creditCardNumber, double transactionTotal) {
        this.transactionId = transactionId;
        this.status = status;
        this.creditCardNumber = creditCardNumber;
        this.transactionTotal = transactionTotal;
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
}
