package lab01.challenge2;

public class NoDiscountPolicy implements DiscountPolicy{

    @Override
    public double applyDiscount(double total) {
        return total;
    }
}
