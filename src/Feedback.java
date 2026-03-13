public class Feedback {
    private String firstName;
    private String lastName;
    private String email;
    private String completeFeedback;
    private String reviewID;
    private boolean longFeedback;
    public Feedback(String firstName, String lastName, String email){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getEmail() {
        return email;
    }
    private String feedbackUsingConcatenation(String sent1, String sent2, String sent3, String sent4, String sent5) {
        String concatenatedFeedback = sent1 + " " + sent2 + " " + sent3 + " " + sent4 + " " + sent5;
        return concatenatedFeedback;
    }
    private String feedbackUsingStringBuilder(String sent1, String sent2, String sent3, String sent4, String sent5) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.valueOf(sent1));
        sb.append(String.valueOf(sent2));
        sb.append(String.valueOf(sent3));
        sb.append(String.valueOf(sent4));
        sb.append(String.valueOf(sent5));

        return sb.toString();
    }
    private boolean checkFeedbackLength(String completeFeedback){
        if(completeFeedback.length() > 500){
            return true;
        } else {
            return false;
        }
    }
    private void creatReviewID(String firstName, String lastName){
        String userName = firstName + lastName;
        String str1 = userName.substring(2,6);
        String str2 = completeFeedback.substring(10,15);
        String str3 = str1 + str2;
        String str4 = str3.toLowerCase();
        String str5 = str4 + completeFeedback.length() + "_";
        reviewID = str5 + System.currentTimeMillis();
    }
    public String toString(){
        return "First Name: " + firstName + "\nLast Name: " + lastName + "\nEmail: " + email + "\nComplete Feedback: " + completeFeedback + "\nIs Feedback Long: " + longFeedback + "\nReview ID: " + reviewID;
    }
    public void analyseFeedback(boolean isConcatenation, String sent1, String sent2, String sent3, String sent4, String sent5){
     if(isConcatenation){
        completeFeedback = feedbackUsingConcatenation(sent1, sent2, sent3, sent4, sent5);
        longFeedback = checkFeedbackLength(completeFeedback);
        creatReviewID(getFirstName(), getLastName());
     }
    else{
        completeFeedback = feedbackUsingConcatenation(sent1, sent2, sent3, sent4, sent5);
        checkFeedbackLength(completeFeedback);
        creatReviewID(getFirstName(), getLastName());
     }
    }
}
