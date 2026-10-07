package lab01.challenge2;

public class EmailNotifier implements Notifier{

    @Override
    public void notifyCustomer(String email, double total) {
        System.out.println("[email] " + email + ": Order of " + total + " RON placed");
    }
}
