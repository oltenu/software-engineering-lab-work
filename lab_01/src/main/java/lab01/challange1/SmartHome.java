package lab01.challange1;

import java.util.ArrayList;
import java.util.List;

/*
Principiile OOP:

Abstractizare - clasa abstracta Device si metodele abstracte powerUsage() si status()
Incapsulare - campurile sunt private si sunt modificate prin metode care verifica daca valorile sunt valide
Mostenire - clasele Light, Thermostat, SecurityCamera si SmartPlug mostenesc clasa Device
Polimorfism - SmartHome foloseste o lista List<Device>, iar metodele powerUsage(), status() si turnOff() sunt apelate pentru obiecte de tip Device
 */
public class SmartHome {
    private final List<Device> devices = new ArrayList<>();

    public SmartHome() {
    }

    public void addDevice(Device d) {
        if (d != null) {
            devices.add(d);
        } else {
            throw new IllegalArgumentException("Device invalid");
        }
    }

    public double totalPowerUsage() {
        double sum = 0;
        for (Device d : devices) {
            sum += d.powerUsage();
        }
        return sum;
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
        SmartHome home = new SmartHome();

        Light light = new Light("Living Room Light", 70);
        Thermostat thermostat = new Thermostat("Thermostat", 22);
        SecurityCamera camera = new SecurityCamera("Front Camera", true);
        SmartPlug plug=new SmartPlug("TV Smart Plug",100);

        home.addDevice(light);
        home.addDevice(thermostat);
        home.addDevice(camera);
        home.addDevice(plug);

        light.turnOn();
        thermostat.turnOn();
        camera.turnOn();
        plug.turnOn();

        home.printStatus();
        System.out.println("Total power usage: " + home.totalPowerUsage() + "W\n");

        home.turnEverythingOff();
        System.out.println("All devices have been turned off\n");

        home.printStatus();
        System.out.println("Total power: " + home.totalPowerUsage() + "W\n");

        try {
            light.setBrightness(150);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
