package domain;


import com.github.javafaker.Faker;


import java.util.*;

import domain.properties.Category;
import domain.properties.Money;


public class ProductFactory {
    static Faker faker = new Faker(new Locale("ru"));
    private static Integer productCount = 0;


    public static Product getProduct(String name, Money price, Integer quantity, Integer expritaionM, Integer expritaionD, String manufactured, Category category) {

        return new Product(++productCount, name, price, quantity, expritaionM, expritaionD, manufactured, category);
    }


    public static Product getFakeProduct() {
        return new Product(
                ++productCount,
                faker.commerce().productName(),
                new Money(faker.currency().name(), (float) faker.number().numberBetween(100, 2000)),
                faker.number().numberBetween(1, 10),
                faker.number().numberBetween(1, 12),
                faker.number().numberBetween(1, 31),
                faker.country().capital(),
                new Category(faker.commerce().department()));

    }


    public static List<Product> getFakerProducts(Integer qty) {
        List<Product> products = new ArrayList<>();
        while (products.size() < qty) {
            products.add(
                    getFakeProduct()
            );
        }
        return products;
    }

    private static class SingletonHolder {
        private final static ProductFactory INSTANCE = new ProductFactory();
    }

    public static ProductFactory getInstance() {
        return SingletonHolder.INSTANCE;
    }

}



