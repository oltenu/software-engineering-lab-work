package lab01.challange2;

public class OrderRepository {
    public void save(String email, double total) {
        System.out.println("[file] " + email + ";" + total);
    }
}
