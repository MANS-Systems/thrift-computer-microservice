package com.nimatullo.paymentservice.kafka;

import com.nimatullo.paymentservice.bank.PaymentProvider;
import com.nimatullo.paymentservice.dto.PaymentResponse;
import com.nimatullo.paymentservice.dto.TransactionResponse;
import com.nimatullo.paymentservice.errors.InsufficientFundsException;
import com.nimatullo.paymentservice.model.PaymentStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    @Autowired
    private PaymentProvider bank;

    @Autowired
    private KafkaTemplate<String, PaymentResponse> kafkaTemplate;
    private static final String topic = "payment_event_bus";

    @KafkaListener(topics = "Kafka_Example", groupId = "group_2", containerFactory = "kafkaListenerContainerFactory")
    public void consume(TransactionResponse response) {
        PaymentResponse paymentResponse;
        try {
            bank.chargeCard(response.getTransactionTotal());
            paymentResponse = new PaymentResponse(PaymentStatus.CARD_APPROVED, response.getTransactionId());
        }
        catch (InsufficientFundsException e) {
            paymentResponse = new PaymentResponse(PaymentStatus.CARD_DECLINED, response.getTransactionId());
        }
        kafkaTemplate.send(topic, paymentResponse);
    }
}
