package lab01.challange2;

import java.util.List;

public class OrderProcessor {
    private final OrderValidator validator;
    private final PriceCalculator calculator;
    private final PaymentProcessor payment;
    private final OrderRepository repository;
    private final Notifier notifier;

    public OrderProcessor(OrderValidator validator, PriceCalculator calculator, PaymentProcessor payment, OrderRepository repository, Notifier notifier) {
        this.validator = validator;
        this.calculator = calculator;
        this.payment = payment;
        this.repository = repository;
        this.notifier = notifier;
    }

    public void process(String email, List<Double> prices, DiscountPolicy discountPolicy, PaymentMethod paymentMethod) {
        validator.validate(email, prices);
        double total = calculator.calculate(prices, discountPolicy);

        payment.pay(total, paymentMethod);
        repository.save(email, total);
        notifier.send(email, total);
    }

    public static void run() {
        OrderValidator validator = new OrderValidator();
        PriceCalculator calculator = new PriceCalculator();
        PaymentProcessor payment = new PaymentProcessor();
        OrderRepository repository = new OrderRepository();
        Notifier notifier = new Notifier();

        OrderProcessor processor = new OrderProcessor(
                validator,
                calculator,
                payment,
                repository,
                notifier
        );
        processor.process("ana@student.utcluj.ro", List.of(100.0, 50.0), new StudentDiscount(), new CardPayment());
        processor.process("ion@employee.ro", List.of(100.0, 50.0), new EmployeeDiscount(), new BankTransferPayment());
    }


}