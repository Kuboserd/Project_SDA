package users;

import lombok.ToString;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@ToString
@Entity
@DiscriminatorValue("admin")
public class Admin extends Account{

    public Admin() {
    }
}
