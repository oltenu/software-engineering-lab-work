package lab01.challenge2;

public class Bank implements PayingMethod{
    @Override
    public void printPaymentConfirm(double price) {
        System.out.println("Paying " + price + " RON with Bank Transfer");
    }
}
