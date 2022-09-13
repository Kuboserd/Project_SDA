package tickets;

import users.User;

import javax.persistence.Entity;

@Entity
public class Ticket {

    private int id;
    private User owner;
    private double price;

    //TODO
    //private Flight flight;
    //private Plane plane;
    //private Seat seat;

    private LuggageType luggageType;
    private boolean clearancePriority;

}
