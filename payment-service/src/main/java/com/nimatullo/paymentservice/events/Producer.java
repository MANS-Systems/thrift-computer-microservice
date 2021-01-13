package com.nimatullo.paymentservice.events;

import com.nimatullo.paymentservice.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;
import org.springframework.util.MimeTypeUtils;

@Component
public class Producer {

    @Autowired
    private Sink stream;

    public void sendMessage(Message message) {
        MessageChannel producer = stream.producer();
        producer.send(MessageBuilder.withPayload(message)
                .setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON)
                .build());
    }

}
