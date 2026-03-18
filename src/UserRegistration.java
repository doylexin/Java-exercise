import java.util.Scanner;
import java.time.LocalDate;
import java.time.Period;
public class UserRegistration {
    private static final double VIP_DISCOUNT_UNDER_18_BIRTHDAY = 25.0;
    private static final double VIP_DISCOUNT_UNDER_18 = 20.0;
    private static final double VIP_BASE_FEE = 100.0;
    private String fullName;
    private String emailAddress;
    private String dateOfBirth;
    private long cardNumber;
    private String cardProvider;
    private String cardExpiryDate;
    private double feeToCharge;
    private int cvv;
    private String userType;
    private boolean emailValid;
    private boolean minorAndBirthday;
    private boolean minor;
    private boolean ageValid;
    private boolean cardNumberValid;
    private boolean cardStillValid;
    private boolean validCVV;
    Scanner scanner = new Scanner(System.in);

    public void registration(){
        System.out.println("Welcome to the ERyder Registration.");
        System.out.println("Here are your two options:");
        System.out.println("1. Register as a Regular User");
        System.out.println("2. Register as a VIP User");
        System.out.println("Please enter your choice (1 or 2):");
        int choice = scanner.nextInt();
        scanner.nextLine(); 
        if(choice == 1){
            userType = "Regular User";
        }
        else if(choice == 2){
            userType = "VIP User";
        }
        else {
            System.out.println("Invalid choice. Please restart the registration process.");
            return;
        }
        System.out.println("Please enter your full name:");
        fullName = scanner.nextLine();
        System.out.println("Please enter your email address:");
        emailAddress = scanner.nextLine();
        emailValid = analyseEmail(emailAddress);
        System.out.println("Please enter your date of birth (YYYY-MM-DD):");
        dateOfBirth = scanner.nextLine();
        LocalDate dob = LocalDate.parse(dateOfBirth);
        ageValid = analyseAge(dob);
        System.out.println("Please enter your card number:( only Visa, MasterCard, and American Express cards are accepted)");
        cardNumber = scanner.nextLong();
        scanner.nextLine();
        cardNumberValid = analyseCardNumber(cardNumber);
        System.out.println("Please enter your card expiry date (MM/YY):");
        cardExpiryDate = scanner.nextLine();
        cardStillValid = analyseCardExpiryDate(cardExpiryDate);
        System.out.println("Please enter your card CVV:");
        cvv = scanner.nextInt();
        scanner.nextLine();
        validCVV = analyseCVV(cvv);
        finalCheckpoint();
        if(scanner != null) {
            scanner.close();
        }
    }
    private boolean analyseEmail(String emailAddress){
        if(emailAddress.contains("@") && emailAddress.contains(".")){
            System.out.println("Email is valid");
            return true;
        }
        else{
            System.out.println("Invalid email address. Going back to the start of the registration");
            registration();
            return false;
        }
    }
    private boolean analyseAge(LocalDate dob){
        LocalDate currentDate = LocalDate.now();
        int age = Period.between(dob, currentDate).getYears();
        boolean isBirthday = (currentDate.getMonthValue() == dob.getMonthValue()) && (currentDate.getDayOfMonth() == dob.getDayOfMonth());

        if(userType.equals("VIP User")){
            if(isBirthday && age >= 12 && age < 18){
                System.out.println("Happy Birthday!");
                System.out.println("You get a 25% discount on the VIP subscription fee for being born today and being under 18!");
                minorAndBirthday = true;
            }
            else if(!isBirthday && age >= 12 && age < 18){
                System.out.println("You get a 20% discount on the VIP subscription fee for being under 18!");
                minor = true;
            }
        }
        if(age < 12 || age > 120){
            System.out.println("Looks like you are either too young or already dead. Sorry, you can’t be our user. Have a nice day!");
            System.exit(0);
        }
        return true;
    }
    private boolean analyseCardNumber(long cardNumber){
        String cardNumstr = String.valueOf(cardNumber);
        int firstTwoDigits = Integer.parseInt(cardNumstr.substring(0, 2));
        int firstFourDigits = Integer.parseInt(cardNumstr.substring(0, 4));
       if((cardNumstr.length()==13||cardNumstr.length()==15)&&cardNumstr.startsWith("4")){
        cardProvider = "VISA";
       } 
       else if(cardNumstr.length()==16&&(firstTwoDigits>=51||firstTwoDigits<=55||firstFourDigits>=2221&&firstFourDigits<=2720)){
        cardProvider = "MasterCard";
       }
       else if(cardNumstr.length()==15&&(cardNumstr.startsWith("34")||cardNumstr.startsWith("37"))){
        cardProvider = "American Express";
       }
       else{
        System.out.println("Sorry, but we accept only VISA, MasterCard, or American Express cards. Please try again with a valid card.");
        System.out.println("Going back to the start of the registration.");
        registration();
       }
       return true;
    }

