package lab01.challenge2;

public class Card implements PayingMethod{
    @Override
    public void printPaymentConfirm(double price) {
        System.out.println("Charging " + price + " RON to the card");
    }
}
