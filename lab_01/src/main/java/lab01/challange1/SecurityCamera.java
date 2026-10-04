package lab01.challange1;

public class SecurityCamera extends Device {
    private boolean recording;

    public SecurityCamera(String name, boolean recording) {
        super(name);
        setRecording(recording);
    }

    public void setRecording(boolean recording) {
        this.recording = recording;
    }

    public String isRecording() {
        if (recording && devicePowerStatus().equals("On")) {
            return "Yes";
        }
        return "No";
    }

    @Override
    double powerUsage() {
        if (devicePowerStatus().equals("Off")) {
            return 0;
        }
        if (recording) {
            return 8;
        }
        return 5;
    }

    @Override
    String status() {
        return getName() + "\n" + "Status: " + devicePowerStatus() + "\n" + "Recording: " + isRecording() + "\n" + "Power Usage: " + powerUsage() + "W\n";
    }
}
