package tickets;

import users.User;

import javax.persistence.*;

@Entity
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User owner;

    @Column
    private float price;

    @Column(name = "luggage_type")
    @Enumerated(EnumType.STRING)
    private LuggageType luggageType;

    @Column(name = "clearance_priority")
    private boolean clearancePriority;

    //TODO
    //private Flight flight;

}
