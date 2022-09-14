import repository.Repository;
import users.Account;
import util.HibernateUtil;

import javax.persistence.EntityManager;
import java.util.Arrays;

public class Main {

    private static EntityManager entityManager = HibernateUtil.getSessionFactory().createEntityManager();

    public static void main(String[] args) {

/*        entityManager.getTransaction().begin();

        entityManager.persist(new User("Marek","Karol","mkarol@gmail.com","1234","666231634", 200));
        entityManager.getTransaction().commit(); */
        System.out.println(Arrays.toString(Repository.getTable(Account.class).toArray()));

        entityManager.close();
    }
}
