public class Main {
    public static void main(String[] args) {
        String str1 = "I was very satisfied with the service.";
        String str2 = "The e-Bike is quite comfortable to ride.";
        String str3 =  "The battery life of the e-Bike is impressive.";
        String str4 = "The customer support was helpful and responsive.";
        String str5 = "I would recommend this e-Bike to my friends and family.";
        Feedback feedback = new Feedback("Yixin", "Chen", "87293772@qq.com");
        feedback.analyseFeedback(false, str1, str2, str3, str4, str5);
        System.out.println(feedback);
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