## Single responsibilty principle
The original `Order Processor` class validates the email, calculates the pay and manages the payment method.

## Open Close principle
The `Open Closed` principle was violated in the PriceCalculator and PaymentHAndler methods because those methods relied on if else statements to change behavior based on different types of parameters.  