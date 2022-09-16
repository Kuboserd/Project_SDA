package entity.users;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import entity.tickets.Ticket;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@ToString

@Entity
@DiscriminatorValue("user")
public class User extends Account {

    private double balance;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<Ticket> ticketList;

    public User(String name, String surname, String email, String password, String phone, double balance) {
        super(name, surname, email, password, phone);
        this.balance = balance;
    }

    public User(String name, String surname, String email, String password, String phone) {
        super(name, surname, email, password, phone);
    }

    public User() {
    }
    /*Metody*/

}