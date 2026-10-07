package lab01.challenge2;

public class BankTransferPayment implements PaymentMethod{
    @Override
    public void pay(double total) {
        System.out.println("Charging " + total + " RON via bank transfer");
    }
}
