package EntityClasses;

public class Customer {
    private String name;
    private String mobileNumber;
    private String emailId;
    private String city;
    private int age;

    public Customer(String name, String mobileNumber, String emailId, String city, int age) {
        this.name = name;
        this.mobileNumber = mobileNumber;
        this.emailId = emailId;
        this.city = city;
        this.age = age;
    }

    public String getName() {
        return name;
    }
   
    @Override
    public String toString() {
        return "Name: " + name + 
               ", Mobile Number: " + mobileNumber + 
               ", Email ID: " + emailId + 
               ", City: " + city + 
               ", Age: " + age;
    }
}
