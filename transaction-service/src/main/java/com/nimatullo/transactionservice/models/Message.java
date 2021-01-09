package com.nimatullo.transactionservice.models;

import java.util.UUID;

public class Message<T> {

    private final UUID messageId;
    private final T payload;

    public Message(UUID messageId, T payload) {
        this.messageId = messageId;
        this.payload = payload;
    }

    public UUID getMessageId() {
        return messageId;
    }

    public String getMessageType() {
        return this.getClass().getName();
    }

    public T getPayload() {
        return payload;
    }
}
