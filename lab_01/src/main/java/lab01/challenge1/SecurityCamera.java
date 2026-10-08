package lab01.challenge1;

public class SecurityCamera extends Device {
    private boolean recording;

    public SecurityCamera(String name) {
        super(name);
    }

    public void setRecording(boolean recording) {
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
    public String status() {
        return getName() + (isOn() ? " ON " : " OFF ") + (recording ? "REC" : "IDLE");
    }
}