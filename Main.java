package ESHOP;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        EcommerceMediator mediator = new EcommercePlatform();
        Product product1 = new Product("Watermelon", "It's a summer fruit", 9.00, 10);
        Product product2 = new Product("Mango", "It's Yummy!!!", 20.00, 6);
        Product product3 = new Product("Ice cream", "Thanda Thanda Cool Cool", 15.00, 20);
        mediator.addProduct(product1);
        mediator.addProduct(product2);
        mediator.addProduct(product3);

        User user1 = new User("Monica Geller", "m", "123", "123 Beside Me");
        User user2 = new User("Chandler Bing", "bing@gmail.com", "456", "456 Near Me");
        User user3 = new User("Ross Geller", "ross@gmail.com", "789", "789 Around Me");
        User user4 = new User("Rachel Green", "rachel@gmail.com", "012", "012 Near You");
        mediator.addUser(user1);
        mediator.addUser(user2);
        mediator.addUser(user3);
        mediator.addUser(user4);


        PaymentStrategy creditCardPaymentStrategy = new CreditCardPaymentStrategy();
        PaymentStrategy payPalPaymentStrategy = new PayPalPaymentStrategy();
        PaymentStrategy cryptocurrencyPaymentStrategy = new CryptocurrencyPaymentStrategy();

        ProductPurchaseTemplate onlinePurchase = new OnlinePurchase();

        Scanner scanner = new Scanner(System.in);

        List<User> loggedInUsers = new ArrayList<>();

        while (true) {
            if (loggedInUsers.isEmpty()) {
                System.out.println("No user is currently logged in. Please enter your email and password to log in:");
                String email = scanner.nextLine();
                String password = scanner.nextLine();
                for (User user : mediator.getUsers()) {
                    if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                        loggedInUsers.add(user);
                        break;
                    }
                }
                if (loggedInUsers.isEmpty()) {
                    System.out.println("---------------------------------------");
                    System.out.println("Invalid email or password. Please try again.");
                    System.out.println("---------------------------------------");
                }
            } else {
                System.out.println("---------------------------------------");
                System.out.println("Total " + loggedInUsers.size() + " number of users are currently logged in.");
                System.out.println("1. Purchase a product");
                System.out.println("2. Log out");
                String choice = scanner.nextLine();
                if (choice.equals("1")) {
                    // prompt user to choose product
                    System.out.println("---------------------------------------");
                    System.out.println("Select a product to purchase:");
                    List<Product> products = mediator.getProducts();
                    for (int i = 0; i < products.size(); i++) {
                        Product p = products.get(i);
                        System.out.println((i + 1) + ". " + p.getName() + " ($" + p.getPrice() + ")");
                    }
                    int productIndex = Integer.parseInt(scanner.nextLine()) - 1;
                    Product selectedProduct = products.get(productIndex);
                    System.out.println("---------------------------------------");
                    PaymentStrategy paymentStrategy = null;
                    while (paymentStrategy == null) {
                        System.out.println("Please select a payment method:");
                        System.out.println("1. Credit card");
                        System.out.println("2. PayPal");
                        System.out.println("3. Cryptocurrency");
                        String paymentChoice = scanner.nextLine();
                        if (paymentChoice.equals("1")) {
                            paymentStrategy = creditCardPaymentStrategy;
                        } else if (paymentChoice.equals("2")) {
                            paymentStrategy = payPalPaymentStrategy;
                        } else if (paymentChoice.equals("3")) {
                            paymentStrategy = cryptocurrencyPaymentStrategy;
                        } else {
                            System.out.println("---------------------------------------");
                            System.out.println("Invalid choice. Please try again.");
                            System.out.println("---------------------------------------");
                        }
                    }
                    // Prompt the user for the quantity of the product they want to purchase
                    System.out.println("---------------------------------------");
                    System.out.println("Enter the quantity you want to purchase:");
                    int quantity = Integer.parseInt(scanner.nextLine());
                    if (quantity > selectedProduct.getInventory()) {
                        System.out.println("---------------------------------------");
                        System.out.println("We only have " +selectedProduct.getInventory()+" '" + selectedProduct.getName() + "'");
                        System.out.println("---------------------------------------");
                        continue;
                    }

                    selectedProduct.setInventory(selectedProduct.getInventory() - quantity);

                    double totalPrice = selectedProduct.getPrice() * quantity;
                    DiscountStrategy discountStrategy = paymentStrategy instanceof CreditCardPaymentStrategy ? new TenPercentDiscountStrategy() : new NoDiscountStrategy();
                    double discountedPrice = discountStrategy.applyDiscount(totalPrice);
                    onlinePurchase.purchaseProduct(loggedInUsers.get(0), selectedProduct, paymentStrategy, discountedPrice);

                } else if (choice.equals("2")) {
                    loggedInUsers.clear();
                } else {
                    System.out.println("Invalid choice. Please try again.");
                }
            }
        }
    }

}
