package ESHOP;

import java.util.List;

public interface EcommerceMediator {
    public void addUser(User user);
    public void addProduct(Product product);
    public void processOrder(User user, Product product, PaymentStrategy paymentStrategy,double discountedPrice);
    public User[] getUsers();
    public List<Product> getProducts();
}