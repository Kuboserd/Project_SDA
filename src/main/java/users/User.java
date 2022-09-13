package users;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Getter
@Setter
@ToString
@Entity
@DiscriminatorValue("user")
public class User extends Account {
    private double balance;

    public User(String name, String surname, String email, String password, String phone, double balance) {
        super(name, surname, email, password, phone);
        this.balance = balance;
    }

    public User() {
    }
    /*Metody*/

}
