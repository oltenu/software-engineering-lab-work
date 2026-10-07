package lab01.challenge2;

public class Employee implements Customer {
    private static final double DISCOUNT = 0.5;
    @Override
    public double applyDiscount(double price) {
        return price * DISCOUNT;
    }
}
