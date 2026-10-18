package lab01.challenge1;

import java.util.ArrayList;
import java.util.List;

/*
 * Cele 4 principii de programare (OOP) aplicate aici:
 * 1. (Abstractizare): Am folosit o clasa abstracta "Device" care ascunde detaliile tehnice.
 * 2. (Incapsulare): Datele precum luminozitatea sau temperatura sunt private (ascunse) si se pot modifica doar prin functii sigure (ex. setBrightness)
 * 3.(Mostenire): Becul, Termostatul si Camera iau toate optiunile de baza (nume, pornit/oprit) de la parintele lor, clasa "Device"
 * 4.(Polimorfism): "SmartHome" trateaza toate obiectele la fel (le vede pe toate pur si simplu ca "Device" intr-o listă) fara sa verifice specific ce fel de aparat este fiecare.
 */
public class SmartHome {

    private final List<Device> devices = new ArrayList<>();

    public void addDevice(Device device) {
        if (device == null) {
            throw new IllegalArgumentException("Dispozitivul lipseste!");
        }
        devices.add(device);
    }

    public double totalPowerUsage() {
        double total = 0;
        for (Device d : devices) {
            total += d.powerUsage();
        }
        return total;
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

        // Cream aparatele
        Light livingRoomLight = new Light("Lumină Sufragerie", 80);
        livingRoomLight.turnOn();

        Thermostat hallThermostat = new Thermostat("Termostat Hol", 22);
        hallThermostat.turnOn();

        SecurityCamera frontDoorCamera = new SecurityCamera("Cameră Intrare", true);
        frontDoorCamera.turnOn();

        // Le adaugam în casa inteligenta
        home.addDevice(livingRoomLight);
        home.addDevice(hallThermostat);
        home.addDevice(frontDoorCamera);

        // Afisam statusul
        System.out.println("--- Status Inițial ---");
        home.printStatus();
        System.out.println("Consum total: " + home.totalPowerUsage() + " Wați");

        // Oprim tot
        System.out.println("\n--- Oprire Totala");
        home.turnEverythingOff();
        home.printStatus();
        System.out.println("Consum total: " + home.totalPowerUsage() + " Wați");

        System.out.println("\n--- Testare Eroare Controlata ---");
        try {
            livingRoomLight.setBrightness(150);
        } catch (IllegalArgumentException e) {
            System.out.println("Am prins eroarea: " + e.getMessage());
        }
    }
}