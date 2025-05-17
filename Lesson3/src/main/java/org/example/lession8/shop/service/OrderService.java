package org.example.lession8.shop.service;


import org.example.lession8.shop.cart.Cart;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    public void createOrder(Cart cart) {
        System.out.println("----- ЧЕК -----");
        cart.getItems().forEach(System.out::println);
        System.out.printf("Итого: %s ₽%n", cart.totalCost());
        System.out.println("---------------");
    }
}

