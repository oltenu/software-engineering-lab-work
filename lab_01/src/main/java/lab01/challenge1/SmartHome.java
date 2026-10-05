package lab01.challenge1;

import java.util.ArrayList;
import java.util.List;

public class SmartHome {
    private final List<Device> devices;

    public SmartHome() {
        devices = new ArrayList<>();
    }

    public void addDevice(Device device) {
        devices.add(device);
    }

    public double totalPowerUsage() {
        double total = 0;
        for (Device device : devices) {
            total += device.powerUsage();
        }
        return total;
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

    public static void main(String[] args) {
        SmartHome home = new SmartHome();

        Light porchLight = new Light("Porch Light", 80);
        porchLight.turnOn();

        Thermostat livingRoomThermostat = new Thermostat("Living Room Thermostat", 22);
        livingRoomThermostat.turnOn();

        SecurityCamera frontDoorCamera = new SecurityCamera("Front Door Camera", true);
        frontDoorCamera.turnOn();

        home.addDevice(porchLight);
        home.addDevice(livingRoomThermostat);
        home.addDevice(frontDoorCamera);

        System.out.println("    Initial Status:");
        home.printStatus();
        System.out.println("Total Power Usage: " + home.totalPowerUsage() + " watts\n");

        System.out.println("    Turning Everything Off");
        home.turnEverythingOff();
        home.printStatus();
        System.out.println("Total Power Usage: " + home.totalPowerUsage() + " watts\n");

        System.out.println("    Testing Encapsulation Exception:");
        try {
            porchLight.setBrightness(150);
        } catch (IllegalArgumentException e) {
            System.out.println("Caught exception: " + e.getMessage());
        }
    }
}