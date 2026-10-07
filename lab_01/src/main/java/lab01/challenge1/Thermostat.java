package lab01.challenge1;

public class Thermostat extends Device{
    private int temperature;

    public Thermostat()
    {}
    public Thermostat(String name, String state, int temp)
    {
        super(name, state);
        this.temperature = temp;
    }
    public Thermostat(String name, String state)
    {
        super(name, state);
    }

    public int getTemperature(){    return temperature; }
    public void setTemperature(int t)
    {
        if(this.getState().compareTo("on")==0)
            this.temperature = t;
        else
            System.out.println("Turn on the Thermostat to set the temperature!");
    }

    public double powerUsage()
    {
        if(this.getState().compareTo("off")==0)
            return 0;
        return 50;
    }

}
