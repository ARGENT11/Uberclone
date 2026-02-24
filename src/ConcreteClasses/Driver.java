package ConcreteClasses;
import AbstractClasses.User;
import AbstractClasses.Vehicle;

public class Driver extends User {
    private Vehicle vehicle;
    private boolean isAvailable;

    public Driver(String name, String email, String phoneNumber, java.time.LocalDate dateOfBirth, Vehicle vehicle) {
        super(name, email, phoneNumber, dateOfBirth);
        this.vehicle = vehicle;
        this.isAvailable = true;  // Drivers start as available
    }

    // Getters
    public Vehicle getVehicle() {
        return vehicle;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    // Setters
    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    // Additional methods
    public void acceptRide() {
        if (isAvailable) {
            setAvailable(false);
            System.out.println(getName() + " has accepted the ride.");
        } else {
            System.out.println(getName() + " is not available.");
        }
    }

    public void completeRide() {
        setAvailable(true);
        System.out.println(getName() + " has completed the ride and is now available.");
    }

    @Override
    public void viewProfile() {
        super.viewProfile();
        System.out.println("Vehicle: " + vehicle.getVehicleBrand() + " " + vehicle.getVehicleModel());
        System.out.println("Available: " + isAvailable);
    }
}