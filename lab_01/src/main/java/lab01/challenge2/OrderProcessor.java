package lab01.challenge2;

import java.util.List;

public class OrderProcessor {
    private final OrderValidator validator;
    private final PriceCalculator priceCalculator;
    private final PaymentMethod paymentMethod;
    private final OrderRepository repository;
    private final Notifier notifier;

    public OrderProcessor(
            OrderValidator validator,
            PriceCalculator priceCalculator,
            PaymentMethod paymentMethod,
            OrderRepository repository,
            Notifier notifier) {
        this.validator = validator;
        this.priceCalculator = priceCalculator;
        this.paymentMethod = paymentMethod;
        this.repository = repository;
        this.notifier = notifier;
    }

    public void process(String email, List<Double> prices) {
        validator.validate(email, prices);
        double total = priceCalculator.calculate(prices);

        paymentMethod.pay(total);
        repository.save(email + ";" + total);
        notifier.send(email, "Order of " + total + " RON placed");
    }
}