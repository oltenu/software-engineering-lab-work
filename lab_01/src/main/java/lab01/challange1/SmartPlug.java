package lab01.challange1;

public class SmartPlug extends Device {
    private double connectedDevicePower;

    public SmartPlug(String name, double connectedDevicePower) {
        super(name);
        setConnectedDevicePower(connectedDevicePower);
    }

    public void setConnectedDevicePower(double connectedDevicePower) {
        if (connectedDevicePower < 0) {
            throw new IllegalArgumentException("Power cannot be negative");
        }

        this.connectedDevicePower = connectedDevicePower;
    }

    @Override
    double powerUsage() {
        if (devicePowerStatus().equals("On")) {
            return connectedDevicePower;
        }
        return 0;
    }

    @Override
    String status() {
        return getName() + "\n" + "Status: " + devicePowerStatus() + "\n" + "Connected device power: " + connectedDevicePower + "W\n" + "Power Usage: " + powerUsage() + "W\n";
    }
}
