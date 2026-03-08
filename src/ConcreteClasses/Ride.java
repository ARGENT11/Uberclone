package ConcreteClasses;

public class Ride {
    private Passager passenger;
    private Driver driver;
    private String pickupLocation;
    private String dropoffLocation;
    private double distance;  // km
    private double fare;
    private String status;  // might change it for an enum later

    public Ride(Passager passenger, String pickup, String dropoff, double distance, double fare) {
    this.passenger = passenger;
    this.pickupLocation = pickup;
    this.dropoffLocation = dropoff;
    this.distance = distance;
    this.fare = fare; 
    this.status = "requested";
}
  
}