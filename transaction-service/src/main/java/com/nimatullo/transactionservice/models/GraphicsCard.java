package com.nimatullo.transactionservice.models;

public class GraphicsCard {
    private String coprocessor;
    private double price;

    public GraphicsCard() {
    }

    public GraphicsCard(String coprocessor, double price) {
        this.coprocessor = coprocessor;
        this.price = price;
    }

    public String getCoprocessor() {
        return coprocessor;
    }

    public void setCoprocessor(String coprocessor) {
        this.coprocessor = coprocessor;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
