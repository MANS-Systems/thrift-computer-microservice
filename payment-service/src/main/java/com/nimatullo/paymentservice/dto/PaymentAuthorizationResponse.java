package com.nimatullo.paymentservice.dto;

import com.nimatullo.paymentservice.model.PaymentStatus;

import java.util.UUID;


public class PaymentAuthorizationResponse {
    private UUID transactionId;
    private PaymentStatus status;

    public PaymentAuthorizationResponse(UUID transactionId, PaymentStatus status) {
        this.status = status;
        this.transactionId = transactionId;
    }

    public UUID getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(UUID transactionId) {
        this.transactionId = transactionId;
    }

    public PaymentStatus getStatus() {
        return status;
    }

    public void setStatus(PaymentStatus status) {
        this.status = status;
    }
}
