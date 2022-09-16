package config.exoportticket;

import entity.flight.Airport;
import util.repository.Repository;

import java.util.List;

public class TestCreateTicket {
    public static void main(String[] args) {
        List<Airport>  airports =  Repository.getByCountryName("poland");
        System.out.println(airports);
    }


}
