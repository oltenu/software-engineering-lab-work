package lab01.challenge1;

public class SecurityCamera extends Device {
    private boolean isRecording;

    public SecurityCamera(String name, boolean isRecording) {
        super(name);
        this.isRecording = isRecording;
    }

    public void setRecording(boolean isRecording) {
        this.isRecording = isRecording;
    }

    @Override
    public double powerUsage() {
        if (!isOn()) return 0.0;
        return isRecording ? 8.0 : 5.0;
    }

    @Override
    public String status() {
        String state = isOn() ? "pornit" : "oprit";
        String recordingState = isRecording ? "inregistreaza" : "nu înregistrează";
        return getName() + " este " + state + " si " + recordingState;
    }
}