
import java.util.Scanner;

public class AdminPanel {
    private UserService userService = new UserService();
    private RentalService rentalService = new RentalService();
    private Scanner scanner = new Scanner(System.in);

    public void userManagementOptions() {
        System.out.println("Welcome to E-Ryder Admininstrator Panel.");
        System.out.println("What do you want to do?");
        System.out.println("1. Add New Users");
        System.out.println("2. View Registered Users");
        System.out.println("3. Remove Registered Users");
        System.out.println("4. Update Registered Users");
        System.out.println("5. EXIT");
        System.out.println("6.Demo the Bike Rental System");
        int choice = scanner.nextInt();
        scanner.nextLine();
        switch (choice) {
            case 1:
                userService.addNewUsers();
                break;
            case 2:
                userService.viewRegisteredUsers();
                break;
            case 3:
                userService.removeRegisteredUsers();
                break;
            case 4:
                userService.updateRegisteredUsers();
                break;
            case 5:
                return;
            case 6:
                rentalService.simulateApplicationInput();
                break;
            default:
                System.out.println("Invalid choice. Please try again");
                break;
        }
        userManagementOptions();
    }
}
    


