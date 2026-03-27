import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.ListIterator;
import java.util.Iterator;


public class BikeRental {
    private boolean isRegisteredUser;
    private String emailAddress;
    private String location;
    private LocalDateTime tripStartTime;
    private String bikeID;
    private boolean locationValid;
    UserRegistration userRegistration = new UserRegistration();
    ActiveRental activeRental;
    LinkedList<ActiveRental> activeRentalsList = new LinkedList<>();

    public void simulateApplicationInput(){
    System.out.println("This is the simulation of the e-bike rental process.");
    Scanner scanner = new Scanner(System.in);
    isRegisteredUser = scanner.nextBoolean();
    scanner.nextLine();
    emailAddress = scanner.nextLine();
    location = scanner.nextLine();
    System.out.println("Simulating the analysis of the rental request.");
    bikeID = analyseRequest(isRegisteredUser, emailAddress, location);
    if(!locationValid){
        return;
    }
    System.out.println("Simulating e-bike reservation…");
    reserveBike(bikeID);
    System.out.println("Displaying the active rentals…");
    viewActiveRentals();
    System.out.println("Simulating the end of the trip…");
    removeTrip(bikeID);
    System.out.println("Displaying the active rentals after trip end…");
    viewActiveRentals();
    }

    private String analyseRequest(boolean isRegisteredUser, String emailAddress, String location) {
        if(isRegisteredUser){
            System.out.println("Welcome back, " + emailAddress + "!");
        }
        else{
            System.out.println("You’re not our registered user. Please consider registering.");
            userRegistration.registration();
        }
        String bikeID = validateLocation(location);
        return bikeID;
    }

    private String validateLocation(String location){
        for(Bike bike : BikeDatabase.bikes){
            if(bike.getLocation().equalsIgnoreCase(location) && bike.isAvailable()){
                locationValid = true;
                return bike.getBikeID();
            }
        }
        locationValid = false;
        System.out.println("Sorry, no bikes are available at the location you requested. Please try again later.");
        return null;
    }

    private void reserveBike(String bikeID){
        if(bikeID == null){
            System.out.println("Sorry, we’re unable to reserve a bike at this time. Please try again later.");
            return;
        }
        else{
            for(Bike bike : BikeDatabase.bikes){
                if(bike.getBikeID().equalsIgnoreCase(bikeID)){
                    tripStartTime = LocalDateTime.now();
                    bike.setIsAvailable(false);
                    bike.setLastUsedTime(tripStartTime);
                    System.out.println("Reserving the bike with the (bikeID). Please following the on-screen instructions to locate the bike and start your pleasant journey.");
                    ActiveRental activeRental = new ActiveRental(bikeID, emailAddress, tripStartTime);
                    activeRentalsList.add(activeRental);
                    break;
                }
            }
        }
    }

    private void viewActiveRentals(){
        if(activeRentalsList.isEmpty()){
            System.out.println("No active rentals at the moment.");
        }
        else{
            for(ActiveRental trip : activeRentalsList){
                System.out.println(trip);
            }
        }
    }

    private void removeTrip(int bikeID) {
        Iterator<ActiveRental> rentalIterator = activeRentalsList.iterator();
        while (rentalIterator.hasNext()) {
            ActiveRental rentalBike = rentalIterator.next();
            if (rentalBike.getBikeID().equals(String.valueOf(bikeID))) {
                rentalIterator.remove(); 
                break;
            }
        }

        Iterator<Bike> bikeIterator = BikeDatabase.bikes.iterator();
        while (bikeIterator.hasNext()) {
            Bike bike = bikeIterator.next();
            if (bike.getBikeID().equals(String.valueOf(bikeID))) {
                bike.setIsAvailable(true);
                bike.setLastUsedTime(LocalDateTime.now());
                System.out.println("Your trip has ended. Thank you for riding with us.");
                break; 
            }
        }
    }
}
