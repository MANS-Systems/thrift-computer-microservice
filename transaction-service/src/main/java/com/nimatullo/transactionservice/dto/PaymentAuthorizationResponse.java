package com.nimatullo.transactionservice.dto;


import com.nimatullo.transactionservice.models.PaymentStatus;

import java.util.UUID;

public class PaymentAuthorizationResponse {
    private UUID transactionId;
    private PaymentStatus status;

    public PaymentAuthorizationResponse(PaymentStatus status, UUID transactionId) {
        this.transactionId = transactionId;
        this.status = status;
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
