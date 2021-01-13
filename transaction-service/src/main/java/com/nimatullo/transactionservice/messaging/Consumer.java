package com.nimatullo.transactionservice.messaging;

import com.nimatullo.transactionservice.dto.PaymentResponse;
import com.nimatullo.transactionservice.models.Message;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    @StreamListener(Sink.INBOUND)
    public void handleEvent(@Payload Message<PaymentResponse> message) {
        System.out.println(message.getMessageId());
    }
}
