package lab01.challenge1;

public abstract class Device {
    private String name;
    private boolean on;

    public Device(String name) {
        if(name == null || name.isBlank()) {
            throw new IllegalArgumentException("The name can't be empty ");
        }
        this.name = name;
        this.on = false;
    }

    public String getName() {
        return name;
    }

    public boolean isOn() {
        return on;
    }

    public void turnOn() {
        on = true;
    }

    public void turnOff() {
        on = false;
    }

    public abstract double powerUsage();

    public abstract String status();
}
