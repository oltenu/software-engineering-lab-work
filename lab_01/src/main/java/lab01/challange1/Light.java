package lab01.challange1;

public class Light extends Device {

    private int brightness;
    public Light(String name, int brightness) {
        super(name);
        setBrightness(brightness);
    }
    public final void setBrightness(int brightness) {
        if(brightness < 0 || brightness > 100) {
            throw new IllegalArgumentException("Brightness must be between 0 and 100");
        }
        this.brightness = brightness;
    }
    @Override
    public double powerUsage() {
        return isOn() ? brightness * 0.1 : 0;
    }

    @Override
    public String status() {
        if (!isOn()) {
            return "Light is off";
        }
        return "Light is on, brightness: " + brightness + "%";
    }

}
