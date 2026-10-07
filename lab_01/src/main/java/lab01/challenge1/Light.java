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
        this.brightness = brightness;
    }

    public int getBrightness(){ return this.brightness; }
    public void setBrightness(int x) throws IllegalArgumentException
    {   if(x>100 || x<0)
            throw new IllegalArgumentException("Brightness should be between 0 and 100.")
        this.brightness = x;
    }

    @Override
    public double powerUsage() {
        if(this.getState().compareTo("off")==0)
            return 0;
        else
            return (double)brightness * 0.1;
    }

}
