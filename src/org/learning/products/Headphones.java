package org.learning.products;

public class Headphones extends Product {
    private String color;
    private boolean isWireless;

    public Headphones(String name, String description, double price, int vat, String color, boolean isWireless) {
        super(name, description, price, vat);
        this.color = color;
        this.isWireless = isWireless;
    }

    @Override
    public String toString() {
        return "Headphones [color=" + color + ", isWireless=" + isWireless + ", productCode=" + productCode + ", name="
                + name + ", description=" + description + ", price=" + price + ", vat=" + vat + "]";
    }
}
