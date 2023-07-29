package ESHOP;

public class CreditCardPaymentStrategy implements PaymentStrategy {
 
    public void pay(double amount) {
        System.out.println("\nYou got 10% discount for using credit card.\n"+
        "Processing CreditCard payment of $" + amount + "...");
    }
}