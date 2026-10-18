package lab01.challenge2;

import java.util.List;

public class OrderProcessor {
    private final OrderRepository repo;
    private final Notifier notifier;

    public OrderProcessor(OrderRepository repo, Notifier notifier) {
        this.repo = repo;
        this.notifier = notifier;
    }

    public void process(String email, List<Double> prices, DiscountPolicy discount, PaymentMethod payment) {
        if (email == null || !email.contains("@")) {
            throw new IllegalArgumentException("Invalid e-mail");
        }
        if (prices.isEmpty()) {
            throw new IllegalArgumentException("No items");
        }

        double total = 0;
        for (double price : prices) {
            total += price;
        }

        total = discount.applyDiscount(total);
        payment.pay(total);

        repo.save(email + ";" + total);
        notifier.send(email, "Order of " + total + " RON placed");
    }

    public static void run() {
        OrderRepository db = new FileDatabase();
        Notifier emailSys = new EmailSender();
        OrderProcessor processor = new OrderProcessor(db, emailSys);

        System.out.println("--- Prima comanda (cea din lab) ---");
        processor.process("ana@student.utcluj.ro", List.of(100.0, 50.0), new StudentDiscount(), new CardPayment());

        System.out.println("\n--- A doua comanda (angajat) ---");
        processor.process("angajat@firma.ro", List.of(200.0, 100.0), new EmployeeDiscount(), new BankTransferPayment());
    }
}