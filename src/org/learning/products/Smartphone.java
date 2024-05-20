package org.learning.products;

import java.math.BigDecimal;

public class Smartphone extends Product {
    private String IMEI;
    private double memory;

    public Smartphone(String name, String description, double price, int vat, String IMEI, double memory) {
        super(name, description, price, vat);
        this.IMEI = IMEI;
        this.memory = memory;
    }

    @Override
    public String toString() {
        return "Smartphone [IMEI=" + IMEI + ", memory=" + memory + ", productCode=" + productCode + ", name=" + name
                + ", description=" + description + ", price=" + price + ", vat=" + vat + "]";
    }

    @Override
    public BigDecimal priceWithFidelityCard() {
        if (memory < 32) {
            return getPriceWithVat().subtract(getPriceWithVat().multiply(BigDecimal.valueOf(5)).divide(BigDecimal.valueOf(100)));
        } else {
            return super.priceWithFidelityCard();
        }
    }
}
