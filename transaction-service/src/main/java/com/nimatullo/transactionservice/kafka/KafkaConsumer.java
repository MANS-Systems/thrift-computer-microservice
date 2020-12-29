package com.nimatullo.transactionservice.kafka;

import com.nimatullo.transactionservice.db.TransactionDatabase;
import com.nimatullo.transactionservice.db.TransactionEventDatabase;
import com.nimatullo.transactionservice.dto.PaymentResponse;
import com.nimatullo.transactionservice.models.PaymentStatus;
import com.nimatullo.transactionservice.models.TransactionStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class KafkaConsumer {

    Logger logger = LoggerFactory.getLogger(KafkaConsumer.class);

    @Autowired
    private TransactionEventDatabase db;

    @Autowired
    private TransactionDatabase transactionDatabase;

    @KafkaListener(topics = "payment_event_bus", groupId = "group_3", containerFactory = "kafkaListenerContainerFactory")
    public void consume(PaymentResponse response) {
        if (response.getStatus() == PaymentStatus.CARD_APPROVED) {
            changeTransactionStatusToSuccessful(response.getOrderId());
        }
        else if (response.getStatus() == PaymentStatus.CARD_DECLINED) {
            changeTransactionStatusToFailed(response.getOrderId());
        }
        logger.info(db.get(response.getOrderId()).getStatus().toString());
    }

    private void changeTransactionStatusToSuccessful(UUID id) {
        db.get(id).setStatus(TransactionStatus.TRANSACTION_SUCCESSFUL);
        transactionDatabase.get(id).setStatus(TransactionStatus.TRANSACTION_SUCCESSFUL);
    }

    private void changeTransactionStatusToFailed(UUID id) {
        db.get(id).setStatus(TransactionStatus.TRANSACTION_FAILED);
        transactionDatabase.get(id).setStatus(TransactionStatus.TRANSACTION_FAILED);
    }

}
