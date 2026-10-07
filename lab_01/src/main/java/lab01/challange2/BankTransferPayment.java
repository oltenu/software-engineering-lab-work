package lab01.challange2;

public class BankTransferPayment implements PaymentMethod {

    @Override
    public void pay(double total) {
        System.out.println("Paying " + total + " RON with bank transfer");
    }
}
