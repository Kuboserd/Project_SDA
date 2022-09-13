package users;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@ToString

@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Entity
@DiscriminatorColumn(name="role")
@Table(name = "users")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigDecimal id;

    @Column(name = "user_name")
    private String name;

    @Column(name = "user_family_name")
    private String surname;

    @Column
    private String email;

    @Column(name = "passwd")
    private String password;

    @Column(name = "user_mobile")
    private String phone;

    public Account(String name, String surname, String email, String password, String phone) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.phone = phone;
    }

    public Account() {
    }
}
