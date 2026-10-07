package lab01.challenge1;

public class Light extends Device{
    private int brightness;

    public Light()
    {
        super();
        brightness = 0;
    }
    public Light(String name, String status, int brightness)
    {
        super(name, status);
        if(status.compareTo("on")==0)
            this.brightness = brightness;
        else
            this.brightness = 50;
    }

    public int getBrightness(){ return this.brightness; }
    public void setBrightness(int x) throws IllegalArgumentException
    {   if(x>100 || x<0)
            throw new IllegalArgumentException("Brightness should be between 0 and 100.");
        else if(getState().compareTo("on")==0)
            this.brightness = x;
    }

    @Override
    public double powerUsage() {
        if(this.getState().compareTo("off")==0)
            return 0;
        else
            return (double)brightness * 0.1;
    }

    @Override
    public String status()
    {
        return getName() + " is " + getState() + " and the brightness is " + getBrightness();
    }
}
