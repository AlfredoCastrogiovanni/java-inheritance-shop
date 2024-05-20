package org.learning.products;

public class Smartphone extends Product {
    String IMEI;
    double memory;

    public Smartphone(String name, String description, double price, int vat, String IMEI, double memory) {
        super(name, description, price, vat);
        this.IMEI = IMEI;
        this.memory = memory;
    }
}
