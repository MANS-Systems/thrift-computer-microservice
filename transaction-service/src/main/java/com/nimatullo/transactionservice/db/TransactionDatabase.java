package com.nimatullo.transactionservice.db;

import com.nimatullo.transactionservice.models.Transaction;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Component
public class TransactionDatabase {
    private Map<UUID, Transaction> transactionMap;

    public TransactionDatabase() {
        this.transactionMap = new HashMap<>();
    }

    public Transaction get(UUID id) {
        return transactionMap.get(id);
    }

    public void add(UUID id, Transaction transaction) {
        transactionMap.put(id, transaction);
    }
}
