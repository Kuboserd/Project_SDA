package util.repository;

import entity.flight.Flight;
import entity.flight.Plane;
import gui.MenuException;
import entity.flight.Airport;
import entity.tickets.Ticket;
import entity.users.Account;
import util.HibernateUtil;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.util.List;

public class Repository {

    private static final EntityManager entityManager = HibernateUtil.getSessionFactory().createEntityManager();

    public static void addAccount(Account object) {
        entityManager.getTransaction().begin();
        entityManager.persist(object);
        entityManager.getTransaction().commit();
    }

    public static void updateAccount(Account object) {
        entityManager.getTransaction().begin();
        entityManager.merge(object);
        entityManager.getTransaction().commit();
    }

    public static void addFlight(Flight object) {
        entityManager.getTransaction().begin();
        entityManager.persist(object);
        entityManager.getTransaction().commit();
    }

    public static void addTicket(Ticket object) {
        entityManager.getTransaction().begin();
        entityManager.persist(object);
        entityManager.getTransaction().commit();
    }

    public static <T> List<T> getTable(Class<T> entity) {
        return entityManager.createQuery("FROM " + entity.getSimpleName(), entity)
                .getResultList();
    }

    public static List<Account> getByMail(String email) {
        return entityManager.createQuery("FROM User u WHERE u.email = :email", Account.class)
                .setParameter("email", email)
                .getResultList();
    }

    public static Account getAccountByMail(String email) throws MenuException {
        return entityManager.createQuery("FROM Account a WHERE a.email = :email", Account.class)
                .setParameter("email", email)
                .getResultStream()
                .findFirst()
                .orElseThrow(new MenuException("Invalid email"));

    }

    public static List<Airport> getByCityName(String cityName){
        return entityManager.createQuery("FROM Airport a WHERE a.cityName =: cityName", Airport.class)
                .setParameter("cityName", cityName)
                .getResultList();
    }

    public static List<Plane> getByName(String name){
        return entityManager.createQuery("FROM Plane p WHERE p.name =: name", Plane.class)
                .setParameter("name", name)
                .getResultList();
    }

    public static List<Airport> getByCountryName(String countryName){
        return entityManager.createQuery("FROM Airport a WHERE a.countryName =: countryName", Airport.class)
                .setParameter("name", countryName)
                .getResultList();
    }

    public static Airport getAirportByName(String name){
        return entityManager.createQuery("FROM Airport a WHERE a.name =: name", Airport.class)
                .setParameter("name",name)
                .getResultList().get(0);
    }

    public static Plane getPlaneByDate(LocalDate yearOfProduction){
        return entityManager.createQuery("FROM Plane p WHERE p.yearOfProduction =: yearOfProduction", Plane.class)
                .setParameter("yearOfProduction",yearOfProduction)
                .getResultList().get(0);
    }


    public static void close() {
        entityManager.close();
    }

}
