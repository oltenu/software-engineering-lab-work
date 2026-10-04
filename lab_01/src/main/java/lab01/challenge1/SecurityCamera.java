package lab01.challenge1;

public class SecurityCamera extends Device{
    private boolean record;

    public SecurityCamera(String name) {
        super(name);
        this.record = false;
    }

    public boolean isRecording() {
        return record;
    }

    public void startRecording() {
        record = true;
    }

    public void stopRecording() {
        record = false;
    }

    @Override
    public void turnOff() {
        super.turnOff();
        record = false;
    }

    @Override
    public double powerUsage() {
        if(!isOn()) {
            return 0;
        }

        if(record) {
            return 8;
        }

        return 5;
    }

    @Override
    public String status() {
        return getName() + ", Security Camera, on: " + isOn() + ", recording: " + record + ", power: " + powerUsage() + " Watt";
    }


}
