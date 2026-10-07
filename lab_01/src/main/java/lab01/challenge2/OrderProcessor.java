package lab01.challenge2;

import java.util.List;

public class OrderProcessor {
    private OrderValidator validator;
    private PriceCalculator calculator;
    private OrderRepository repository;
    private Notifier notifier;

    public OrderProcessor(OrderValidator validator, PriceCalculator calculator,
                          OrderRepository repository, Notifier notifier) {
        this.validator = validator;
        this.calculator = calculator;
        this.repository = repository;
        this.notifier = notifier;
    }

    public void process(String email, List<Double> prices,
                        DiscountPolicy discountPolicy, PaymentMethod paymentMethod) {
        validator.validate(email, prices);
        double total = calculator.calculateTotal(prices, discountPolicy);
        paymentMethod.pay(total);
        repository.save(email + "; " + total);
        notifier.send(email, "Order of " + total + " RON placed");
    }
}