package com.nimatullo.transactionservice.models;

import java.util.UUID;

public class Transaction {
    private UUID transactionId;
    private TransactionStatus status;
    private GraphicsCard itemBought;
    private String creditCardNumber;

    public Transaction(UUID transactionId, TransactionStatus status, GraphicsCard itemBought, String creditCardNumber) {
        this.transactionId = transactionId;
        this.status = status;
        this.itemBought = itemBought;
        this.creditCardNumber = creditCardNumber;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
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

    public GraphicsCard getItemBought() {
        return itemBought;
    }

    public void setItemBought(GraphicsCard itemBought) {
        this.itemBought = itemBought;
    }
}
