package lab01.challange1;

import java.util.ArrayList;
import java.util.List;
//Abstraction : Device este o clasa abstracta care doar zice ce face nu si cum face.
//Encapsulation : variabilele sunt private si pot fi accesate doar prin metodele valide. In Device se vede in metoda setName care verifica daca numele este null sau gol si arunca o exceptie daca nu e valid.
//Inheritance : Thermostat, Light si SecurityCamera mostenesc clasa Device si implementeaza metodele abstracte powerUsage si status.
//Polymorphism : metodele sunt override in clasele Thermostat, Light si SecurityCamera, fiecare avand implementarea proprie a metodei powerUsage si status.
public class SmartHome {
    private final List<Device> devices =new ArrayList<>();
    public void addDevice(Device device) {
        devices.add(device);
    }
    public void totalPowerUsage() {
        double totalPower = 0;
        for (Device device : devices) {
            totalPower += device.powerUsage();
        }
        System.out.println("Total power usage: " + totalPower + " watts");
    }

    public void turnEverythingOff() {
        for (Device device : devices) {
            device.turnOff();
        }
    }

    public void printStatus() {
        for (Device device : devices) {
            System.out.println(device.status());
        }
    }

    public static void run() {
        SmartHome smartHome = new SmartHome();
        Light  light = new Light("Living Room Light", 75);
       Thermostat thermostat = new Thermostat("Main Thermostat", 22);
        SecurityCamera securityCamera = new SecurityCamera("Front Door Camera");

        light.turnOn();
        thermostat.turnOn();
        securityCamera.turnOn();
        securityCamera.setRecording(true);

        smartHome.addDevice(light);
        smartHome.addDevice(thermostat);
        smartHome.addDevice(securityCamera);

        smartHome.printStatus();
        smartHome.totalPowerUsage();

        smartHome.turnEverythingOff();
        smartHome.printStatus();
        smartHome.totalPowerUsage();

        try {
            light.setBrightness(150);
            } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

}
