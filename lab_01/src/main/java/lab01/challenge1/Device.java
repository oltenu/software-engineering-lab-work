package lab01.challenge1;

public abstract class Device {
    private String name;
    private String state;

    public Device()
    {
        name = "-";
        state = "off";
    }

    public Device(String name, String state)
    {
        this.name = name;
        this.state = state;
    }

    public Device(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return this.name;
    }
    public void setName(String n) throws IllegalArgumentException
    {
        if(n.isEmpty())
            throw new IllegalArgumentException("Introduceti un nume!");
        this.name = n;
    }

    public void setState(String s)
    {
        this.state = s;
    }
    public String getState()
    {
        return state;
    }

    public void turnOn()
    {
        state = "on";
    }
    public void turnOff()
    {
        state = "off";
    }
    public abstract double powerUsage();
    //public abstract String status();

}

