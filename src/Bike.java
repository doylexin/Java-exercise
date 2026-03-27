import java.time.LocalDateTime;

public class Bike {
    private String bikeID;
    private boolean isAvailable;
    private int batteryLevel;
    private LocalDateTime lastYsedTime;
    private String location;

    public Bike(String bikeID, boolean isAvailable,int batteryLevel, LocalDateTime lastUsedTime, String location){
        this.bikeID = bikeID;
        this.isAvailable = isAvailable;
        this.batteryLevel = batteryLevel;
        this.lastYsedTime = lastUsedTime;
        this.location = location;
    }

    public String getBikeID() {
        return bikeID;
    }
    public boolean isAvailable() {
        return isAvailable;
    }
    public int getBatteryLevel() {
        return batteryLevel;
    }
    public LocalDateTime getLastUsedTime() {
        return lastYsedTime;
    }
    public String getLocation() {
        return location;
    }
    public void setBikeID(String bikeID) {
        this.bikeID = bikeID;
    }
    public void setIsAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }
    public void setBatteryLevel(int batteryLevel) {
        this.batteryLevel = batteryLevel;
    }
    public void setLastUsedTime(LocalDateTime lastUsedTime) {
        this.lastYsedTime = lastUsedTime;
    }
    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString(){
        return "BikeDetails" + "\nBikeID: " + bikeID
                + "\nIs Available: " + isAvailable
                + "\nBattery Level: " + batteryLevel + "%"
                + "\nLast Used Time: " + lastYsedTime
                + "\nLocation: " + location;
    }



}
