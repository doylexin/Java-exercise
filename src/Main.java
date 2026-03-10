public class Main {
    public static void main(String[] args) {
        ERyder bike1 = new ERyder("Bike1",50,true,50);
        bike1.printBikeDetails();
        bike1.printRideDetails();
        ERyder bike2 = new ERyder("Bike666", 66, true, 120.5, "Doyle", 1234567890);
        bike2.setBikeID("Bike666");
        bike2.setBatteryLevel(66);
        bike2.ride();
        bike2.printBikeDetails();
        bike2.printRideDetails();
    }
}