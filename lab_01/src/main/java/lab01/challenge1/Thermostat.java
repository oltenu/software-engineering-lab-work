package lab01.challenge1;

public class Thermostat extends Device{
    private int temperature;

    public Thermostat(String name, int temperature) {
        super(name);
        setTemperature(temperature);
    }

    public void setTemperature(int temperature){
        if(temperature < 16 || temperature > 28){
            throw new IllegalArgumentException("Temperature must be between 16 and 28");
        }
        this.temperature = temperature;
    }

    @Override
    public double powerUsage() {
        if(getState() == false){
            return 0;
        }
        return 50.0;
    }

    @Override
    public String status() {
        return "Thermostat " + getName() + " is " + (getState() ? "on" : "off") + " temperature " + temperature;
    }

    public int getTemperature() {
        return temperature;
    }
}
