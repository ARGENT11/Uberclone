package ConcreteClasses;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import AbstractClasses.User;
import ConcreteClasses.Authentication;
import ConcreteClasses.InputHandler;
import ConcreteClasses.Passager;
import ConcreteClasses.Driver;
import ConcreteClasses.Ride;
import AbstractClasses.Vehicle;

public class AppMenu {
    private Authentication auth;
    private List<Ride> pendingRides = new ArrayList<>();
    private boolean running = true;

    public AppMenu(Authentication auth) {
        this.auth = auth;
    }

    public void run() {
        while (running) {
            showMainMenu();
            int choice = InputHandler.getIntInput("Choose an option: ");
            switch (choice) {
                case 1 -> SignupMenu();
                case 2 -> SigninMenu();
                case 3 -> {
                    running = false;
                    System.out.println("Exiting...");
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private void showMainMenu() {
        System.out.println("\n--- Uber ---");
        System.out.println("1. Signup");
        System.out.println("2. Signin");
        System.out.println("3. Exit");
    }

    private void SignupMenu() {
        System.out.println("\n--- Signup ---");
        System.out.println("1. Passenger\n2. Driver");
        User.UserType type = InputHandler.getUserTypeInput("Choose user type: ");
        String name = InputHandler.getStringInput("Name: ");
        String email = InputHandler.getStringInput("Email: ").toLowerCase();
        String phone = InputHandler.getStringInput("Phone: ");
        LocalDate dob = InputHandler.getDateInput("Date of birth (YYYY-MM-DD): ");
        String password = InputHandler.getStringInput("Password: ");

        if (type == User.UserType.PASSENGER) {
            double balance = InputHandler.getDoubleInput("Initial balance: ");
            String payment = InputHandler.getStringInput("Payment method: ");
            Passager p = new Passager(name, email, phone, dob, balance, payment, password);
            if (auth.signup(p))
                System.out.println("Passenger signed up.");
            else
                System.out.println("Signup failed: email already exists.");
        } else if (type == User.UserType.DRIVER) {
            String color = InputHandler.getStringInput("Vehicle color: ");
            String brand = InputHandler.getStringInput("Vehicle brand: ");
            String model = InputHandler.getStringInput("Vehicle model: ");
            String typeV = InputHandler.getStringInput("Vehicle type: ");
            String plate = InputHandler.getStringInput("Plate number: ");
            int seats = InputHandler.getIntInput("Number of seats: ");
            Vehicle v = new Car(color, brand, model, typeV, plate, seats);
            Driver d = new Driver(name, email, phone, dob, v, password);
            if (auth.signup(d))
                System.out.println("Driver signed up.");
            else
                System.out.println("Signup failed: email already exists.");
        } else {
            System.out.println("Invalid user type.");
        }
    }

    private void SigninMenu() {
        System.out.println("\n--- Signin ---");
        String email = InputHandler.getStringInput("Email: ").toLowerCase();
        String password = InputHandler.getStringInput("Password: ");
        User user = auth.signin(email, password);
        if (user == null) {
            System.out.println("Invalid credentials.");
            return;
        }

        if (user.getUserType() == User.UserType.PASSENGER) {
            passengerMenu((Passager) user);
        } else if (user.getUserType() == User.UserType.DRIVER) {
            driverMenu((Driver) user);
        }
    }

    private void passengerMenu(Passager p) {
        boolean inMenu = true;
        while (inMenu) {
            System.out.println("\n--- Passenger Menu ---");
            System.out.println("1. Request Ride\n2. View Profile\n3. Logout");
            int choice = InputHandler.getIntInput("Choose: ");
            switch (choice) {
                case 1 -> requestRideFlow(p);
                case 2 -> p.viewProfile();
                case 3 -> inMenu = false;
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private void driverMenu(Driver d) {
        boolean inMenu = true;
        while (inMenu) {
            System.out.println("\n--- Driver Menu ---");
            System.out.println("1. View Pending Rides\n2. Accept Ride\n3. View Profile\n4. Logout");
            int choice = InputHandler.getIntInput("Choose: ");
            switch (choice) {
                case 1 -> showPendingRides();
                case 2 -> assignRideToDriver(d);
                case 3 -> d.viewProfile();
                case 4 -> inMenu = false;
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private void requestRideFlow(Passager p) {
        String pickup = InputHandler.getStringInput("Pickup location: ");
        String dropoff = InputHandler.getStringInput("Dropoff location: ");
        double distance = InputHandler.getDoubleInput("Distance (km): ");
        Ride ride = p.requestRide(pickup, dropoff, distance);
        pendingRides.add(ride);
        System.out.println("Ride requested and added to pending queue.");
    }

    private void showPendingRides() {
        if (pendingRides.isEmpty()) {
            System.out.println("No pending rides.");
            return;
        }
        System.out.println("Pending rides:");
        for (int i = 0; i < pendingRides.size(); i++) {
            Ride r = pendingRides.get(i);
            System.out.println((i + 1) + ". " + r.getPickupLocation() + " -> " + r.getDropoffLocation() + " ("
                    + r.getPassenger().getName() + ")");
        }
    }

    private void assignRideToDriver(Driver d) {
        if (pendingRides.isEmpty()) {
            System.out.println("No rides to accept.");
            return;
        }
        showPendingRides();
        int idx = InputHandler.getIntInput("Choose ride number to accept: ") - 1;
        if (idx < 0 || idx >= pendingRides.size()) {
            System.out.println("Invalid selection.");
            return;
        }
        Ride r = pendingRides.remove(idx);
        r.acceptRide(d);
        r.startRide();
        r.completeRide();
        System.out.println("Ride completed.");
        PaymentProcessor pp = new PaymentProcessor();
        pp.processPayment(r.getPassenger(), r.getFare());
    }
}
