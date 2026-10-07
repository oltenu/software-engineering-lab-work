package lab01.challenge2;

public class PayPalPayment implements PaymentMethod{

    @Override
    public void pay(double total) {
        System.out.println("Paying " + total + " RON with PayPal");
    }
}
