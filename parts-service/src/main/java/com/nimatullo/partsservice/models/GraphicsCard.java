package com.nimatullo.partsservice.models;

public class GraphicsCard {
    private String name;
    private String coprocessor;
    private String GPU;
    private double price;

    public GraphicsCard(String name, String coprocessor, String GPU, double price) {
        this.name = name;
        this.coprocessor = coprocessor;
        this.GPU = GPU;
        this.price = price;
    }

    public GraphicsCard() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCoprocessor() {
        return coprocessor;
    }

    public void setCoprocessor(String coprocessor) {
        this.coprocessor = coprocessor;
    }

    public String getGPU() {
        return GPU;
    }

    public void setGPU(String GPU) {
        this.GPU = GPU;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
