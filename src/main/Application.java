package main;


import domain.cart.Cart;
import domain.Product;
import domain.properties.Category;
import domain.properties.Money;

import com.github.javafaker.Faker;
import domain.ProductFactory;

import java.util.List;

public class Application {
    public static void main(String[] args) {

        Product product = ProductFactory.getProduct("Java SE 1",new Money("USD",100f),2,new Faker().number().numberBetween(1,12),new Faker().number().numberBetween(1,30),"Moldova",new Category("Boks"));

        Product fakeProduct = ProductFactory.getFakeProduct();





        product.setPrice(product.getPrice().toCurrency("MDL"));
        Cart.getInstance().add(product);
        Cart.getInstance().add(fakeProduct);
        Cart.getInstance().update(1,3);
        Cart.getInstance().findAll().forEach(System.out::println);
        System.out.println(Cart.getInstance().getTotal());











    }


}
