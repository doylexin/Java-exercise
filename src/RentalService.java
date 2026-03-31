import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.Iterator;
import java.util.Scanner;

public class RentalService {
    private BikeService bikeService = new BikeService();
    private UserRegistration userRegistration = new UserRegistration();
    private LinkedList<ActiveRental> activeRentalsList = new LinkedList<>();
    private Scanner scanner = new Scanner(System.in);
    private String emailAddress;

    public void simulateApplicationInput() {
        System.out.println("This is the simulation of the e-bike rental process.");
        boolean isRegisteredUser = scanner.nextBoolean();
        scanner.nextLine();
        emailAddress = scanner.nextLine();
        String location = scanner.nextLine();
        System.out.println("Simulating the analysis of the rental request.");
        String bikeID = analyseRequest(isRegisteredUser, emailAddress, location);
        if (!bikeService.isLocationValid()) {
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
        if (isRegisteredUser) {
            System.out.println("Welcome back, " + emailAddress + "!");
        } else {
            System.out.println("You’re not our registered user. Please consider registering.");
            userRegistration.registration();
        }
        return bikeService.validateLocationAndFindBike(location);
    }

    private void reserveBike(String bikeID) {
        bikeService.reserveBike(bikeID);
        if (bikeID != null) {
            LocalDateTime tripStartTime = LocalDateTime.now();
            ActiveRental activeRental = new ActiveRental(bikeID, emailAddress, tripStartTime);
            activeRentalsList.add(activeRental);
        }
    }

    public void viewActiveRentals() {
        if (activeRentalsList.isEmpty()) {
            System.out.println("No active rentals at the moment.");
        } else {
            for (ActiveRental trip : activeRentalsList) {
                System.out.println(trip);
            }
        }
    }

    private void removeTrip(String bikeID) {
        Iterator<ActiveRental> rentalIterator = activeRentalsList.iterator();
        while (rentalIterator.hasNext()) {
            ActiveRental rentalBike = rentalIterator.next();
            if (rentalBike.getBikeID().equals(bikeID)) {
                rentalIterator.remove();
                break;
            }
        }
        bikeService.releaseBike(bikeID);
        System.out.println("Your trip has ended. Thank you for riding with us.");
    }

    public void cancelRental(String bikeID) {
        removeTrip(bikeID);
        System.out.println("Rental cancelled for bike: " + bikeID);
    }
}
