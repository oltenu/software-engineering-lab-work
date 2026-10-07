package lab01.challenge2;

public class EmployeeDiscountPolicy implements DiscountPolicy{

    @Override
    public double applyDiscount(double total) {
        return total * 0.5;
    }
}
