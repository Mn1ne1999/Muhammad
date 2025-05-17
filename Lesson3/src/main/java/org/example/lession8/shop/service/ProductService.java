package org.example.lession8.shop.service;

import org.example.lession8.shop.model.Product;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service                        // то же, что @Component, только семантика «сервис»
public class ProductService {

    private final List<Product> products = new ArrayList<>();

    /** Заполняем список ТОЛЬКО после того, как Spring создал бин
     *  и внедрил зависимости. Конструктор — чистый. */
    @PostConstruct
    private void init() {
        products.add(new Product(1L, "Bread",  BigDecimal.valueOf(40)));
        products.add(new Product(2L, "Milk",   BigDecimal.valueOf(70)));
        products.add(new Product(3L, "Cheese", BigDecimal.valueOf(320)));
        products.add(new Product(4L, "Coffee", BigDecimal.valueOf(550)));
        products.add(new Product(5L, "Tea",    BigDecimal.valueOf(290)));
        products.add(new Product(6L, "Apple",  BigDecimal.valueOf(25)));
        products.add(new Product(7L, "Sugar",  BigDecimal.valueOf(84)));
        products.add(new Product(8L, "Water",  BigDecimal.valueOf(23)));
        products.add(new Product(9L, "Butter", BigDecimal.valueOf(180)));
        products.add(new Product(10L,"Eggs",   BigDecimal.valueOf(110)));
    }

    // Печать всех товаров
    public void printAll() {
        products.forEach(System.out::println);
    }

    // Получение товара по имени (null, если не нашли)
    public Product findByTitle(String title) {
        return products.stream()
                .filter(p -> p.getTitle().equalsIgnoreCase(title))
                .findFirst()
                .orElse(null);
    }

    // Может понадобиться наружу
    public List<Product> getAll() {
        return List.copyOf(products);
    }
}
