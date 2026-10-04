package lab01.challenge1;

public class Thermostat extends Device{
    public double targetTemp;

    public Thermostat(String name, double targetTemp) {
        super(name);
        setTargetTemp(targetTemp);
    }

    public double getTargetTemp() {
        return targetTemp;
    }

    public void setTargetTemp(double targetTemp) {
        if(targetTemp < 16 || targetTemp > 28) {
            throw new IllegalArgumentException("Temperature must be between 16 and 28 degrees");
        }

        this.targetTemp = targetTemp;
    }

    @Override
    public double powerUsage() {
        if(!isOn()) {
            return 0;
        }

        return 50;
    }

    @Override
    public String status() {
        return getName() + ", on: " + isOn() + ", target temperature: " + targetTemp + ", power: " + powerUsage() + " Watt";
    }
}
