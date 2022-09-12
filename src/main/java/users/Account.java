package users;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
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

    @Column
    private boolean wallet;

    @Column
    private double balance;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private RoleType role;

    public Account(String name, String surname, String email, String password, String phone, RoleType role) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.role = role;
        this.wallet = role == RoleType.USER;
    }
}
