
//Abstractie: Device este clasa abstracta, cu metodele abstracte powerUsage() si status(), astfel ascunzand implementarea exacta.
//Encapsulare: Atributele name, state, brightness, temperature si isRecording sunt private, fiind accesibile doar prin settere si gettere.
//Polimorfism: Lista de dispozitive din SmartHome foloseste tipul general Device, permitand adaugarea de obiecte de tip Light, Thermostat si SecurityCamera.
//Mostenire: Clasele Light, Thermostat si SecurityCamera mostenesc clasa abstracta Device, reutilizand codul comun si implementand metodele specifice.

package lab01.challenge1;

import java.util.ArrayList;
import java.util.List;

public class SmartHome {
    private List<Device> devices;

    public SmartHome(){
        this.devices = new ArrayList<>();
    }

    public void addDevice(Device device){
        this.devices.add(device);
    }

    public void totalPowerUsage(){
        double totalPower = 0;
        for(Device device : devices){
            totalPower += device.powerUsage();
        }
        System.out.println("Total power usage: " + totalPower + " watts");
    }

    public void turnEverythingOff(){
        for(Device device : devices){
            device.turnOff();
        }
    }

    public void printStatus(){
        for(Device device : devices){
            System.out.println(device.status());
        }
    }

    public static void run(){
        SmartHome home = new SmartHome();

        Light light1 = new Light("Living Room Light", 75);
        Thermostat thermostat1 = new Thermostat("Main Thermostat", 22);
        SecurityCamera camera1 = new SecurityCamera("Front Door Camera", true);

        light1.turnOn();
        thermostat1.turnOn();
        camera1.turnOn();

        home.addDevice(light1);
        home.addDevice(thermostat1);
        home.addDevice(camera1);

        System.out.println("Initial status:");
        home.printStatus();

        System.out.println("\nTotal power usage:");
        home.totalPowerUsage();

        light1.turnOff();
        thermostat1.turnOff();
        camera1.turnOff();

        System.out.println("\nStatus after turning everything off:");
        home.printStatus();

        try{
            light1.setBrightness(90);
        } catch (IllegalArgumentException e){
            System.out.println("\nError: " + e.getMessage());
        }
    }

}
