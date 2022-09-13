package config;

import util.HibernateUtil;

import javax.persistence.EntityManager;

public class ConnectionManager {
    private static EntityManager entityManager = HibernateUtil.getSessionFactory().createEntityManager();

    public static EntityManager getEntityManager() {
        return entityManager;
    }
}
