package com.nimatullo.transactionservice.events;

import com.nimatullo.transactionservice.dto.PaymentResponse;
import com.nimatullo.transactionservice.models.Message;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    @StreamListener(EventStream.INBOUND)
    public void handleEvent(@Payload Message<PaymentResponse> message) {
        System.out.println(message.getMessageId());
    }
}
