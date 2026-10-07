package lab01.challenge2;

public class StudentDiscountPolicy implements DiscountPolicy {
    @Override
    public double apply(double subtotal) {
        return subtotal * 0.8;
    }
}