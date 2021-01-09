package com.nimatullo.transactionservice.db;

import com.nimatullo.transactionservice.dto.TransactionCreated;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Component
public class TransactionEventDatabase {
    private Map<UUID, TransactionCreated> eventsMap;

    public TransactionEventDatabase() {
        this.eventsMap = new HashMap<>();
    }

    public TransactionCreated get(UUID id) {
        return eventsMap.get(id);
    }

    public void add(UUID id, TransactionCreated event) {
       eventsMap.put(id, event);
    }

}
