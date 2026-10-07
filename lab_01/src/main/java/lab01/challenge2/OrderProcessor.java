package lab01.challenge2;

import java.util.List;

public class OrderProcessor {
    public void process(String email, List<Double> prices,
                        Customer customerType, String paymentMethod) {
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
                List.of(100.0, 50.0), new Student(), "CARD");
    }
}

class PaymentHandler {
    static void pay(PayingMethod paymentMethod, double total) {
        if (paymentMethod == null) {
            throw new IllegalArgumentException("Unknown payment");
        }

        paymentMethod.printPaymentConfirm(total);
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

    static double calculateTotal(List<Double> prices, Customer customerType) {
        double total = 0;
        for (double price : prices) total += price;

        total = customerType.applyDiscount(total);

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