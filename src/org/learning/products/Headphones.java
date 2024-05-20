package org.learning.products;

public class Headphones extends Product {
    String color;
    boolean isWireless;

    public Headphones(String name, String description, double price, int vat, String color, boolean isWireless) {
        super(name, description, price, vat);
        this.color = color;
        this.isWireless = isWireless;
    }
}