    private boolean analyseCardExpiryDate(String cardExpiryDate){
        int month = Integer.parseInt(cardExpiryDate.substring(0, 2));
        int year = Integer.parseInt(cardExpiryDate.substring(3, 5)) + 2000;
        LocalDate currentDate = LocalDate.now();
        int currentYear = currentDate.getYear();
        int currentMonth = currentDate.getMonthValue();
        if(year > currentYear || (year == currentYear && (month < currentMonth||month == currentMonth))){
        System.out.println("The card is still valid");

    }
        else{
        System.out.println("Sorry, your card has expired. Please use a different card");
        System.out.println("Going back to the start fo the registration process…");
        registration();
    }
        return true;
}
        private boolean analyseCVV(int cvv){
            String cvvStr = String.valueOf(cvv);
            if((cardProvider.equals("American Express") && cvvStr.length() == 4)
                ||(cardProvider.equals("VISA")&&cvvStr.length() == 3)
                || (cardProvider.equals("MasterCard") && cvvStr.length() == 3))
                System.out.println("CVV is valid");
            else{
                System.out.println("Invalid CVV for the given card.");
                System.out.println("Going back to the start of the registration process.");
            }
                registration();
                return true;
    }

    private void finalCheckpoint(){
        if(emailValid && ageValid && cardNumberValid && cardStillValid && validCVV){
            chargeFees();
        }
        else{
            System.out.println("Sorry, your registration was unsuccessful due to the following reason(s).");  
        }
        if(!emailValid){
            System.out.println("Invalid email address");
        }
        if(!ageValid){
            System.out.println("Invalid age");
        }
        if(!cardNumberValid){
            System.out.println("Invalid card number");
        }
        if(!cardStillValid){
            System.out.println("Card has expired");
        }
        if(!validCVV){
            System.out.println("Invalid CVV");
        }
        System.out.println("Going back to the start of the registration process.");
        registration();
    }
        private void chargeFees(){
            if(minorAndBirthday){
                feeToCharge = VIP_BASE_FEE * 0.25;
            }
            if(minor){
                feeToCharge = VIP_BASE_FEE * 0.20;
            }
            else{
                feeToCharge = VIP_BASE_FEE;
            }
            System.out.println("Thank you for your payment. ");
            System.out.println("A fee of $" + feeToCharge + 
            " has been charged to your card ending with " + String.valueOf(cardNumber).substring(String.valueOf(cardNumber).length()-4));
        }   

        @Override
        public String toString(){
            String cardNumberStr = String.valueOf(cardNumber);
            String censoredPart = cardNumberStr.substring(0, cardNumberStr.length() - 4).replaceAll(".", "*");
            String lastFourDigits = cardNumberStr.substring(cardNumberStr.length() - 4);
            String censoredNumber = censoredPart + lastFourDigits;
            return "Registration successful! Here are your details:" + cardExpiryDate + "\nUser Type: " + userType + "\nFull Name: " + fullName + "\nEmail Address: " + emailAddress + "\nDate of Birth: " + dateOfBirth + "\nCard Number: " + censoredNumber + "\nCard Provider: " + cardProvider + "\nCard Expiry Date: ";
        }
        
    } 
