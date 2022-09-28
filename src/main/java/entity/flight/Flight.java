package entity.flight;

import entity.tickets.Ticket;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Setter
@Table(name = "flights")
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "flight")
    private List<Ticket> ticketList;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "start_airport_id")
    private Airport startAirport;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "end_airport_id")
    private Airport endAirport;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "plane_id")
    private Plane plane;

    @Column(name = "departure_time")
    private LocalDateTime departureTime;

    @Column(name = "arrival_time")
    private LocalDateTime arrivalTime;

    public Airport getStartAirport() {
        return startAirport;
    }

    public Airport getEndAirport() {
        return endAirport;
    }

    public Plane getPlane() {
        return plane;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public LocalDateTime getArrivalTime() {
        return arrivalTime;
    }

    @Override
    public String toString() {
        return "Flight: " +
                "from: " + startAirport.getCityName() +
                ", to: " + endAirport.getCityName() +
                ", departureTime: " + departureTime +
                ", arrivalTime: " + arrivalTime + "\n";

    }
}
