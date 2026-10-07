package lab01.challenge1;

import java.util.ArrayList;
import java.util.List;

public class SmartHome {
    private List<Device> devices;

    public SmartHome(){
        this.devices=new ArrayList<>();
    }

    public void addDevice(Device d){
        devices.add(d);
    }

    public double totalPowerUsage(){
        return devices.stream()
                .mapToDouble(Device::powerUsage)
                .sum();
    }

    public void turnEverythingOff(){
        for(Device d:devices){
            d.turnOff();
        }
    }

    public void printStatus(){
        for(Device d:devices){
            System.out.println(d.status());
        }
    }

}
