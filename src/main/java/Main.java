import util.HibernateUtil;

import javax.persistence.EntityManager;

public class Main {
    public static void main(String[] args) {
       HibernateUtil.getSessionFactory();
    }
}
