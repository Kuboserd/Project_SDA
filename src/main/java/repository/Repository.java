package repository;

import users.Account;
import util.HibernateUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class Repository {

    static EntityManager entityManager = HibernateUtil.getSessionFactory().createEntityManager();

    public void add(Account object) {
        entityManager.getTransaction().begin();
        entityManager.persist(object);
        entityManager.getTransaction().commit();
    }

    public void update(Account object) {
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

    public List<Account> getByMail(String email) {
        List<Account> tempList;
        tempList = entityManager.createQuery("FROM User u WHERE u.email = :email", Account.class)
                .setParameter("email", email)
                .getResultList();
        return tempList;
    }

    public void close() {
        entityManager.close();
    }

}
