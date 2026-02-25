
import java.time.LocalDate;
import AbstractClasses.Vehicle ;
import ConcreteClasses.Car;
import ConcreteClasses.Driver;
import ConcreteClasses.Passager;
import ConcreteClasses.PaymentProcessor;
import ConcreteClasses.Ride;

public class Main {
    public static void main(String[] args) {
        
        Passager passenger = new Passager("Jason", "Jason@strathmore.edu", "0115726246",
                LocalDate.of(1995, 3, 10), 50.0, "Credit Card", "password123");

        
        Car vehicle = new Car("Red", "Toyota", "Camry", "Sedan", "ABC123", 4);

        
        Driver driver = new Driver("Hamilton", "hamilton@gmail.com", "0712345678",
                LocalDate.of(1985, 7, 20), vehicle, "password456");

        Ride ride = passenger.requestRide("Home", "Airport", 15.0);

        ride.acceptRide(driver);

        ride.startRide();

        ride.completeRide();
        PaymentProcessor paymentProcessor = new PaymentProcessor();
        paymentProcessor.processPayment(passenger, ride.getFare());

        driver.addRating(4.5);
        passenger.addRating(5.0);  

        
        System.out.println("\n--- Passenger Profile ---");
        passenger.viewProfile();

        System.out.println("\n--- Driver Profile ---");
        driver.viewProfile();
    }
}