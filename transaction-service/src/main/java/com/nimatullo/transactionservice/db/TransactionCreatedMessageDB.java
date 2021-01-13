package com.nimatullo.transactionservice.db;

import com.nimatullo.transactionservice.dto.TransactionCreated;
import com.nimatullo.transactionservice.models.Message;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Component
public class TransactionCreatedMessageDB {
    private Map<UUID, TransactionCreated> messageMap;

    public TransactionCreatedMessageDB() {
        this.messageMap = new HashMap<>();
    }

    public TransactionCreated get(UUID id) {
        return messageMap.get(id);
    }

    public void add(Message<TransactionCreated> transactionCreatedMessage) {
       messageMap.put(transactionCreatedMessage.getMessageId(), transactionCreatedMessage.getPayload());
    }

}
