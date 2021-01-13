package com.nimatullo.paymentservice.events;

import org.springframework.cloud.stream.annotation.EnableBinding;

@EnableBinding(Processor.class)
public class ProcessorConfig {
}
