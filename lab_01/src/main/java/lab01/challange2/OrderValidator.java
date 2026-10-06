package lab01.challange2;

import java.util.List;

public class OrderValidator {
    public void validate(String email, List<Double> prices) {
        if (email == null || !email.contains("@")) {
            throw new IllegalArgumentException("Invalid e-mail");
        }
        if (prices.isEmpty()) {
            throw new IllegalArgumentException("No items");
        }
    }
}
