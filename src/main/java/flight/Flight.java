package flight;

import tickets.Ticket;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity(name = "flights")
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "flight")
    private List<Ticket> ticketList;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "airport_id")
    private Airport airport;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "plane_id")
    private Plane plane;

    @Column
    private String destination;

    @Column
    private String origin;

    @Column(name = "departure_time")
    private LocalDateTime departureTime;

    @Column(name = "arrival_time")
    private LocalDateTime arrivalTime;

}
