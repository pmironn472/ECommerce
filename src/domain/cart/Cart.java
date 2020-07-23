package domain.cart;


import domain.Product;
import domain.intefaces.ProductRepository;
import domain.properties.Money;

import java.util.ArrayList;
import java.util.List;


public class Cart implements ProductRepository {

    private List<Product> products = new ArrayList<>();
    private static Money total;

    @Override
    public void add(Product product) {
        products.add(product);
        calculateTotal();
    }

    @Override
    public void delete(Integer productId) {
        Product product = findById(productId);

        if (product != null) {
            products.remove(product);
            calculateTotal();
        } else
            System.err.println("There is no such Product with that ID");
    }

    @Override
    public void update(Integer productId, Integer newQuantity) {
        Product product = findById(productId);
        product.setQuantity(newQuantity);
        calculateTotal();


    }

    @Override
    public Product findById(Integer productId) {
        Product product = null;
        for (Product p :
                products) {
            if (p.getId().equals(productId))
                return p;

        }
        return null;
    }

    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public List<Product> findByName(String productName) {
        List<Product> product = new ArrayList<>();
        for (Product p :
                products) {
            if (p.getName().equals(productName)) {
                product.add(p);
            }
        }
        return product;
    }

    @Override
    public List<Product> findByManufacturer(String manufacturer) {
        List<Product> product = new ArrayList<>();
        for (Product p :
                products) {
            if (p.getManufactured().equals(manufacturer)) {
                product.add(p);
            }
        }
        return product;
    }

    @Override
    public List<Product> findByCategory(String category) {
        List<Product> product = new ArrayList<>();
        for (Product p :
                products) {
            if (p.getCategory().getName().equals(category)) {
                product.add(p);
            }
        }
        return product;
    }

    @Override
    public List<Product> findByExpirationDate(int expD, int expM) {
        List<Product> product = new ArrayList<>();
        for (Product p :
                products) {
            if (p.getExpritaion().equals(expM) && p.getExpritaionD().equals(expD)) {
                product.add(p);
            }
        }
        return product;
    }

    @Override
    public List<Product> findByExpirationDateFrom(int expDay, int expMonth) {
        List<Product> product = new ArrayList<>();
        for (Product p :
                products) {
            if (p.getExpritaionD() >= expDay && p.getExpritaion() >= expMonth) {
                product.add(p);
            }
        }
        return product;
    }

    @Override
    public List<Product> findByExpirationDateTo(int expDay, int expMonth) {
        List<Product> product = new ArrayList<>();
        for (Product p :
                products) {
            if (p.getExpritaionD() <= expDay && p.getExpritaion() <= expMonth) {
                product.add(p);
            }
        }
        return product;
    }

    @Override
    public List<Product> findByExpirationDateBetween(int expDateFrom, int expMFrom, int expDateTo, int expMonthTo) {
        List<Product> product = new ArrayList<>();
        for (Product p :
                products) {
            if (p.getExpritaion() >= expMFrom && p.getExpritaionD() >= expDateFrom && p.getExpritaion() <= expMonthTo && p.getExpritaionD() <= expDateTo) {
                product.add(p);
            }
        }
        return product;
    }


    public void calculateTotal() {
        float total = 0;

        for (Product p :
                products) {
            total += p.getQuantity() * p.getPrice().getAmount();
        }

        Cart.total = new Money(total);


    }

    public String getTotal() {
        return "The total amount of products in cart will cost " + total;
    }


    private static class SingletonHolder {
        private final static Cart INSTANCE = new Cart();
    }

    public static Cart getInstance() {
        return Cart.SingletonHolder.INSTANCE;
    }
}
