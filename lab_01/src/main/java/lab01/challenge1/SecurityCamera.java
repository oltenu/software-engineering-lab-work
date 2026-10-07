package lab01.challenge1;

public class SecurityCamera extends Device{
    private boolean recording;

    public SecurityCamera(String name){
        super(name);
        this.recording=false;
    }

    @Override
    public double powerUsage(){
        if(!getState())
            return 0;
        if(recording)
            return 8;
        else
            return 5;
    }

    @Override
    public String status(){
        String stateDevice=getState() ? "ON":"OFF";
        return "Security Camera "+ getName()+" is "+stateDevice+" recording:"+recording;
    }

    public void setRecording(boolean recording){
        this.recording=recording;
    }

    public boolean isRecording(){
        return recording;
    }

}
