package ConcreteClasses;

public class Fare implements interfaces.Payment {
    private double baseFare = 50.0; // Base fare for any ride
    private double perKmRate = 25.0; // Rate per kilometer

    @Override
    public double calculateFare(double distance) {
        return baseFare + (perKmRate * distance);
    }
    
}
