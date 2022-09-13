package config.loginsystem;

import config.ConnectionManager;
import users.Account;

import javax.persistence.EntityManager;

public class Login {
    private static EntityManager em = ConnectionManager.getEntityManager();
    public Account filterEmailByAccount(String email){
        em.getTransaction().begin();
        Account account = em.createQuery("from Account a where a.email =: email", Account.class)
                .setParameter("email",email)
                        .getSingleResult();
        em.getTransaction().commit();
        em.close();
        return account;
    }

    public boolean isValidPassword(String password, Account account){
        return account.getPassword().equals(password);
    }
}
