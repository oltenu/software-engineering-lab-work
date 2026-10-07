package lab01.challenge1;

public abstract class Device {
    private String name;
    private boolean state;

    public Device(String name){
        if(name==null|| name.isEmpty()){
            throw new IllegalArgumentException("Put a name for this device");
        }
        this.name=name;
        this.state=false;
    }
    public void turnOn(){
        this.state=true;
    }
    public void turnOff() {
        this.state=false;
    }

    public String getName(){
        return name;
    }

    public boolean getState(){
        return state;
    }
    public abstract double powerUsage();
    public abstract String status();

}
