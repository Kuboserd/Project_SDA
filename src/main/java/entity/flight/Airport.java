package entity.flight;


import lombok.ToString;

import javax.persistence.*;
import java.util.List;
@Entity
@Table(name = "airports")
public class Airport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "startAirport")
    private List<Flight> flightList;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "endAirport")
    private List<Flight> flightList2;

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

    @Override
    public String toString() {
        return "Airport{" +
                "name='" + name + '\'' +
                ", cityCode='" + cityCode + '\'' +
                ", cityName='" + cityName + '\'' +
                ", countryName='" + countryName + '\'' +
                ", countryCode='" + countryCode + '\'' +
                "}\n";
    }
}
