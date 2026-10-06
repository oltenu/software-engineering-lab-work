package lab01.challange2;

public class CardPayment implements PaymentMethod {
    @Override
    public void pay(double total) {
        System.out.println("Charging " + total + " RON to the card");
    }
}
