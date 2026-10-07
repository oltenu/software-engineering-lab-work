package lab01.challenge2;

public class Student implements Customer{
    private static final double DISCOUNT = 0.8;
    @Override
    public double applyDiscount(double price) {
        return price * DISCOUNT;
    }
}
