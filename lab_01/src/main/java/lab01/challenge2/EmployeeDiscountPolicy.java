package lab01.challenge2;

public class EmployeeDiscountPolicy implements DiscountPolicy {
    @Override
    public double apply(double subtotal) {
        return subtotal * 0.5;
    }
}