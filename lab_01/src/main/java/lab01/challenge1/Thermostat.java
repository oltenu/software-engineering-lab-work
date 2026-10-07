package lab01.challenge1;

public class Thermostat extends Device{
    private double temperature;

    public Thermostat(String name, double temperature){
        super(name);
        if(temperature<16 || temperature>28)
            throw  new IllegalArgumentException("Temperature mush be between 16 and 28°C");
        this.temperature=temperature;
    }

    @Override
    public double powerUsage(){
        if(!getState())
            return 0;
        return 50;
    }

    @Override
    public String status(){
        String stateDevice=getState() ? "ON":"OFF";
        return "Thermostat "+ getName()+" is "+stateDevice+" temperature:"+temperature+"°C";
    }

    public void setTemperature(double temperature){
        if(temperature<16 || temperature>28){
            throw  new IllegalArgumentException("Temperature mush be between 16 and 28°C");
        }
        this.temperature=temperature;
    }

    public double getTemperature(){
        return temperature;
    }

}
