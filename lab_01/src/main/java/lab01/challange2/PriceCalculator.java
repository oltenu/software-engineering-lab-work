package lab01.challange2;

import java.util.List;

public class PriceCalculator {
    public double calculate(List<Double> prices, DiscountPolicy discountPolicy) {
        double total = 0;

        for (double price : prices) {
            total += price;
        }

        return discountPolicy.applyDiscount(total);
    }
}
