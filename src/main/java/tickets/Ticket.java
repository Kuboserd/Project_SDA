package tickets;

import flight.Flight;
import users.User;

import javax.persistence.*;

@Entity
@Table(name = "tickets")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "flight_id")
    private Flight flight;

    @Column
    private float price;

    @Column(name = "luggage_type")
    @Enumerated(EnumType.STRING)
    private LuggageType luggageType;

    @Column(name = "clearance_priority")
    private boolean clearancePriority;



}
