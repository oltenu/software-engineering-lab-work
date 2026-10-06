package lab01.challange2;

public class Notifier {
    public void send(String email, double total) {
        System.out.println("[email] " + email + ": Order of " + total + " RON placed");
    }
}
