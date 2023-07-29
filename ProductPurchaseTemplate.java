package ESHOP;

public abstract class ProductPurchaseTemplate {

    public void purchaseProduct(User user, Product product, PaymentStrategy paymentStrategy,double discountedPrice) {
        displayProduct(product);
        displayUserAccount(user);
        processOrder(user, product, paymentStrategy,discountedPrice);
    }

    public abstract void displayProduct(Product product);

    public abstract void displayUserAccount(User user);

    public abstract void processOrder(User user, Product product, PaymentStrategy paymentStrategy,double discountedPrice);

}
