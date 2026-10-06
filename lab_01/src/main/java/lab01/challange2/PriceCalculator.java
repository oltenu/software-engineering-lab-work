package lab01.challange2;

import java.util.List;

public class PriceCalculator {
    public double calculate(List<Double> prices, String customerType) {
        double total = 0;

        for (double price : prices) {
            total += price;
        }

        if (customerType.equals("STUDENT")) {
            total = total * 0.8;
        } else if (customerType.equals("VIP")) {
            total = total * 0.7;
        }

        return total;
    }
}
