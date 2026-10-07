package lab01.challange1;

public abstract class Device {
    private boolean state;
    private String name;


    Device(String name) {
        setName(name);
    }
    public final void setName(String name) {
        if(name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
    }
    public final String getName() {
        return name;
    }

    protected  boolean isOn() {
        return state;
    }

    public  void turnOn() {
        state = true;
    }

    public void turnOff() {
        state = false;
    }

    public abstract double powerUsage();

    public abstract String status();
}
