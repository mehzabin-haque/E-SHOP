package ESHOP;

public class Product {
    private String name;
    private String description;
    private double price;
    private int inventory;

    public Product(String name, String description, double price, int inventory) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.inventory = inventory;
    }

    // getters and setters
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public int getInventory() {
        return inventory;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }

    public boolean isAvailable() {
        return inventory > 0;
    }

    public void setPrice(double discountedPrice) {
        this.price = discountedPrice;
    }
    
}

