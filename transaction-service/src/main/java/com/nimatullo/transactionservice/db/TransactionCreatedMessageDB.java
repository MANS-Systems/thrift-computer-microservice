package com.nimatullo.transactionservice.db;

import com.nimatullo.transactionservice.dto.PaymentAuthorizationRequest;
import com.nimatullo.transactionservice.models.Message;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Component
public class TransactionCreatedMessageDB {
    private Map<UUID, PaymentAuthorizationRequest> messageMap;

    public TransactionCreatedMessageDB() {
        this.messageMap = new HashMap<>();
    }

    public PaymentAuthorizationRequest get(UUID id) {
        return messageMap.get(id);
    }

    public void add(Message<PaymentAuthorizationRequest> transactionCreatedMessage) {
       messageMap.put(transactionCreatedMessage.getMessageId(), transactionCreatedMessage.getPayload());
    }

}
