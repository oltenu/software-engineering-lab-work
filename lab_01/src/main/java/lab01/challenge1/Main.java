package lab01.challenge1;

public class Main {

    public static void main(String[] args) {
        SmartHome home = new SmartHome();

        Light livingRoomLight = new Light("Living Room", 80);
        Thermostat hallThermostat = new Thermostat("Hallway", 22);
        SecurityCamera frontCamera = new SecurityCamera("Front Door");

        home.addDevice(livingRoomLight);
        home.addDevice(hallThermostat);
        home.addDevice(frontCamera);

        // Pornim cateva dispozitive pentru a vedea diferenta la consum
        livingRoomLight.turnOn();
        frontCamera.turnOn();
        frontCamera.setRecording(true);

        // 2. Afișam statusul initial si consumul total
        System.out.println("--- Status Initial ---");
        home.printStatus();
        System.out.println("Total power usage: " + home.totalPowerUsage() + " W\n");

        // 3. Oprim tot si afișam din nou
        System.out.println("--- Oprim Tot ---");
        home.turnEverythingOff();
        home.printStatus();
        System.out.println("Total power usage: " + home.totalPowerUsage() + " W\n");

        // 4. Demonstram incapsularea
        System.out.println("--- Testare Incapsulare ---");
        try {
            System.out.println("Incercam sa setam luminozitatea la 150...");
            livingRoomLight.setBrightness(150);
        } catch (IllegalArgumentException e) {
            System.out.println("Eroare prinsa cu succes: " + e.getMessage());
        }
    }
}
