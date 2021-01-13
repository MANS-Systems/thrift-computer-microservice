package com.nimatullo.transactionservice.controllers;

import com.nimatullo.transactionservice.db.TransactionDatabase;
import com.nimatullo.transactionservice.db.TransactionCreatedMessageDB;
import com.nimatullo.transactionservice.dto.TransactionCreated;
import com.nimatullo.transactionservice.messaging.Producer;
import com.nimatullo.transactionservice.models.GraphicsCard;
import com.nimatullo.transactionservice.models.Message;
import com.nimatullo.transactionservice.models.Transaction;
import com.nimatullo.transactionservice.models.TransactionStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.UUID;

@RestController
public class TransactionController {

    private static final Logger logger = LoggerFactory.getLogger(TransactionController.class);

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private TransactionCreatedMessageDB transactionCreatedMessageDB;

    @Autowired
    private TransactionDatabase transactionDatabase;

    @Autowired
    private Producer producer;


    @RequestMapping(value = "/{partId}")
    public Transaction getTransaction(@PathVariable int partId) {
        Transaction transaction = new Transaction(UUID.randomUUID(), TransactionStatus.PENDING, getPart(partId), "4843853622714538");
        Message<TransactionCreated> transactionCreatedMessage = new Message<>(UUID.randomUUID(), new TransactionCreated(transaction));
        save(transaction, transactionCreatedMessage);
        producer.sendMessage(transactionCreatedMessage);
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

    private void save(Transaction transaction, Message<TransactionCreated> message) {
        transactionDatabase.add(transaction.getTransactionId(), transaction);
        transactionCreatedMessageDB.add(message);
    }
}
