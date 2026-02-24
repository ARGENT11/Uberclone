package ConcreteClasses;
import interfaces.Payment;

public class PaymentProcessor implements Payment {

    @Override
    public double calculateFare(double distance) {
        double baseFare = 2.0;
        double perKm = 1.5;
        return baseFare + (perKm * distance);
    }

    // Additional payment methods
    public boolean processPayment(Passager passenger, double fare) {
        if (passenger.getBalance() >= fare) {
            passenger.setBalance(passenger.getBalance() - fare);
            System.out.println("Payment processed successfully.");
            return true;
        } else {
            System.out.println("Payment failed: Insufficient balance.");
            return false;
        }
    }
}