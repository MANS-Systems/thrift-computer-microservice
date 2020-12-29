package com.nimatullo.transactionservice.kafka;

import com.nimatullo.transactionservice.dto.PaymentResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    Logger logger = LoggerFactory.getLogger(KafkaConsumer.class);

    @KafkaListener(topics = "payment_event_bus", groupId = "group_3", containerFactory = "kafkaListenerContainerFactory")
    public void consume(PaymentResponse response) {
        logger.info("recieved the INFORMATIONo");
        logger.info(response.getStatus().toString());
    }

}
