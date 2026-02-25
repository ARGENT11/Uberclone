package ConcreteClasses;
import AbstractClasses.User;
import interfaces.UserOperations;

public class Passager extends User implements UserOperations {

    private double balance;
    private String paymentMethod;

    public Passager(String name, String email, String phoneNumber, java.time.LocalDate dateOfBirth,
            double balance, String paymentMethod, String password) {
        super(name, email, phoneNumber, dateOfBirth, User.UserType.PASSENGER, password);
        this.balance = balance;
        this.paymentMethod = paymentMethod;
    }

    // Getters
    public double getBalance() {
        return balance;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    // Setters
    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    // Implement UserOperations
    @Override
    public Void declineRide() {
        System.out.println(getName() + " has declined the ride.");
        return null;
    }

    @Override
    public void getLocation() {
        System.out.println(getName() + "'s current location: [Simulated location]");
    }

    // Additional methods
    public Ride requestRide(String pickupLocation, String dropoffLocation, double distance) {
        Ride ride = new Ride(this, pickupLocation, dropoffLocation, distance);
        System.out.println(getName() + " has requested a ride from " + pickupLocation + " to " + dropoffLocation);
        return ride;
    }

    public void payFare(double fare) {
        if (balance >= fare) {
            balance -= fare;
            System.out.println("Payment of $" + fare + " successful. Remaining balance: $" + balance);
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    
    public void viewProfile() {
        super.viewProfile();
        System.out.println("Balance: $" + balance);
        System.out.println("Payment Method: " + paymentMethod);
    }
}   
