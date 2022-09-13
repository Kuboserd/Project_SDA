package config.create;

import config.ConnectionManager;
import users.User;

import javax.persistence.EntityManager;

public class CreateAccount {
    private static EntityManager em = ConnectionManager.getEntityManager();

    private User user;

    public void createUser(String name, String surname, String email, String password, String phone){
        user = new User(name, surname, email, password, phone);
    }

    public void addUserToDB(){
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
        em.close();
    }
}
