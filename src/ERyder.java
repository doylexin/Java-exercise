public class ERyder {
    private static final String  COMPANY_NAME ="ERyder";
    private static final double  BASE_FARE = 1.0;
    private static final double PER_MINUTE_FARE = 0.5;
    private final String LINKED_ACCOUNT;
    private final long LINKED_PHONE_NUMBER;
    private double totalUsageInMinutes;
    private double totalFare;

    private String bikeID;
    private int batteryLevel;
    private boolean isAvailable;
    private double kmDriven;
    public ERyder(String bikeID, int batteryLevel, boolean isAvailable, double kmDriven) {
        this.bikeID = bikeID;
        this.batteryLevel = batteryLevel;
        this.isAvailable = isAvailable;
        this.kmDriven = kmDriven;
        this.LINKED_ACCOUNT = "Doyle";
        this.LINKED_PHONE_NUMBER = 1234567890;
    }
    public ERyder(String bikeID, int batteryLevel, boolean isAvailable, double kmDriven, String linkedAccount, long linkedPhoneNumber) {
        this.bikeID = bikeID;
        this.batteryLevel = batteryLevel;
        this.isAvailable = isAvailable;
        this.kmDriven = kmDriven;
        this.LINKED_ACCOUNT = linkedAccount;
        this.LINKED_PHONE_NUMBER = linkedPhoneNumber;
    }
    public void printRideDetails(){
        System.out.println("Linked Account: " + LINKED_ACCOUNT);
        System.out.println("Linked Phone Number: " + LINKED_PHONE_NUMBER);
        System.out.println("Total Usage in Minutes: " + totalUsageInMinutes);
        System.out.println("Total Fare: $" + calculateFare(totalUsageInMinutes));
    }
    private double calculateFare(double usageInMinutes) {
        totalFare += BASE_FARE + (PER_MINUTE_FARE * usageInMinutes);
        return totalFare;
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
            this.isAvailable = false;
        }
    }
}
