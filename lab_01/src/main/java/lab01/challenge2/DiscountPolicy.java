package lab01.challenge2;

public interface DiscountPolicy {
    double applyDiscount(double total);
}

class StudentDiscount implements DiscountPolicy {
    public double applyDiscount(double total) { return total * 0.8; }
}

class VipDiscount implements DiscountPolicy {
    public double applyDiscount(double total) { return total * 0.7; }
}

class EmployeeDiscount implements DiscountPolicy {
    public double applyDiscount(double total) { return total * 0.5; }
}