import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class AdminPanel {
    List<RegisteredUsers> registeredUsersList = new ArrayList<>();

    public void userManagementOptions(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to E-Ryder Admininstrator Panel.");
        System.out.println("What doyouwant to do?");
        System.out.println("1. Add New Users");
        System.out.println("2. View Registered Users");
        System.out.println("3. Remove Registered Users");
        System.out.println("4. Update Registered Users");
        System.out.println("5. EXIT");
        System.out.println("6.Demo the Bike Rental System");

        int choice = scanner.nextInt();
        scanner.nextLine();
        switch(choice){
            case 1:
                addNewUsers();
                break;
            case 2:
                viewRegisteredUsers();
                break;
            case 3:
                removeRegisteredUsers();
                break;
            case 4:
                updateRegisteredUsers();
                break;
            case 5:
                return;
            case 6:
                BikeRental bikeRental = new BikeRental();
                bikeRental.simulateApplicationInput();
            default:
                System.out.println("Invalid choice. Please try again");
                userManagementOptions();
                break;
        }
        
    }
    private void addNewUsers(){
        System.out.println("How many users would you like to add");
        Scanner scanner = new Scanner(System.in);
        int numOfUsers = scanner.nextInt();
        scanner.nextLine();
        for (int userIdx = 0; userIdx < numOfUsers; userIdx++) {
            System.out.println("Please enter the following details for user " + (userIdx + 1) + ":");
            String fullName = scanner.nextLine();
            String emailAddress = scanner.nextLine();
            String dateOfBirth = scanner.nextLine();
            long cardNumber = scanner.nextLong();
            scanner.nextLine();
            String cardProvider = scanner.nextLine();
            String cardExpiryDate = scanner.nextLine();
            double feeToCharge = scanner.nextDouble();
            scanner.nextLine();
            int cvv = scanner.nextInt();
            scanner.nextLine();   
            String userType = scanner.nextLine();
            String[] lastThreeTrips = new String[3];
            for(int i = 0;i<3;i++){
                System.out.println("Your last three trips with the date of the trip in YYYY-MM-DD format.");
                String date = scanner.nextLine();
                System.out.println("Source and destination of that trip.");
                String sourceAndDestination = scanner.nextLine();
                System.out.println("Fare charged for that trip.");
                double fareCharged = scanner.nextDouble();
                scanner.nextLine();
                System.out.println("feedback for that trip.");
                String feedback = scanner.nextLine();
                StringBuilder allDetails = new StringBuilder();
                allDetails.append("Date:").append(date).append(", Source and Destination:").append(sourceAndDestination).append(", Fare Charged:").append(fareCharged).append(", Feedback:").append(feedback);
                lastThreeTrips[i] = allDetails.toString();
            }
            RegisteredUsers newUser = new RegisteredUsers(fullName, emailAddress, dateOfBirth,cardNumber, cardProvider, cardExpiryDate,feeToCharge, cvv,userType, lastThreeTrips);

        
            registeredUsersList.add(newUser);
            System.out.println("User " + (userIdx + 1) + " added successfully!\n");
        }
        
    }
    private void viewRegisteredUsers(){
        if(registeredUsersList.isEmpty()){
            System.out.println("No registered users found.");
            return;
        }
        for (RegisteredUsers user : registeredUsersList) {
            System.out.println("Full Name: " + user.getFullName());
            System.out.println("Email Address: " + user.getEmailAddress());
            System.out.println("Date of Birth: " + user.getDateOfBirth());
            System.out.println("Card Number: " + user.getCardNumber());
            System.out.println("Card Provider: " + user.getCardProvider());
            System.out.println("Card Expiry Date: " + user.getCardExpiryDate());
            System.out.println("CVV: " + user.getCvv());
            System.out.println("User Type: " + user.getUserType());
            System.out.println("Last Three Trips:");
            for (String trip : user.getLastThreeTrips()) {
                System.out.println(trip);
            }
            System.out.println();
        }
    }
    private void removeRegisteredUsers(){
        if(registeredUsersList.isEmpty()){
            System.out.println("No registered users found.");
            return;
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the email address of the user you want to remove:");
        String emailToRemove = scanner.nextLine();
        boolean userRemoved = registeredUsersList.removeIf(user -> user.getEmailAddress().equalsIgnoreCase(emailToRemove));
        if (userRemoved) {
            System.out.println("User with email " + emailToRemove + " removed successfully.");
        } else {
            System.out.println("No user found with email " + emailToRemove + ".");
        }
    }
    private void updateRegisteredUsers() {

    if (registeredUsersList.isEmpty()) {
        System.out.println("No registered users to remove");
        return;
    }

    Scanner scanner = new Scanner(System.in);


    System.out.println("Enter the email address of the user you want to update:");
    String emailToUpdate = scanner.nextLine();


    RegisteredUsers userToUpdate = null;
    for (RegisteredUsers user : registeredUsersList) {
        if (user.getEmailAddress().equalsIgnoreCase(emailToUpdate)) {
            userToUpdate = user;
            break;
        }
    }

   
    if (userToUpdate == null) {
        System.out.println("No user found with this email address");
        return;
    }

   
    System.out.println("Type new full name: (Press ENTER for no change)");
    String newFullName = scanner.nextLine();
    if (!newFullName.isEmpty()) {
        userToUpdate.setFullName(newFullName);
    }

    System.out.println("Type new date of birth: (Press ENTER for no change)");
    String newDateOfBirth = scanner.nextLine();
    if (!newDateOfBirth.isEmpty()) {
        userToUpdate.setDateOfBirth(newDateOfBirth);
    }

    System.out.println("Type new card number: (Enter 0 for no change)");
    long newCardNumber = scanner.nextLong();
    scanner.nextLine();
    if (newCardNumber != 0) {
        userToUpdate.setCardNumber(newCardNumber);
    }

    System.out.println("Type new card provider: (Press ENTER for no change)");
    String newCardProvider = scanner.nextLine();
    if (!newCardProvider.isEmpty()) {
        userToUpdate.setCardProvider(newCardProvider);
    }

    System.out.println("Type new card expiry date: (Press ENTER for no change)");
    String newCardExpiryDate = scanner.nextLine();
    if (!newCardExpiryDate.isEmpty()) {
        userToUpdate.setCardExpiryDate(newCardExpiryDate);
    }

    System.out.println("Type new CVV: (Enter 0 for no change)");
    int newCvv = scanner.nextInt();
    scanner.nextLine();
    if (newCvv != 0) {
        userToUpdate.setCvv(newCvv);
    }

    System.out.println("Type new user type: (Press ENTER for no change)");
    String newUserType = scanner.nextLine();
    if (!newUserType.isEmpty()) {
        userToUpdate.setUserType(newUserType);
    }

    System.out.println("Type new fee to charge: (Enter 0 for no change)");
    double newFeeToCharge = scanner.nextDouble();
    scanner.nextLine();
    if (newFeeToCharge != 0) {
        userToUpdate.setFeeToCharge(newFeeToCharge);
    }

    System.out.println("User with email " + emailToUpdate + " updated successfully.");
}
}


