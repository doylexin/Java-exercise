import java.time.LocalDateTime;

public class BikeService {
    private boolean locationValid;

    public String validateLocationAndFindBike(String location) {
        for (Bike bike : BikeDatabase.bikes) {
            if (bike.getLocation().equalsIgnoreCase(location) && bike.isAvailable()) {
                locationValid = true;
                return bike.getBikeID();
            }
        }
        locationValid = false;
        System.out.println("Sorry, no bikes are available at the location you requested. Please try again later.");
        return null;
    }

    public void reserveBike(String bikeID) {
        if (bikeID == null) {
            System.out.println("Sorry, we’re unable to reserve a bike at this time. Please try again later.");
            return;
        }
        for (Bike bike : BikeDatabase.bikes) {
            if (bike.getBikeID().equalsIgnoreCase(bikeID)) {
                bike.setIsAvailable(false);
                bike.setLastUsedTime(LocalDateTime.now());
                System.out.println("Reserving the bike with the (bikeID). Please following the on-screen instructions to locate the bike and start your pleasant journey.");
                break;
            }
        }
    }

    public void releaseBike(String bikeID) {
        for (Bike bike : BikeDatabase.bikes) {
            if (bike.getBikeID().equalsIgnoreCase(bikeID)) {
                bike.setIsAvailable(true);
                bike.setLastUsedTime(LocalDateTime.now());
                break;
            }
        }
    }

    public boolean isLocationValid() {
        return locationValid;
    }
}
