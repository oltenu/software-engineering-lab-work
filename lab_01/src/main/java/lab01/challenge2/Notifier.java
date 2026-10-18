package lab01.challenge2;

public interface Notifier {
    void send(String to, String text);
}

class EmailSender implements Notifier {
    public void send(String to, String text) {
        System.out.println("[email] " + to + " : " + text);
    }
}