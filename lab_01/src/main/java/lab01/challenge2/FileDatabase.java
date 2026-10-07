package lab01.challenge2;

public class FileDatabase implements OrderRepository {
    @Override
    public void save(String line) {
        System.out.println("[file] " + line);
    }
}