package org.example.lession8.shop.model;

import java.math.BigDecimal;

public class Product {
    private Long id;
    private String title;
    private BigDecimal cost;

    public Product(Long id, String title, BigDecimal cost) {
        this.id = id;
        this.title = title;
        this.cost = cost;
    }

    public Long getId()        { return id; }
    public String getTitle()   { return title; }
    public BigDecimal getCost(){ return cost; }

    @Override
    public String toString() {
        return String.format("[%d] %s — %s ₽", id, title, cost);
    }
}
