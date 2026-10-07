package lab01.challenge1;
import java.util.ArrayList;
import java.util.List;

/*
 * OOP Pillars Mapping:
 * - Abstraction: Abstract class Device with abstract methods powerUsage() and status().
 * - Encapsulation: Private fields in Device/subclasses with validation throwing IllegalArgumentException.
 * - Inheritance: Light, Thermostat, and SecurityCamera extending Device using super(...).
 * - Polymorphism: SmartHome managing a List<Device> polymorphically without casts or instanceof.
 */

public class SmartHome {
    private ArrayList<Device> devices;

    public SmartHome(){ }
    public SmartHome(ArrayList<Device> l)
    {
        devices = l;
    }

    public void addDevice(Device d)
    {
        if(!devices.contains(d))
            devices.add(d);
    }

    public double totalPowerUsage()
    {
        double x=0;
        if(devices.isEmpty())
            return 0;
        for(Device d : devices)
        {
            x += d.powerUsage();
        }
        return x;
    }

    public void turnEverythingOff()
    {
        for(Device d: devices )
        {
            d.turnOff();
        }
    }

    public void printStatus()
    {
        for(Device d: devices)
        {
            System.out.println(d.getName() + " is "+ d.getState());
        }
    }

}
