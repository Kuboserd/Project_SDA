package entity.flight;

import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
public class Seats {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    public Seats() {
    }
}
