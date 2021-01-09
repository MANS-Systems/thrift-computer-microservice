package com.nimatullo.transactionservice.events;

import org.springframework.cloud.stream.annotation.EnableBinding;

@EnableBinding(EventStream.class)
public class EventStreamConfig {
}
