package lab01.challenge1;

public class Thermostat extends Device {
    private int targetTemperature;

    public Thermostat(String name, int targetTemperature) {
        super(name);
        setTargetTemperature(targetTemperature);
    }

    public void setTargetTemperature(int targetTemperature) {
        if (targetTemperature < 16 || targetTemperature > 28) {
            throw new IllegalArgumentException("Target temperature must be between 16 and 28 °C.");
        }
        this.targetTemperature = targetTemperature;
    }

    public int getTargetTemperature() {
        return targetTemperature;
    }

    @Override
    public double powerUsage() {
        if (!isOn()) {
            return 0.0;
        }
        return 50.0;
    }

    @Override
    public String status() {
        return "Thermostat *" + getName() + "* is " + (isOn() ? "ON (Target Temp: " + targetTemperature + "°C)" : "OFF");
    }
}