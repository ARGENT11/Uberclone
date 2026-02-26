package ConcreteClasses;


import java.util.HashMap;
import java.util.Map;

import AbstractClasses.User;

public class Authentication {
    private Map<String, User> users = new HashMap<>();

    //had to reaseach for this one but basically  we call the above classes which act as our database
    //we use a method in that class called "containsKey" to check if such a value exists in our makeshift database
    //so for signup we check if the email already exists and if it does we return false otherwise we add the user to our database and return true
    public boolean signup(User user) {
        if (users.containsKey(user.getEmail())) {
            return false; 
        }
        users.put(user.getEmail(), user);
        return true;
    }

    public User signin(String email, String password) {
        User user = users.get(email);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }
}
