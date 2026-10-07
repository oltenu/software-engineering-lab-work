package lab01.challenge2;

public class FileOrderRepository implements OrderRepository{

    @Override
    public void save(String email, double total) {
        System.out.println("[file] " + email + ";" + total);
    }
}
