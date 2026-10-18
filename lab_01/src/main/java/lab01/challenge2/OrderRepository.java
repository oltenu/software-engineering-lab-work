package lab01.challenge2;

public interface OrderRepository {
    void save(String line);
}

class FileDatabase implements OrderRepository {
    public void save(String line) {
        System.out.println("[file] " + line);
    }
}