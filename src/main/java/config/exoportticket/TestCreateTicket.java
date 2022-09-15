package config.exoportticket;

import flight.Airport;
import repository.Repository;
import users.Account;

import java.util.List;

public class TestCreateTicket {
    public static void main(String[] args) {
        List<Airport>  airports =  Repository.getByCountryName("poland");
        System.out.println(airports);
    }


}
