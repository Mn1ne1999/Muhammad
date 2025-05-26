package org.example.lession8.shop.cart;


import org.example.lession8.shop.model.Product;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
@Scope("prototype")      // чтобы каждая корзина была новой (не один singleton)
public class Cart {

    private final List<Product> items = new ArrayList<>();

    public void add(Product product) {
        if (product != null) items.add(product);
    }

    public List<Product> getItems() {
        return List.copyOf(items);
    }

    public BigDecimal totalCost() {
        return items.stream()
                .map(Product::getCost)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}

