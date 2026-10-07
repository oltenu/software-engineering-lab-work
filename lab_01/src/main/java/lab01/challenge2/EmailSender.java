package lab01.challenge2;

public class EmailSender implements Notifier {
    @Override
    public void send(String to, String text) {
        System.out.println("[email] " + to + ": " + text);
    }
}