package lab01.challenge1;

public class Light extends Device {
    private int brightness;

    public Light(String name, int brightness) {
        super(name);
        setBrightness(brightness);
    }

    public void setBrightness(int brightness) {
        if (brightness < 0 || brightness > 100) {
            throw new IllegalArgumentException("Eroare: 0-100");
        }
        this.brightness = brightness;
    }

    @Override
    public double powerUsage() {
        return isOn() ? brightness * 0.1 : 0;
    }

    @Override
    public String status() {
        return getName() + (isOn() ? " ON " : " OFF ") + brightness + "%";
    }
}