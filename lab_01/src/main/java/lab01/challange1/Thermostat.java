package lab01.challange1;

public class Thermostat extends Device {
    private double temperature;

    public Thermostat(String name, double temperature) {
        super(name);
        setTemperature(temperature);
    }

    public void setTemperature(double temperature) {
        if (temperature < 16 || temperature > 28) {
            throw new IllegalArgumentException("Temperature must be between 16 and 28");
        }
        this.temperature = temperature;
    }

    @Override
    double powerUsage() {
        if (devicePowerStatus().equals("On")) {
            return 50;
        }
        return 0;
    }

    @Override
    String status() {
        return getName() + "\n" + "Status: " + devicePowerStatus() + "\n" + "Temperature: " + temperature + "\n" + "Power Usage: " + powerUsage() + "W\n";
    }
}
