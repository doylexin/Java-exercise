public class Main {
    public static void main(String[] args) {
        ERyder bike1 = new ERyder();
        bike1.printBikeDetails();
        ERyder bike2 = new ERyder("Bike666", 66, true, 120.5);
        bike2.setBikeID("Bike666");
        bike2.setBatteryLevel(66);
        bike2.ride();
        bike2.printBikeDetails();
    }
}