package config.create;

import util.ConnectionManager;
import config.MenuException;
import users.Account;
import users.User;

import javax.persistence.EntityManager;

public class CreateAccount {
    private static EntityManager em = ConnectionManager.getEntityManager();
    private User user;

    public void createUser(String name, String surname, String email, String password, String phone){
        user = new User(name, surname, email, password, phone);
    }

    public void checkEmail(String email) throws MenuException {
        int i = (int) em.createQuery("from Account a where a.email =: email", Account.class)
                .setParameter("email",email)
                .getResultStream()
                .count();
        if(i == 1){
            throw new MenuException("Error, this e-mail address has been used");
        }
    }

    public void addUserToDB(){
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
        em.close();
    }
}
