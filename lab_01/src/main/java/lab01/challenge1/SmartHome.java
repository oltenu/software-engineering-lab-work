package lab01.challenge1;

import java.util.ArrayList;
import java.util.List;

/*
1. Abstractizarea:
 - Device este clasa abstracta
 - Ea defineste metode abstracte, precum : powerUsage() si status()

2. Incapsularea:
 - am implementat incapsularea prin:
      * campuri private
      * modificarea valorilor campurilor prin metode

3. Mostenirea:
 - clasele Light, Thermostat si SecurityCamera extind clasa Device

4. Polimorfismul:
 - SmartHome pastreaza obiecte de tipuri diferite in List<Device>
*/


public class SmartHome {
    private List<Device> devices;

    public SmartHome() {
        devices = new ArrayList<>();
    }

    public void addDevice(Device d) {
        devices.add(d);
    }

    public double totalPowerUsage() {
        double total = 0;

        for(Device d : devices) {
            total += d.powerUsage();
        }

        return total;
    }

    public void turnEverythingOff() {
        for(Device d : devices) {
            d.turnOff();
        }
    }

    public void printStatus() {
        for(Device d : devices) {
            System.out.println(d.status());
        }
    }

    public static void run() {
        SmartHome home = new SmartHome();
        Light light = new Light("Bedroom light", 50);
        Thermostat thermostat = new Thermostat("Bedroom thermostat", 23);
        SecurityCamera camera = new SecurityCamera("Back door camera");

        light.turnOn();
        thermostat.turnOn();
        camera.turnOn();
        camera.startRecording();

        home.addDevice(light);
        home.addDevice(thermostat);
        home.addDevice(camera);

        System.out.println("Smart home status:");
        home.printStatus();

        System.out.println("Total power usage: " + home.totalPowerUsage() + " Watt" );

        home.turnEverythingOff();
        home.printStatus();
        System.out.println("Total power usage after turning everything off: " + home.totalPowerUsage() + " Watt");



    }
}
