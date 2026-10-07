package lab01.challange1;

public class SecurityCamera extends Device {
    private boolean recording;

    public SecurityCamera(String name) {
        super(name);
    }

    public final void setRecording(boolean recording) {
        this.recording = recording;
    }

    @Override
    public double powerUsage() {
        if (!isOn()) {
            return 0;
        }
        return recording ? 8 : 5;
    }
    @Override
    public void turnOff() {
        super.turnOff();
        setRecording(false);
    }

    @Override
    public String status() {
        return "Security camera is " + (isOn() ? "on" : "off")
                + (recording ? " and recording" : " and not recording");
    }
}