
package AbstractClasses;

import java.time.LocalDate;
import java.time.Period;//to calculate age based on date of birth

public abstract class User {
    public enum UserType { PASSENGER, DRIVER }
    
    private String name;
    private String email;
    private String phoneNumber;
    private LocalDate dateOfBirth;
    private double ratingSum = 5.0; // Initial rating sum (5.0)
    private int ratingCount = 1; // Initial rating count
    private UserType userType;
    private String password;

    public User(String name, String email, String phoneNumber, LocalDate dateOfBirth, UserType userType, String password) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.dateOfBirth = dateOfBirth;
        this.userType = userType;
        this.password = password;
    }

    // get
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public UserType getUserType() {
        return userType;
    }

    public String getPassword() {
        return password;
    }

    public int getAge() {
        return Period.between(dateOfBirth, LocalDate.now()).getYears();
    }

    public double getRating() {
        return ratingSum / ratingCount;
    }

    public int getRatingCount() {
        return ratingCount;
    }

    public UserType getTypeOfUser() {
        return userType;
    }

    public void addRating(double newRating) {
        if (newRating < 1.0 || newRating > 5.0) {
            throw new IllegalArgumentException("Rating must be between 1.0 and 5.0");
        }
        ratingSum += newRating;
        ratingCount++;
    }

    // set
    public void setPassword(String password) {
        this.password = password;
    }

    
    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void updateProfile(String name, String email, String phoneNumber, LocalDate dateOfBirth) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.dateOfBirth = dateOfBirth;
    }

    public void viewProfile() {
        System.out.println("Name: " + name);
        System.out.println("Phone Number: " + phoneNumber);
        System.out.println("Rating: " + String.format("%.2f", getRating()) + " (" + getRatingCount() + " ratings)");
    }
}
