package lab01.challenge2;

import java.util.List;

public class OrderValidator {
    public void validate(String email, List<Double> prices) {
        if (email == null || !email.contains("@")) {
            throw new IllegalArgumentException("Invalid e-mail");
        }
        if (prices == null || prices.isEmpty()) {
            throw new IllegalArgumentException("No items");
        }
    }
}