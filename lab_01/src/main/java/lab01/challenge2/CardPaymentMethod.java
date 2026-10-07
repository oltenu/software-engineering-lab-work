package lab01.challenge2;

public class CardPaymentMethod implements PaymentMethod {
    @Override
    public void pay(double total) {
        System.out.println("Charging " + total + " RON to the card");
    }
}