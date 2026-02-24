package ConcreteClasses;

public class Ride {
    private Passager passenger;
    private Driver driver;
    private String pickupLocation;
    private String dropoffLocation;
    private double distance;  // in km
    private double fare;
    private String status;  // "requested", "accepted", "in_progress", "completed"

    public Ride(Passager passenger, String pickupLocation, String dropoffLocation, double distance) {
        this.passenger = passenger;
        this.pickupLocation = pickupLocation;
        this.dropoffLocation = dropoffLocation;
        this.distance = distance;
        this.fare = calculateFare(distance);  // Simple fare calculation
        this.status = "requested";
    }

    // Simple fare calculation: base fare + per km
    private double calculateFare(double distance) {
        double baseFare = 2.0;
        double perKm = 1.5;
        return baseFare + (perKm * distance);
    }

    // Getters
    public Passager getPassenger() {
        return passenger;
    }

    public Driver getDriver() {
        return driver;
    }

    public String getPickupLocation() {
        return pickupLocation;
    }

    public String getDropoffLocation() {
        return dropoffLocation;
    }

    public double getDistance() {
        return distance;
    }

    public double getFare() {
        return fare;
    }

    public String getStatus() {
        return status;
    }

    // Setters
    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // Methods
    public void acceptRide(Driver driver) {
        if (this.driver == null && driver.isAvailable()) {
            this.driver = driver;
            this.status = "accepted";
            driver.acceptRide();
            System.out.println("Ride accepted by " + driver.getName());
        } else {
            System.out.println("Ride cannot be accepted.");
        }
    }

    public void startRide() {
        if ("accepted".equals(status)) {
            status = "in_progress";
            System.out.println("Ride started.");
        }
    }

    public void completeRide() {
        if ("in_progress".equals(status)) {
            status = "completed";
            driver.completeRide();
            System.out.println("Ride completed. Fare: $" + fare);
        }
    }

    public void displayRideDetails() {
        System.out.println("Passenger: " + passenger.getName());
        System.out.println("Driver: " + (driver != null ? driver.getName() : "Not assigned"));
        System.out.println("Pickup: " + pickupLocation);
        System.out.println("Dropoff: " + dropoffLocation);
        System.out.println("Distance: " + distance + " km");
        System.out.println("Fare: $" + fare);
        System.out.println("Status: " + status);
    }
}