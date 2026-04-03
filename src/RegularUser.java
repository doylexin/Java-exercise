public class RegularUser extends RegisteredUsers{
    public RegularUser(String fullName, String emailAddress, String dateOfBirth, long cardNumber, String cardProvider, String cardExpiryDate, double feeToCharge, int cvv, String userType, String[] lastThreeTrips) {
        super(fullName, emailAddress, dateOfBirth, cardNumber, cardProvider, cardExpiryDate, feeToCharge, cvv, userType, lastThreeTrips);
    }

    @Override
    public String calculateFare(String baseFare){
        return baseFare;
    }
    public void displayUserType(){
        System.out.println("Regular User");
}

}
