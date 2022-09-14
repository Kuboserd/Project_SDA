package config.loginsystem;

import config.ConnectionManager;
import config.MenuException;
import users.Account;

import javax.persistence.EntityManager;
import java.util.List;

public class Login {
    private static EntityManager em = ConnectionManager.getEntityManager();
    public Account filterEmailByAccount(String email) throws MenuException {
        List<Account> accounts = em.createQuery("from Account a where a.email =: email", Account.class)
                .setParameter("email", email)
                .getResultList();
        if (accounts.size() == 1) {
            return accounts.get(0);
        } else {
            throw new MenuException("Error, did not find the e-mail");
        }
    }

    public boolean isValidPassword(String password, Account account) throws MenuException {
        if(account.getPassword().equals(password)){
            return true;
        } else {
            throw new MenuException("Error, wrong password");
        }
    }


}
