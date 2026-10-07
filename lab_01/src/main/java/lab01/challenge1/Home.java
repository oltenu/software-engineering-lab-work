package lab01.challenge1;

public class Home{
    public void run()
    {
        SmartHome h = new SmartHome();
        Light led1 = new Light("Bedroom light", "on", 78);
        Light led2 = new Light("Bathroom light", "off", 20);
        SecurityCamera cam = new SecurityCamera("Cam1", "on", true);
        Thermostat t = new Thermostat("Therm", "off");

        h.addDevice(led1);
        h.addDevice(led2);
        h.addDevice(cam);
        h.addDevice(t);

        h.printStatus();
        double power = h.totalPowerUsage();
        System.out.println("Total power usage:"+ power );
        System.out.println(" ");

        h.turnEverythingOff();
        h.printStatus();
        power = h.totalPowerUsage();
        System.out.println("Total power usage:"+ power );

        try{
            led2.setName("on");
            led2.setBrightness(150);
        }catch (IllegalArgumentException e)
        {
            led2.setBrightness(100);
            System.out.println("100 is the maximum brightness!");
        }

    }
