package lab01.challange2;

import java.util.List;
import java.util.Locale;

public class OrderProcessor {
    public void process(String email, List<Double> prices,
                        DiscountPolicy discountPolicy,PaymentMethod paymentMethod) {
        OrderValidator validator = new OrderValidator();
        PriceCalculator calculator = new PriceCalculator();
        PaymentProcessor payment = new PaymentProcessor();
        OrderRepository repository = new OrderRepository();
        Notifier notifier = new Notifier();

        validator.validate(email, prices);
        double total = calculator.calculate(prices, discountPolicy);
        payment.pay(total, paymentMethod);
        repository.save(email, total);
        notifier.send(email, total);
    }

    public static void run() {
        new OrderProcessor().process(
                "ana@student.utcluj.ro",
                List.of(100.0, 50.0),
                new StudentDiscount(),
                new CardPayment()
        );
    }
}

class FileDatabase {
    void save(String line) {
        System.out.println("[file] " + line);
    }
}

class EmailSender {
    void send(String to, String text) {
        System.out.println("[email] " + to + ": " + text);
    }
}