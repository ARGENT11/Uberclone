package ConcreteClasses;

import java.util.Scanner;

import AbstractClasses.User;



public class InputHandler {
    private static Scanner scanner = new Scanner(System.in);

    public static String getStringInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    public static int getIntInput(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
            }
        }
    }

    public static double getDoubleInput(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
    }

    public static java.time.LocalDate getDateInput(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return java.time.LocalDate.parse(scanner.nextLine());
            } catch (java.time.format.DateTimeParseException e) {
                System.out.println("Invalid date format. Please enter a date in YYYY-MM-DD format.");
            }
        }
    }

    public static User.UserType getUserTypeInput(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().toLowerCase();
            if (input.equals("passenger") || input.equals("1")) {
                return User.UserType.PASSENGER;
            } else if (input.equals("driver") || input.equals("2")) {
                return User.UserType.DRIVER;
            } else {
                System.out.println("Invalid input. Please enter  either 'Passenger' or 'Driver'.");
            }
        }
    }

}