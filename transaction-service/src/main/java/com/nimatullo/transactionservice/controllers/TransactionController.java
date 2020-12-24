package com.nimatullo.transactionservice.controllers;

import com.nimatullo.transactionservice.dto.TransactionCreated;
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
    private KafkaTemplate<String, TransactionCreated> kafkaTemplate;
    private static final String TOPIC = "Kafka_Example";

    @RequestMapping(value = "/{partId}")
    public Transaction getTransaction(@PathVariable int partId) {
        List<ServiceInstance> instances = discoveryClient.getInstances("zuul-service");
        ServiceInstance partsService = instances.get(0);
        final String PARTS_SERVICE_URL = partsService.getUri().toString();
        GraphicsCard itemBought= restTemplate.getForObject(PARTS_SERVICE_URL + "/parts/" + partId, GraphicsCard.class);
        UUID transactionId = UUID.randomUUID();
        kafkaTemplate.send(TOPIC, new TransactionCreated(transactionId, TransactionStatus.TRANSACTION_SUCCESSFUL));
        return new Transaction(transactionId, TransactionStatus.TRANSACTION_SUCCESSFUL, itemBought);
    }
}
