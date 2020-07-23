package domain;

import domain.properties.Category;
import domain.properties.Money;


public class Product {

    private Integer id; // unique for products
    private String name;
    private Money price;
    private Integer quantity;
    private Integer expritaionM;
    private Integer expritaionD;
    private String manufactured;
    private Category category;

    Product() {

    }


    Product(Integer id , String name, Money price, Integer quantity, Integer expritaionM, Integer expritaionD, String manufactured, Category category) {
        this.id=id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.expritaionM = expritaionM;
        this.expritaionD = expritaionD;
        this.manufactured = manufactured;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Money getPrice() {
        return price;
    }

    public void setPrice(Money price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getExpritaion() {
        return expritaionM;
    }

    public void setExpritaion(Integer expritaionM) {
        this.expritaionM = expritaionM;
    }

    public Integer getExpritaionD() {
        return expritaionD;
    }

    public void setExpritaionD(Integer expritaionD) {
        this.expritaionD = expritaionD;
    }

    public String getManufactured() {
        return manufactured;
    }

    public void setManufactured(String manufactured) {
        this.manufactured = manufactured;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Integer getId(){
        return id;
    }

    public String toString() {
        return String.format("Product [ Id = %d," +
                        "%n          Name = %s "+
                        "%n          Price = %s," +
                        "%n          Quantity = %d," +
                        "%n          Expiration date = %s MONTH." +
                        "%s DAY," +
                        "%n          Manufacturer = %s," +
                        "%n          Category = %s ]%n",id, name, price, quantity,
                expritaionM, expritaionD, manufactured, category);
    }


}
