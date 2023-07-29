package ESHOP;

public class PayPalPaymentStrategy implements PaymentStrategy {
    

    public void pay(double amount) {
        System.out.println("Processing PayPal payment of $" + amount + "...");
    }
}