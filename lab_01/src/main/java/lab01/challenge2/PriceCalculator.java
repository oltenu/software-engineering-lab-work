package lab01.challenge2;

import java.util.List;

public class PriceCalculator {
    private final DiscountPolicy discountPolicy;

    public PriceCalculator(DiscountPolicy discountPolicy) {
        this.discountPolicy = discountPolicy;
    }

    public double calculate(List<Double> prices) {
        double subtotal = 0;
        for (double price : prices) {
            subtotal += price;
        }
        return discountPolicy.apply(subtotal);
    }
}