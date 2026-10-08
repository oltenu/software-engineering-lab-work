package lab01.challenge1;

public class Thermostat extends Device {
    private double temp;

    public Thermostat(String name, double temp) {
        super(name);
        setTemp(temp);
    }

    public void setTemp(double temp) {
        if (temp < 16 || temp > 28) {
            throw new IllegalArgumentException("Eroare: 16-28");
        }
        this.temp = temp;
    }

    @Override
    public double powerUsage() {
        return isOn() ? 50 : 0;
    }

    @Override
    public String status() {
        return getName() + (isOn() ? " ON " : " OFF ") + temp + "C";
    }
}