package lab01.challenge1;

public class Light extends Device {
    private int brightness;

    public Light(String name, int brightness) {
        super(name);
        setBrightness(brightness);
    }

    public void setBrightness(int brightness) {
        if (brightness < 0 || brightness > 100) {
            throw new IllegalArgumentException("Luminozitatea trebuie sa fie intre 0 si 100%");
        }
        this.brightness = brightness;
    }

    @Override
    public double powerUsage() {
        if (!isOn()) return 0.0;
        return brightness * 0.1;
    }

    @Override
    public String status() {
        String state = isOn() ? "pornit" : "oprit";
        return getName() + " este " + state + " la luminozitate " + brightness + "%";
    }
}