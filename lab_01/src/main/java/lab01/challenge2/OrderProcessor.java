package lab01.challenge2;

import java.util.List;

public class OrderProcessor {
    public void process(String email, List<Double> prices,
                        String customerType, String paymentMethod) {
        // 1. validate
        try {
            DataValidator.validate(email, prices);
        } catch (IllegalArgumentException e) {
            System.out.println(e.toString());
        }

        // 2. compute the total, with a discount
        double total = PriceCalculator.calculateTotal(prices, customerType);

        // 3. pay
        try {
            PaymentHandler.pay(paymentMethod, total);
        } catch (IllegalArgumentException e) {
            System.out.println(e.toString());
        }

        // 4. save, then 5. notify the customer
        new FileDatabase().save(email + ";" + total);
        new EmailSender().send(email, "Order of " + total + " RON placed");


    }

    public static void run() {
        new OrderProcessor().process("ana@student.utcluj.ro",
                List.of(100.0, 50.0), "STUDENT", "CARD");
    }
}

class PaymentHandler {
    static void pay(String paymentMethod, double total) {
        if (paymentMethod.equals("CARD")) {
            System.out.println("Charging " + total + " RON to the card");
        } else if (paymentMethod.equals("PAYPAL")) {
            System.out.println("Paying " + total + " RON with PayPal");
        } else {
            throw new IllegalArgumentException("Unknown payment");
        }
    }
}

class DataValidator {
    static void validate(String email, List<Double> prices) {
        if (email == null || !email.contains("@")) {
            throw new IllegalArgumentException("Invalid e-mail");
        }
        if (prices.isEmpty()) {
            throw new IllegalArgumentException("No items");
        }
    }
}

class PriceCalculator {

    static double calculateTotal(List<Double> prices, String customerType) {
        double total = 0;
        for (double price : prices) total += price;
        if (customerType.equals("STUDENT")) {
            total = total * 0.8;
        } else if (customerType.equals("VIP")) {
            total = total * 0.7;
        }

        return total;
    }

}

class FileDatabase {
    void save(String line) { System.out.println("[file] " + line); }
}

class EmailSender {
    void send(String to, String text) {
        System.out.println("[email] " + to + ": " + text);
    }
}