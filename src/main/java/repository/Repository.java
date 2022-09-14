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

    public static  <T> List<T> get(Class entity) {
        List<T> tempList;
        tempList = entityManager.createQuery("from " + entity.getSimpleName()).getResultList();
        return tempList;
    }



    public void close() {
        entityManager.close();
    }

}
