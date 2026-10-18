package lab01.challenge2;

public interface PaymentMethod {
    void pay(double amount);
}

class CardPayment implements PaymentMethod {
    public void pay(double amount) {
        System.out.println("Charging " + amount + " RON to the card");
    }
}

class PayPalPayment implements PaymentMethod {
    public void pay(double amount) {
        System.out.println("Paying " + amount + " RON with PayPal");
    }
}

class BankTransferPayment implements PaymentMethod {
    public void pay(double amount) {
        System.out.println("Paying " + amount + " RON via Bank Transfer");
    }
}