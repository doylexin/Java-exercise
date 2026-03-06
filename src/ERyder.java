public class ERyder {
    private String bikeID;
    private int batteryLevel;
    private boolean isAvailable;
    private double kmDriven;
    public ERyder() {
    }
    public ERyder(String bikeID, int batteryLevel, boolean isAvailable, double kmDriven) {
        this.bikeID = bikeID;
        this.batteryLevel = batteryLevel;
        this.isAvailable = isAvailable;
        this.kmDriven = kmDriven;


    }
    public void ride(){
        if (isAvailable && batteryLevel > 0) {
            System.out.println("The bike is available.");
        }

        else {
            System.out.println("The bike is not available.");
        }
    }
    public void  printBikeDetails(){
        System.out.println("Bike ID: " + bikeID);
        System.out.println("Battery Level: " + batteryLevel + "%");
        System.out.println("Availability: " + (isAvailable ? "Available" : "Not Available"));
        System.out.println("Kilometers Driven: " + kmDriven + " km");
    }
    public String getBikeID() {
        return bikeID;
    }
    public void setBikeID(String bikeID) {
        this.bikeID = bikeID;
    }
    public int getBatteryLevel() {
        return batteryLevel;
    }
    public void setBatteryLevel(int batteryLevel) {
        if(batteryLevel < 0 || batteryLevel > 100) {
            System.out.println("Battery level must be between 0 and 100.");
            return;
        }
        this.batteryLevel = batteryLevel;
    }
}
