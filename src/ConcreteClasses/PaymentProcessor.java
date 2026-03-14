package ConcreteClasses;



public class PaymentProcessor {

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