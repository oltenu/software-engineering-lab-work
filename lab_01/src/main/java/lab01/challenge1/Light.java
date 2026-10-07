package lab01.challenge1;

public class Light extends Device{
    private double brightness;
    public Light(String name, double brightness){
        super(name);
        if(brightness<0 || brightness>100)
            throw new IllegalArgumentException("Brightness mush be between 0 and 100");
        this.brightness=brightness;
    }

    @Override
    public double powerUsage(){
        return brightness*0.1;
    }

    @Override
    public String status(){
        String stateDevice=getState() ? "ON":"OFF";
        return "Light "+ getName()+" is "+stateDevice+" brightness:"+brightness+"%";
    }

    public void setBrightness(double brightness){
        if(brightness<0 || brightness>100)
            throw new IllegalArgumentException("Brightness mush be between 0 and 100");
        this.brightness=brightness;
    }

    public double getBrightness(){
        return brightness;
    }

}
