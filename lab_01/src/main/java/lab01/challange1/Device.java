package lab01.challange1;

abstract class Device {
    private String name;
    private boolean on;

    public Device(String name) {
        setName(name);
        this.on = false;
    }

    public void setName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("A device's name must not be empty");
        }
        this.name = name;
    }

    public void turnOn() {
        this.on = true;
    }

    public void turnOff() {
        this.on = false;
    }

    public String getName() {
        return name;
    }

    public String devicePowerStatus() {
        if (on) {
            return "On";
        } else {
            return "Off";
        }
    }

    abstract double powerUsage();

    abstract String status();
}
