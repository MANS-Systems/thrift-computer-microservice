package com.nimatullo.paymentservice.events;

import com.nimatullo.paymentservice.bank.PaymentProvider;
import com.nimatullo.paymentservice.dto.PaymentAuthorizationResponse;
import com.nimatullo.paymentservice.dto.PaymentAuthorizationRequest;
import com.nimatullo.paymentservice.errors.InsufficientFundsException;
import com.nimatullo.paymentservice.model.Message;
import com.nimatullo.paymentservice.model.PaymentStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import org.springframework.util.MimeTypeUtils;

import java.util.UUID;

@Component
public class Consumer {

    private PaymentProvider bank;

    @Autowired
    private Sink sink;

    public Consumer(PaymentProvider bank, Sink sink) {
        this.bank = bank;
        this.sink = sink;
    }

    @StreamListener(Sink.INBOUND)
    public void handleEvent(@Payload Message<PaymentAuthorizationRequest> message) {
        System.out.println(message.getMessageId().toString());
        MessageChannel messageChannel = sink.producer();
        try {
            bank.chargeCard(message.getPayload().getTransactionTotal());
            Message<PaymentAuthorizationResponse> response = new Message<>(UUID.randomUUID(), new PaymentAuthorizationResponse(message.getPayload().getTransactionId(), PaymentStatus.CARD_APPROVED));
            messageChannel.send(MessageBuilder
                    .withPayload(response)
                    .setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON)
                    .build());
        }
        catch (InsufficientFundsException e) {
            Message<PaymentAuthorizationResponse> response = new Message<>(UUID.randomUUID(), new PaymentAuthorizationResponse(message.getPayload().getTransactionId(), PaymentStatus.CARD_DECLINED));
            messageChannel.send(MessageBuilder
                    .withPayload(response)
                    .setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON)
                    .build());
        }
    }
}
