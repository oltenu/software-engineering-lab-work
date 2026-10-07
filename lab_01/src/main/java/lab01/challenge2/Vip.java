package lab01.challenge2;

public class Vip implements Customer{
    private static final double DISCOUNT = 0.7;

    @Override
    public double applyDiscount(double price) {
        return price * DISCOUNT;
    }
}
