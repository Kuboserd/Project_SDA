package config.exoportticket;

import flight.Airport;
import repository.Repository;

import java.util.List;

public class TestCreateTicket {
    public static void main(String[] args) {
        List<Airport>  airports =  Repository.getByCityName("Amsterdam");
        System.out.println(airports);
    }
}
