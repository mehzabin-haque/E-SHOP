package ESHOP;

public class OnlinePurchase extends ProductPurchaseTemplate {

    @Override
    public void displayProduct(Product product) {
        System.out.println("Product Name: " + product.getName());
        System.out.println("Product Description: " + product.getDescription());
        System.out.println("Product Price: " + product.getPrice());
    }

    @Override
    public void displayUserAccount(User user) {
        System.out.println("User Name: " + user.getName());
        System.out.println("User Email: " + user.getEmail());
    }

    @Override
    public void processOrder(User user, Product product, PaymentStrategy paymentStrategy, double discountedPrice) {
        EcommerceMediator mediator = new EcommercePlatform();
        mediator.addUser(user);
        mediator.addProduct(product);
        paymentStrategy.pay(discountedPrice);
        mediator.processOrder(user, product, paymentStrategy,discountedPrice);
       
    }

    public void purchaseProduct(User user, Product product, PaymentStrategy paymentStrategy, double price) {
       
        System.out.println("**************************\n\n");
        displayProduct(product);
        displayUserAccount(user);
        processOrder(user, product, paymentStrategy, price);
        
    }
    

}
