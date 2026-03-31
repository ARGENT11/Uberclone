package ConcreteClasses;

public class Ride {
    private Passenger passenger;
    private Driver driver;
    private String pickupLocation;
    private String dropoffLocation;
    private double distance; // km
    private double fare;

    private enum RideStatus {
        REQUESTED, ACCEPTED, IN_PROGRESS, COMPLETED, CANCELLED, DOCILE
    }

    private RideStatus status;

    public Ride(Passenger passenger, String pickup, String dropoff, double distance, double fare) {
        this.passenger = passenger;
        this.pickupLocation = pickup;
        this.dropoffLocation = dropoff;
        this.distance = distance;
        this.fare = fare;
        this.status = RideStatus.DOCILE; // Initial status when ride is created

    }

    public RideStatus getStatus() {
        return status;
    }

    public void setStatus(RideStatus status) {
        this.status = status;
    }

    public void displayRideDetails() {
        System.out.println("\n===============================");
        System.out.println("       RIDE DETAILS            ");
        System.out.println("===============================");
        System.out.println("Passenger: " + (passenger != null ? passenger.getName() : "Unknown"));
        System.out.println("From:      " + pickupLocation);
        System.out.println("To:        " + dropoffLocation);
        System.out.println("Distance:  " + String.format("%.2f", distance) + " km");
        System.out.println("Total Fare:KES " + String.format("%.2f", fare));
        if (driver != null) {
            System.out.println("Driver:    " + driver.getName());
        }
        System.out.println("===============================\n");
    }


 //tbh i dont why i didnt impliment these functions explicitly in ride.java but since i like making everthing complicated i decided to deligate the driver functions
public String getPickupLocation() { return pickupLocation; }
public String getDropoffLocation() { return dropoffLocation; }
public Passenger getPassenger() { return passenger; }
public double getFare() { return fare; }

public void acceptRide(Driver d) {
    this.driver = d;
    this.status = RideStatus.ACCEPTED;
    d.acceptRide(); 
}

public void startRide() {
    if (this.status == RideStatus.ACCEPTED) {
        this.status = RideStatus.IN_PROGRESS;
        System.out.println("Ride started: Heading to destination.");
    }
}

public void completeRide() {
    if (this.status == RideStatus.IN_PROGRESS) {
        this.status = RideStatus.COMPLETED;
        if (this.driver != null) {
            this.driver.completeRide(); 
        }
    }
}
}