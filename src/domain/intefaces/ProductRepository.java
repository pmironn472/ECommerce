package domain.intefaces;

import domain.Product;


import java.util.List;

public interface ProductRepository {


    void add(Product product);

    void delete(Integer productId);

    void update(Integer productId, Integer newQuantity);

    Product findById(Integer productId);

    List<Product> findAll();

    List<Product> findByName(String productName);

    List<Product> findByManufacturer(String manufacturer);

    List<Product> findByCategory(String category);

    List<Product> findByExpirationDate(int expDay, int expMonth);

    List<Product> findByExpirationDateFrom(int expDay, int expMonth);

    List<Product> findByExpirationDateTo(int expDay, int expMonth);

    List<Product> findByExpirationDateBetween(int expDateFrom, int expMFrom, int expDateTo, int expMonthTo);

}
