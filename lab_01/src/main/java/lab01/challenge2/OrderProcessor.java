package lab01.challenge2;

import java.util.List;

public class OrderProcessor {
    private OrderRepository repository;
    private Notifier notifier;

    OrderProcessor(OrderRepository repository, Notifier notifier) {
        this.repository = repository;
        this.notifier = notifier;
    }

    public void process(String email, List<Double> prices,
                        Customer customerType, PayingMethod paymentMethod) {
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
        repository.save(email + ";" + total);
        notifier.send(email, "Order of " + total + " RON placed");


    }

    public static void run() {
        OrderRepository repository = new FileDatabase();
        Notifier notifier = new EmailSender();

        new OrderProcessor(repository, notifier).process("ana@student.utcluj.ro",
                List.of(100.0, 50.0), new Student(), new Card());
        new OrderProcessor(repository, notifier).process("Ilie.moromete@gmail.com",
                List.of(6.9, 6.7, 42.0), new Employee(), new Bank());
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
interface OrderRepository {
    void save(String line);
}

interface Notifier {
    void send(String to, String text);
}

class FileDatabase implements OrderRepository {
    @Override
    public void save(String line) {
        System.out.println("[file] " + line);
    }
}

class EmailSender implements Notifier {
    @Override
    public void send(String to, String text) {
        System.out.println("[email] " + to + ": " + text);
    }
}