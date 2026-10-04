package lab01.challange1;

public class Light extends Device {
    private double brightness;

    public Light(String name, double brightness) {
        super(name);
        setBrightness(brightness);
    }

    public void setBrightness(double brightness) {
        if (brightness < 0 || brightness > 100) {
            throw new IllegalArgumentException("Brightness must be between 0% and 100%");
        }
        this.brightness = brightness;
    }

    @Override
    double powerUsage() {
        if (devicePowerStatus().equals("On")) {
            return brightness * 0.1;
        }
        return 0;
    }

    @Override
    String status() {
        return getName() + "\n" + devicePowerStatus() + "\n" + "Brightness: " + brightness + "\n" + "Power Usage: " + powerUsage() + "W\n";
    }
}
