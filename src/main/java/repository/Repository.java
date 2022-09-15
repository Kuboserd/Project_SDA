package repository;

import users.Account;
import users.User;
import util.HibernateUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class Repository {

    private static final EntityManager entityManager = HibernateUtil.getSessionFactory().createEntityManager();

    public static void add(Account object) {
        entityManager.getTransaction().begin();
        entityManager.persist(object);
        entityManager.getTransaction().commit();
    }


    public static void create(User object) {
        entityManager.getTransaction().begin();
        entityManager.persist(object);
        entityManager.getTransaction().commit();
    }

    public static void update(Account object) {
        entityManager.getTransaction().begin();
        entityManager.merge(object);
        entityManager.getTransaction().commit();
    }

    public static <T> List<T> getTable(Class<T> entity) {
        List<T> tempList;
        tempList = entityManager.createQuery("FROM " + entity.getSimpleName(), entity)
                .getResultList();
        return tempList;
    }

    public static List<Account> getByMail(String email) {
        List<Account> tempList;
        tempList = entityManager.createQuery("FROM User u WHERE u.email = :email", Account.class)
                .setParameter("email", email)
                .getResultList();
        return tempList;
    }

    public static void close() {
        entityManager.close();
    }

}
