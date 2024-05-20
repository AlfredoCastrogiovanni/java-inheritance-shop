package org.learning.products;

public class Tv extends Product {
    double inch;
    boolean isSmart;

    public Tv(String name, String description, double price, int vat, double inch, boolean isSmart) {
        super(name, description, price, vat);
        this.inch = inch;
        this.isSmart = isSmart;
    }
}
