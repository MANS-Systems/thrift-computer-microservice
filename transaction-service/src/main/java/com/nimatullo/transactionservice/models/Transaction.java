package com.nimatullo.transactionservice.models;

import java.util.UUID;

public class Transaction {
    private UUID transactionId;
    private TransactionStatus status;
    private GraphicsCard itemBought;

    public Transaction(UUID transactionId, TransactionStatus status, GraphicsCard itemBought) {
        this.transactionId = transactionId;
        this.status = status;
        this.itemBought = itemBought;
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
