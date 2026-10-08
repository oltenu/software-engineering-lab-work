package lab01.challenge1;

import java.util.ArrayList;
import java.util.List;

/*
 * Abstraction: clasa Device e abstracta.
 * Encapsulation: campuri private, IllegalArgumentException in metode.
 * Inheritance: clasele Light, Thermostat, Camera extind Device.
 * Polymorphism: Lista List<Device> procesata in comun, fara casturi.
 */
public class SmartHome {
    private List<Device> devices = new ArrayList<>();

    public void addDevice(Device d) {
        devices.add(d);
    }

    public double totalPowerUsage() {
        double t = 0;
        for (Device d : devices) {
            t += d.powerUsage();
        }
        return t;
    }

    public void turnEverythingOff() {
        for (Device d : devices) {
            d.turnOff();
        }
    }

    public void printStatus() {
        for (Device d : devices) {
            System.out.println(d.status());
        }
    }

    public static void run() {
        SmartHome h = new SmartHome();

        Light l = new Light("Bec", 50);
        Thermostat t = new Thermostat("Termostat", 20);
        SecurityCamera c = new SecurityCamera("Camera");

        l.turnOn();
        t.turnOn();
        c.turnOn();
        c.setRecording(true);

        h.addDevice(l);
        h.addDevice(t);
        h.addDevice(c);

        h.printStatus();
        System.out.println("Consum: " + h.totalPowerUsage());

        h.turnEverythingOff();
        h.printStatus();
        System.out.println("Consum: " + h.totalPowerUsage());

        try {
            l.setBrightness(150);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}