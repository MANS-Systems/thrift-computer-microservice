package com.nimatullo.paymentservice.dto;

import com.nimatullo.paymentservice.model.PaymentStatus;

import java.util.UUID;

public class PaymentResponse {
    private PaymentStatus status;
    private UUID orderId;

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
