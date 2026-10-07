package lab01.challenge2;

public class BankTransferPayment implements PaymentMethod{

    @Override
    public void pay(double total) {
        System.out.println("Paying " + total + " RON by bank transfer");
    }
}
