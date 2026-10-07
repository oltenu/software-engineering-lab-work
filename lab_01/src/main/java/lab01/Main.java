package lab01;


import lab01.challange1.SmartHome;
import lab01.challenge2.Activator;

public class Main {

    public static void main(String[] args) {
        System.out.println("=== Challenge 1: SmartHome showing ===");
        SmartHome.run();

        System.out.println();
        System.out.println("=== Challenge 2: Refactoring  ===");
        Activator.run();
    }
}
