package lab01.challenge1;

public class Light extends Device{
    private int brightness;

    public Light(String name, int brightness){
        super(name);
        setBrightness(brightness);
    }

    public void setBrightness(int brightness){
        this.brightness = brightness;
    }

    public int getBrightness(){
        return brightness;
    }

    @Override
    public double powerUsage(){
        if(!isOn()){
            return 0.0;
        }
        return brightness*0.1;
    }

    @Override
    public String status(){
        return "Light *"+ getName() + "* is "
 + (isOn() ? "ON (Brightness: " + brightness + "%)" : "OFF");    }

}
