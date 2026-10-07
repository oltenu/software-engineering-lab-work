package lab01.challenge1;

public class SecurityCamera extends Device{
    private boolean recording; //0-not recording //1-recording

    public SecurityCamera()
    {}
    public SecurityCamera(String name, String status, boolean r)
    {
        super(name, status);
        this.recording = r;
    }

    public void setRecording(boolean recording) {
            this.recording = recording;
    }
    public boolean isRecording()
    {
        return this.recording;
    }

    public double powerUsage()
    {
        if(this.getState().compareTo("on")==0)
            if(isRecording()==true)
                return 8;
            else
                return 5;
        else
                return 0;
    }

    @Override
    public void turnOn()
    {
        setState("on");
        this.recording = true;
    }

    @Override
    public void turnOff()
    {
        setState("off");
        this.recording = false;
    }

}
