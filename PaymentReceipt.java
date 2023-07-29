package ESHOP;

import java.util.List;

public class PaymentReceipt {
    private User user;
    private Product product;
    private double amount;
    private PaymentStrategy paymentStrategy;

    public PaymentReceipt(User user, Product product, double amount, PaymentStrategy paymentStrategy) {
        this.user = user;
        this.product = product;
        this.amount = amount;
        this.paymentStrategy = paymentStrategy;
    }

    public void send() {
        // Send payment receipt email to user
        String paymentMethod = paymentStrategy instanceof CreditCardPaymentStrategy ? "Credit Card" :
            paymentStrategy instanceof PayPalPaymentStrategy ? "PayPal" :
            paymentStrategy instanceof CryptocurrencyPaymentStrategy ? "Cryptocurrency" : "Unknown";
            
            System.out.println("--------------------------------------------\n");
            System.out.println("************Payment Confirmation************");
            
            System.out.println("Dear " + user.getName() + ",\n\n"
            + "Thanks for your payment of $" + amount
            + " for the product: " + product.getName() + ".\n\n"
            + "Payment method : " + paymentMethod + "\n\n"
            + "Regards,\nMehzabin's Shop\n\n");
    }
}

