package com.nimatullo.partsservice.listener;

import com.nimatullo.partsservice.TransactionResponse;
import com.nimatullo.partsservice.models.TransactionStatus;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;


//@Service
public class KafkaConsumer {
//    @KafkaListener(topics = "Kafka_Example", groupId = "group_2", containerFactory = "kafkaListenerContainerFactory")
    public void consume(TransactionResponse response) {
        if (response.getStatus() == TransactionStatus.TRANSACTION_SUCCESSFUL) {
            System.out.println("Transaction was successful, moving the saga forward...");
        }
        else {
            System.out.println("Transaction was unsuccessful, rolling back changes");
        }
    }
}
