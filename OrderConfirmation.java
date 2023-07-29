package ESHOP;

import java.util.List;

public class OrderConfirmation {
    private User user;
    private Product product;
    private double amount;

    public OrderConfirmation(User user, Product product, double amount) {
        this.user = user;
        this.product = product;
        this.amount = amount;
    }

    public void send() {
        System.out.println("------------------------------------------\n");
        System.out.println("************Order Confirmation************");
        System.out.println("Dear " + user.getName() + ",\n\n"
            + "Thank you for your order! We have received your payment of $" + amount
            + " for the product: " + product.getName() + ".\n\n"
            + "Regards,\nMehzabin's Shop\n\n");
    }
}

