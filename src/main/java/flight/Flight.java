package flight;

import tickets.Ticket;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
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

}
