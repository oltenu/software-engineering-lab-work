package lab01.challenge2;

import java.util.List;

public class OrderRunner {
    public static void run() {
        OrderProcessor processor = new OrderProcessor(
                new OrderValidator(),
                new PriceCalculator(),
                new FileDatabase1(),
                new EmailSender1()
        );

        processor.process("ana@student.utcluj.ro", List.of(100.0, 50.0),
                new StudentDiscount(), new CardPayment());

        processor.process("angajat@firma.ro", List.of(100.0, 50.0),
                new EmployeeDiscount(), new BankTransferPayment());
    }
}