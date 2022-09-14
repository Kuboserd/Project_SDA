package config.loginsystem;

import config.MenuException;
import repository.Repository;
import users.Account;

import javax.persistence.EntityManager;
import java.util.List;

public class Login {
    private boolean active = false;
    private Account account;
    public boolean filterEmailByAccount(String email) throws MenuException {
        List<Account> accounts = Repository.getByMail(email);
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

    public void setAccount(String email) {
        active = true;
        account = Repository.getByMail(email).get(0);
    }

    public Account getAccount(){
        return account;
    }
}
