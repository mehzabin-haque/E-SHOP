package ESHOP;

import java.util.ArrayList;
import java.util.List;

public class EcommercePlatform implements EcommerceMediator {
    private List<User> users;
    private List<Product> products = new ArrayList<>();

    public EcommercePlatform() {
        this.users = new ArrayList<>();
        this.products = new ArrayList<>();
    }

    @Override
    public void addUser(User user) {
        users.add(user);
    }

    @Override
    public void addProduct(Product product) {
        products.add(product);
    }

    @Override
    public void processOrder(User user, Product product, PaymentStrategy paymentStrategy,double discountedPrice) {
        if (products.contains(product) && users.contains(user)) {
            if (product.getInventory() >= 0) {
                // product.setInventory(product.getInventory() - 1);

                OrderConfirmation orderConfirmation = new OrderConfirmation(user, product, discountedPrice);
                PaymentReceipt paymentReceipt = new PaymentReceipt(user, product, discountedPrice, paymentStrategy);
                orderConfirmation.send();
                // System.out.println("teststestse");
                paymentReceipt.send();
            }
            else {
                
                System.out.println("Sorry, the product is out of stock.");
            }
        }
        else {
            
            System.out.println("Sorry, we could not process your order. Please try again later.");
        }
    }

    

    @Override
    public User[] getUsers() {
        return users.toArray(new User[users.size()]);
    }

    @Override
    public List<Product> getProducts() {
        return products;
    }

}
