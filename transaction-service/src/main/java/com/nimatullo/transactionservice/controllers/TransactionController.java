package com.nimatullo.transactionservice.controllers;

import com.nimatullo.transactionservice.db.TransactionDatabase;
import com.nimatullo.transactionservice.db.TransactionEventDatabase;
import com.nimatullo.transactionservice.dto.TransactionCreatedEvent;
import com.nimatullo.transactionservice.models.GraphicsCard;
import com.nimatullo.transactionservice.models.Transaction;
import com.nimatullo.transactionservice.models.TransactionStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.UUID;

@RestController
public class TransactionController {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private TransactionEventDatabase transactionEventDatabase;

    @Autowired
    private TransactionDatabase transactionDatabase;

    @Autowired
    private KafkaTemplate<String, TransactionCreatedEvent> kafkaTemplate;
    private static final String TOPIC = "Kafka_Example";

    @RequestMapping(value = "/{partId}")
    public Transaction getTransaction(@PathVariable int partId) {
        Transaction transaction = new Transaction(UUID.randomUUID(), TransactionStatus.TRANSACTION_PENDING, getPart(partId), "4843853622714538");
        transactionDatabase.add(transaction.getTransactionId(), transaction);
        TransactionCreatedEvent transactionCreatedEvent = new TransactionCreatedEvent(transaction);
        sendMessage(transactionCreatedEvent.getTransactionId(), transactionCreatedEvent);
        return transaction;
    }

    @GetMapping(value = "/transactions/{transactionId}")
    public Transaction getTransaction(@PathVariable UUID transactionId) {
        return transactionDatabase.get(transactionId);
    }

    private GraphicsCard getPart(int partId) {
        return restTemplate.getForObject(getServiceURL("zuul-service") + "/parts/" + partId, GraphicsCard.class);
    }

    private String getServiceURL(String serviceName) {
        List<ServiceInstance> instances = discoveryClient.getInstances(serviceName);
        ServiceInstance partsService = instances.get(0);
        return partsService.getUri().toString();
    }

    private void sendMessage(UUID transactionId, TransactionCreatedEvent event) {
        transactionEventDatabase.add(transactionId, event);
        kafkaTemplate.send(TOPIC, event);
    }
}
