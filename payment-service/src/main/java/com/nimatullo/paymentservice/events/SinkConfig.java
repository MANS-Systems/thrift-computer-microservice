package com.nimatullo.paymentservice.events;

import org.springframework.cloud.stream.annotation.EnableBinding;

@EnableBinding(Sink.class)
public class SinkConfig {
}
