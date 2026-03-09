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
        if(isAvailable && batteryLevel > 0) {
            System.out.println("Available");
        } else {
            System.out.println("Not Available");
        }
        System.out.println("Kilometers Driven: " + kmDriven + " km");
    }
    public void setBikeID(String bikeID) {
        this.bikeID = bikeID;
    } 
    public void setBatteryLevel(int batteryLevel) {
        if(batteryLevel > 0 && batteryLevel < 100) {
            this.batteryLevel = batteryLevel;
        }
        else{
            this.batteryLevel = 0;
        }
    }
}
