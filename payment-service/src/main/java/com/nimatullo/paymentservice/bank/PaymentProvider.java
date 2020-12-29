package com.nimatullo.paymentservice.bank;

import com.nimatullo.paymentservice.errors.InsufficientFundsException;
import org.springframework.stereotype.Component;

@Component
public class PaymentProvider {
    private double total;

    public PaymentProvider() {
        this.total = 200.00;
    }

    public double chargeCard(double paymentTotal) {
        if (paymentTotal > total) {
            throw new InsufficientFundsException();
        }
        else {
            total -= paymentTotal;
        }
        return paymentTotal;
    }
}
