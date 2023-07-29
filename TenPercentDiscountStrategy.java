package ESHOP;

public class TenPercentDiscountStrategy implements DiscountStrategy {
    @Override
    public double applyDiscount(double amount) {
        return amount * 0.9; 
    }
}
