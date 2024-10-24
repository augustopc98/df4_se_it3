package com.example.demo.model;

import java.math.BigDecimal;

public class Discount {

    private BigDecimal discountPercentage;

    // Default constructor (needed for Jackson)
    public Discount() {
    }

    public Discount(BigDecimal discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public BigDecimal applyDiscount(BigDecimal totalAmount) {
        return totalAmount.subtract(totalAmount.multiply(discountPercentage).divide(BigDecimal.valueOf(100)));
    }

    public BigDecimal getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(BigDecimal discountPercentage) {
        this.discountPercentage = discountPercentage;
    }
}
