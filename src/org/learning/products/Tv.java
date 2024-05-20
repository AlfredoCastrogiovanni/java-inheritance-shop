package org.learning.products;

import java.math.BigDecimal;

public class Tv extends Product {
    private double inch;
    private boolean isSmart;

    public Tv(String name, String description, double price, int vat, double inch, boolean isSmart) {
        super(name, description, price, vat);
        this.inch = inch;
        this.isSmart = isSmart;
    }

    @Override
    public String toString() {
        return "Tv [inch=" + inch + ", isSmart=" + isSmart + ", productCode=" + productCode + ", name=" + name
                + ", description=" + description + ", price=" + price + ", vat=" + vat + "]";
    }

    @Override
    public BigDecimal priceWithFidelityCard() {
        if (!isSmart) {
            return getPriceWithVat().subtract(getPriceWithVat().multiply(BigDecimal.valueOf(10)).divide(BigDecimal.valueOf(100)));
        } else {
            return super.priceWithFidelityCard();
        }
    }
}
