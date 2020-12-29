package com.nimatullo.transactionservice.db;

import com.nimatullo.transactionservice.dto.TransactionCreatedEvent;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Component
public class TransactionEventDatabase {
    private Map<UUID, TransactionCreatedEvent> eventsMap;

    public TransactionEventDatabase() {
        this.eventsMap = new HashMap<>();
    }

    public TransactionCreatedEvent get(UUID id) {
        return eventsMap.get(id);
    }

    public void add(UUID id, TransactionCreatedEvent event) {
       eventsMap.put(id, event);
    }

}
