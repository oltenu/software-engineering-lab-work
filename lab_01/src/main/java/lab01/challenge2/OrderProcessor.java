package lab01.challenge2;

import java.util.List;

public class OrderProcessor {

    private final OrderValidator validator;
    private final PriceCalculator calculator;
    private final PaymentService paymentService;
    private final OrderRepository repository;
    private final Notifier notifier;

    public OrderProcessor(OrderValidator validator, PriceCalculator calculator, PaymentService paymentService, OrderRepository repository, Notifier notifier) {
        this.validator = validator;
        this.calculator = calculator;
        this.paymentService = paymentService;
        this.repository = repository;
        this.notifier = notifier;
    }

    public void process(String email, List<Double> prices,
                        DiscountPolicy discountPolicy, PaymentMethod paymentMethod) {

        validator.validate(email, prices);
        double total = calculator.calculateTotal(prices, discountPolicy);
        paymentService.pay(total, paymentMethod);
        repository.save(email, total);
        notifier.notifyCustomer(email, total);
    }

    public static void run() {

        OrderValidator validator = new OrderValidator();
        PriceCalculator calculator = new PriceCalculator();
        PaymentService paymentService = new PaymentService();
        OrderRepository repository = new FileOrderRepository();
        Notifier notifier = new EmailNotifier();
        OrderProcessor processor = new OrderProcessor(validator, calculator, paymentService, repository, notifier);

        processor.process(
                "ana@student.utcluj.ro",
                List.of(100.0, 50.0),
                new StudentDiscountPolicy(),
                new CardPayment()
        );

        processor.process(
                "employee@company.com",
                List.of(300.0, 50.0),
                new EmployeeDiscountPolicy(),
                new BankTransferPayment()
        );
    }
}
