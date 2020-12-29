package com.nimatullo.transactionservice.dto;


import com.nimatullo.transactionservice.models.PaymentStatus;

import java.util.UUID;

public class PaymentResponse {
    private PaymentStatus status;
    private UUID orderId;

    public PaymentResponse() {
    }

    public PaymentResponse(PaymentStatus status, UUID orderId) {
        this.status = status;
        this.orderId = orderId;
    }

    public PaymentStatus getStatus() {
        return status;
    }

    public void setStatus(PaymentStatus status) {
        this.status = status;
    }

    public UUID getOrderId() {
        return orderId;
    }

    public void setOrderId(UUID orderId) {
        this.orderId = orderId;
    }
}
