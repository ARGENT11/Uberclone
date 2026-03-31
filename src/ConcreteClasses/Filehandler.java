package ConcreteClasses;

import java.io.*;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import AbstractClasses.User;
import AbstractClasses.Vehicle;

public class Filehandler {
    private static final String FileLocation = "users.txt";

    // Saves the current Map of users to a text file using BufferedWriter
    public static void saveUsers(Map<String, User> users) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FileLocation))) {
            for (User user : users.values()) {
                writer.write(serializeUser(user));
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error saving users: " + e.getMessage());
        }
    }

    //Used   BufferedReader
    public static Map<String, User> loadUsers() {
        Map<String, User> loadedUsers = new HashMap<>();
        File users = new File(FileLocation);
        if (!users.exists()) return loadedUsers;

        try (BufferedReader reader = new BufferedReader(new FileReader(users))) {
            String line;
            while ((line = reader.readLine()) != null) {
                User user = deserializeUser(line);
                if (user != null) {
                    loadedUsers.put(user.getEmail(), user);
                }
            }
        } catch (IOException e) {
            System.err.println("Error loading users: " + e.getMessage());
        }
        return loadedUsers;
    }

    //just to organize the data when its being saved therefore making it easier to read and write in the file
    private static String serializeUser(User u) {
    String base = u.getUserType() + "|" + u.getName() + "|" + u.getEmail() + "|" + 
                 u.getPhoneNumber() + "|" + u.getDateOfBirth() + "|" + u.getPassword();
    
    if (u instanceof Passenger) {
        return base + "|" + ((Passenger) u).getBalance() + "|" + ((Passenger) u).getPaymentMethod();
    } else if (u instanceof Driver) {
        Vehicle v = ((Driver) u).getVehicle();
        return base + "|" + v.getLicencePlate() + "," + v.getVehicleColour() + "," + v.getVehicleBrand() + "," + v.getVehicleModel();
    }
    return base;
}

private static User deserializeUser(String data) {
    try {
        String[] p = data.split("\\|");
        User.UserType type = User.UserType.valueOf(p[0]);
        LocalDate dob = LocalDate.parse(p[4]);

        if (type == User.UserType.PASSENGER) {
            return new Passenger(p[1], p[2], p[3], dob, Double.parseDouble(p[6]), p[7], p[5]);
        } else {
            String[] v = p[6].split(",");
            Vehicle car = new Car(v[1], v[2], v[3], "Sedan", v[0], 4); 
            return new Driver(p[1], p[2], p[3], dob, car, p[5]);
        }
    } catch (Exception e) {
        return null;
    }
}
}