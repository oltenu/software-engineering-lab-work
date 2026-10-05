package lab01.challenge1;

public class SecurityCamera extends Device {
    private boolean isRecording;

    public SecurityCamera(String name, boolean isRecording) {
        super(name);
        this.isRecording = isRecording;
    }

    public void setRecording(boolean recording) {
        this.isRecording = recording;
    }

    public boolean isRecording() {
        return isRecording;
    }

    @Override
    public double powerUsage() {
        if (!isOn()) {
            return 0.0;
        }
        return isRecording ? 8.0 : 5.0;
    }

    @Override
    public String status() {
        return "Security Camera *" + getName() + "* is " + (isOn() ? "ON (Recording: " + isRecording + ")" : "OFF");
    }
}