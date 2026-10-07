package lab01.challange1;

public class Thermostat extends Device {
    private double temperature;
    private int powerUsage = 50;

    public Thermostat(String name, double temperature) {
        super(name);
        setTemperature(temperature);
    }
    public final void setTemperature(double temperature) {
        if(temperature < 16 || temperature > 28) {
            throw new IllegalArgumentException("Temperature must be between 16 and 28 degrees Celsius");
        }
        this.temperature = temperature;
    }

    public double getTemperature() {
        return temperature;
    }

    @Override
    public double powerUsage() {
        return isOn() ? 50 : 0;
    }

    @Override
    public String status() {
        return "Thermostat is " + (isOn() ? "on" : "off")
                + ", target temperature: " + temperature + "C";
    }

}
