package lab01.challenge2;

public class BankTransferPayment implements PaymentMethod {
    @Override
    public void pay(double amount) {
        System.out.println("Paying " + amount + " RON via Bank Transfer");
    }
}