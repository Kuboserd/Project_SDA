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
    private BigDecimal user_id;

    private String user_name;
    private String user_family_name;
    private BigDecimal user_mobile;
    private RoleType role;
}
