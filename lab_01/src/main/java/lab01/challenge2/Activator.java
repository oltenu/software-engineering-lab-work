package lab01.challenge2;

import java.util.List;

public class Activator {
    public static void run() {
        OrderProcessor studentCardOrder = new OrderProcessor(
                new OrderValidator(),
                new PriceCalculator(new StudentDiscountPolicy()),
                new CardPaymentMethod(),
                new FileDatabase(),
                new EmailSender());

        studentCardOrder.process(
                "ana@student.utcluj.ro",
                List.of(100.0, 50.0));

        OrderProcessor employeeBankTransferOrder = new OrderProcessor(
                new OrderValidator(),
                new PriceCalculator(new EmployeeDiscountPolicy()),
                new CardPaymentMethod(),
                new FileDatabase(),
                new EmailSender());

        employeeBankTransferOrder.process(
                "employee@company.ro",
                List.of(200.0));
    }
}