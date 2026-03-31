package ConcreteClasses;


import java.util.Map;
import AbstractClasses.User;

public class Authentication {
    
    private Map<String, User> users = Filehandler.loadUsers();
    
    public boolean signup(User user) {
        
        if (users.containsKey(user.getEmail())) {
            return false;
        }
        users.put(user.getEmail(), user);
        
        Filehandler.saveUsers(users); 
        return true; 
    }

    public User signin(String email, String password) {
        User user = users.get(email);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }

    // added this getter so that i can add a save feature evrytime the user logs out soo i have to call the map
    
    public Map<String, User> getUsers() {
    return users;
}
}