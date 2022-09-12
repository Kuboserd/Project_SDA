package users;

import lombok.Getter;
import lombok.Setter;

import javax.management.relation.Role;
import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User {

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
    private BigDecimal phone;

    @Column
    private boolean wallet;

    @Column
    private double balance;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private RoleType role;

}
