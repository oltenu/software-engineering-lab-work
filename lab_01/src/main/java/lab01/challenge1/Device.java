package lab01.challenge1;

public abstract class Device {
    private String name;
    private boolean isOn;

    public Device(String name) {
        setName(name);
        this.isOn = false;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Nume invalid");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean isOn() {
        return isOn;
    }

    public void turnOn() {
        this.isOn = true;
    }

    public void turnOff() {
        this.isOn = false;
    }

    public abstract double powerUsage();
    public abstract String status();
}