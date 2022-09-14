package config.loginsystem;

import config.ConnectionManager;
import config.MenuException;
import users.Account;

import javax.persistence.EntityManager;
import java.util.List;

public class Login {
    private static EntityManager em = ConnectionManager.getEntityManager();
    private boolean active = false;
    private Account account;
    public boolean filterEmailByAccount(String email) throws MenuException {
        List<Account> accounts = em.createQuery("from Account a where a.email =: email", Account.class)
                .setParameter("email", email)
                .getResultList();
        if (accounts.size() == 1) {
            account = accounts.get(0);
            return true;
        } else {
            throw new MenuException("Error, did not find the e-mail");
        }
    }

    public boolean isValidPassword(String password) throws MenuException {
        if(account.getPassword().equals(password)){
            return true;
        } else {
            throw new MenuException("Error, wrong password");
        }
    }

    public void setAccount(String email){
        active = true;
        account = em.createQuery("from Account a where a.email =: email", Account.class)
                .setParameter("email", email)
                .getSingleResult();
    }

    public Account getAccount(){
        return account;
    }
}
