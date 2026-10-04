package lab01.challenge1;

public class Light extends Device {
    private int brightness;

    public Light(String name, int brightness) {
        super(name);
        setBrightness(brightness);
    }

    public int getBrightness() {
        return brightness;
    }

    public void setBrightness(int brightness) {
        if(brightness < 0 || brightness > 100) {
            throw new IllegalArgumentException("Brightness should be between 0 and 100");
        }
        this.brightness = brightness;
    }

    @Override
    public double powerUsage() {
        if(!isOn()) {
            return 0;
        }
        return brightness * 0.1;
    }

    @Override
    public String status() {
        return getName() + ", on: " + isOn() + ", brightness: " + brightness + ", power: " + powerUsage() + " Watt";
    }
}
