package com.nimatullo.paymentservice.service;

import com.nimatullo.paymentservice.bank.PaymentProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    private PaymentProvider bank;

    @Autowired
    public PaymentService() {
        this.bank = new PaymentProvider();
    }

}
