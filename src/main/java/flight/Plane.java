package flight;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "planes")
public class Plane {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "plane")
    private List<Flight> flight;

    @Column
    private String name;

    @Column
    private String model;

    @Column(name = "year_of_production")
    private LocalDate yearOfProduction;

}
