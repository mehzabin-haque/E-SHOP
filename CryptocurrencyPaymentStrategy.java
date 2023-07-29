package ESHOP;

public class CryptocurrencyPaymentStrategy implements PaymentStrategy {
   

    public void pay(double amount) {
        System.out.println("Processing cryptocurrency payment of $" + amount + "...");
    }
}