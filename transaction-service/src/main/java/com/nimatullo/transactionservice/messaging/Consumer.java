package com.nimatullo.transactionservice.messaging;

import com.nimatullo.transactionservice.db.TransactionCreatedMessageDB;
import com.nimatullo.transactionservice.db.TransactionDatabase;
import com.nimatullo.transactionservice.dto.PaymentAuthorizationResponse;
import com.nimatullo.transactionservice.models.Message;
import com.nimatullo.transactionservice.models.PaymentStatus;
import com.nimatullo.transactionservice.models.Transaction;
import com.nimatullo.transactionservice.models.TransactionStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    @Autowired
    private TransactionDatabase transactionDatabase;

    @Autowired
    private TransactionCreatedMessageDB transactionCreatedMessageDB;

    @StreamListener(Sink.INBOUND)
    public void handleEvent(@Payload Message<PaymentAuthorizationResponse> message) {
        PaymentAuthorizationResponse payload = message.getPayload();
        Transaction transaction = transactionDatabase.get(payload.getTransactionId());
        if (payload.getStatus() == PaymentStatus.CARD_APPROVED) {
           transaction.setStatus(TransactionStatus.SUCCESSFUL);
        }
        else if (payload.getStatus() == PaymentStatus.CARD_DECLINED) {
            transaction.setStatus(TransactionStatus.FAILED);
        }
    }
}
