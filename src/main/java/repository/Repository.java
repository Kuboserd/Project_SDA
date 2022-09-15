package repository;

import flight.Airport;
import flight.Flight;
import tickets.Ticket;
import users.Account;
import util.HibernateUtil;

import javax.persistence.EntityManager;
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

    public static List<Airport> getByCityName(String cityName){
        return entityManager.createQuery("FROM Airport a WHERE a.cityName =: cityName", Airport.class)
                .setParameter("cityName", cityName)
                .getResultList();
    }

    public static void close() {
        entityManager.close();
    }

}
