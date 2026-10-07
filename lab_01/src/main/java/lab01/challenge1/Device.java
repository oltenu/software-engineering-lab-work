package lab01.challenge1;

public abstract class Device {
    private String name;
    private boolean state;

    public Device(String name) {
        setName(name);
        this.state = false;
    }

    public void setName(String name){
        if(name == null){
            throw new IllegalArgumentException("Name cannot be null");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean getState() {
        return state;
    }

    public void turnOn() {
        this.state = true;
    }

    public void turnOff() {
        this.state = false;
    }

    public abstract double powerUsage();
    public abstract String status();
}
