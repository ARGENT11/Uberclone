

package AbstractClasses;

import java.time.LocalDate;
import java.time.Period;//to calculate age based on date of birth

abstract class User {
    private String name;
    private String email;
    private String phoneNumber;
    private LocalDate dateOfBirth;

    public User(String name, String email, String phoneNumber, LocalDate dateOfBirth) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.dateOfBirth = dateOfBirth;
    }
    
    //get
    public String getName() {
        return name;
    }
    
    public String getEmail() {
        return email;
    }
    
    public String getPhoneNumber() {
        return phoneNumber;
    }
    
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }
    
    public int getAge() {
        return Period.between(dateOfBirth, LocalDate.now()).getYears();
    }
    
    //set
    public void setName(String name) {
        this.name = name;
    }
}
