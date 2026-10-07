package lab01.challange2;

public class EmployeeDiscount implements DiscountPolicy {
    @Override
    public double applyDiscount(double total) {
        return total * 0.5;
    }
}
