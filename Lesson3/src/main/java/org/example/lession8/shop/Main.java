package org.example.lession8.shop;

import org.example.lession8.shop.cart.Cart;
import org.example.lession8.shop.service.OrderService;
import org.example.lession8.shop.service.ProductService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        // 1. Запускаем контейнер
        try (AnnotationConfigApplicationContext ctx =
                     new AnnotationConfigApplicationContext(AppConfig.class)) {

            ProductService productService = ctx.getBean(ProductService.class);

            // 2. Создаём корзину (бин прототип — всегда новая)
            Cart cart = ctx.getBean(Cart.class);

            // 3. Кладём пару товаров
            cart.add(productService.findByTitle("Bread"));
            cart.add(productService.findByTitle("Milk"));
            cart.add(productService.findByTitle("Coffee"));

            // 4. Формируем заказ
            OrderService orderService = ctx.getBean(OrderService.class);
            orderService.createOrder(cart);
        }
    }
}

