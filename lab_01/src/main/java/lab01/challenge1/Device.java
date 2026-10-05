package lab01.challenge1;

public abstract class Device {
    private String name;
    private boolean isOn;
    public Device(String name) {
        this.name = name;
        this.isOn = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isOn() {
        return isOn;
    }
    public void turnOn() {
        this.isOn = true;
    }
    public void turnOff(){
        this.isOn = false;
    }

    public abstract double powerUsage();
    public abstract String status();
}
