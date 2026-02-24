package ConcreteClasses;
import AbstractClasses.Vehicle;

public class Car extends Vehicle {

    public Car(String vehicleColour, String vehicleBrand, String vehicleModel, String vehicleType,
            String licencePlate, int noSeats) {
        super(vehicleColour, vehicleBrand, vehicleModel, vehicleType, licencePlate, noSeats);
    }

    
}