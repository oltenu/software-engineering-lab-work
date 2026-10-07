package lab01.challenge2;

import java.util.List;

public class PriceCalculator {
    public double calculateTotal(List<Double> prices, DiscountPolicy discount) {
        double total = 0;

        for (double price : prices) {
            total = total + price;
            return discount.applyDiscount(total);
        }
        return 0;
    }
}
