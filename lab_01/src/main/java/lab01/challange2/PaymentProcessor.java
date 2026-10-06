package lab01.challange2;

public class PaymentProcessor {
    public void pay(double total, String paymentMethod) {
        if (paymentMethod.equals("CARD")) {
            System.out.println("Charging " + total + " RON to the card");
        } else if (paymentMethod.equals("PAYPAL")) {
            System.out.println("Paying " + total + " RON with PayPal");
        } else {
            throw new IllegalArgumentException("Unknown payment");
        }
    }
}
