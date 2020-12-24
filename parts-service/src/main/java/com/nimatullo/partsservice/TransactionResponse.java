package com.nimatullo.partsservice;

import com.nimatullo.partsservice.models.TransactionStatus;

import java.util.UUID;

public class TransactionResponse {
    private UUID transactionId;
    private TransactionStatus status;

    public TransactionResponse() {
    }

    public TransactionResponse(UUID transactionId, TransactionStatus status) {
        this.transactionId = transactionId;
        this.status = status;
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
