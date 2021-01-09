package com.nimatullo.paymentservice.kafka;

import com.nimatullo.paymentservice.bank.PaymentProvider;
import com.nimatullo.paymentservice.dto.PaymentResponse;
import com.nimatullo.paymentservice.dto.TransactionRequest;
import com.nimatullo.paymentservice.errors.InsufficientFundsException;
import com.nimatullo.paymentservice.model.Message;
import com.nimatullo.paymentservice.model.PaymentStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;

//@Service
public class KafkaConsumer {
//
//    @Autowired
//    private PaymentProvider bank;
//
//    @Autowired
//    private KafkaTemplate<String, Message> kafkaTemplate;
//    private static final String topic = "payment_event_bus";
//
//    @KafkaListener(topics = "Kafka_Example", groupId = "group_2", containerFactory = "kafkaListenerContainerFactory")
//    public void consume(Message<TransactionRequest> requestMessage) {
//        try {
//            bank.chargeCard(requestMessage.getPayload().getTransactionTotal());
//            Message<PaymentResponse> response = new Message<>(UUID.randomUUID(), new PaymentResponse(PaymentStatus.CARD_APPROVED));
//            kafkaTemplate.send(topic, response);
//        }
//        catch (InsufficientFundsException e) {
//            Message<PaymentResponse> response = new Message<>(UUID.randomUUID(), new PaymentResponse(PaymentStatus.CARD_DECLINED));
//            kafkaTemplate.send(topic, response);
//        }
//    }
}
