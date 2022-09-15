package flight;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "airports")
public class Airport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "airport")
    private List<Flight> flightList;

    @Column
    private String code;

    @Column
    private String name;

    @Column
    private String cityCode;

    @Column
    private String cityName;//

    @Column
    private String countryName;//

    @Column
    private String countryCode;

    @Column
    private String timezone;

    @Column
    private String lat;

    @Column
    private String lon;

    @Column
    private int numAirports;

    @Column(name = "city")
    private boolean isCity;
}
