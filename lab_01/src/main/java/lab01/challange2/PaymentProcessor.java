package lab01.challange2;

public class PaymentProcessor {
    public void pay(double total, PaymentMethod paymentMethod) {
        paymentMethod.pay(total);
    }
}
