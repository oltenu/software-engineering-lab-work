package lab01.challenge1;

public class SecurityCamera extends Device{
    private boolean isRecording;

    public SecurityCamera(String name, boolean isRecording){
        super(name);
        this.isRecording = isRecording;
    }

    public void setRecording(boolean recording){
        this.isRecording = recording;
    }

    @Override
    public double powerUsage() {
        if(getState() == false){
            return 0;
        }
        if(isRecording){
            return 8.0;
        }
        return 5.0;
    }

    @Override
    public String status() {
        return "Security Camera " + getName() + " is " + (getState() ? "on" : "off") + " and is " + (isRecording ? "recording" : "not recording");
    }
}
