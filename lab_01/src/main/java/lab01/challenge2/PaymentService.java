package lab01.challenge2;

public class PaymentService {

    public void pay(double total, PaymentMethod paymentMethod) {
        paymentMethod.pay(total);
    }
}
