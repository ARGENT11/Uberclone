package ConcreteClasses;
import AbstractClasses.User;
//import interfaces.UserOperations;

public class Passager extends User  {//will include userOPerations later

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
