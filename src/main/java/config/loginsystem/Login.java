package config.loginsystem;

import config.MenuException;
import repository.Repository;
import users.Account;

import java.util.List;

public class Login {
    private boolean active = false;
    private Account account;
    public void filterEmailByAccount(String email) throws MenuException {
        List<Account> accounts = Repository.getByMail(email);
        if (accounts.size() == 1) {
            account = accounts.get(0);
        } else {
            throw new MenuException("Error, did not find the e-mail");
        }
    }

    public void isValidPassword(String password) throws MenuException {
        if(!account.getPassword().equals(password)){
            throw new MenuException("Error, wrong password");
        }
    }

    public void setActive(String email) {
        active = true;
    }

    public Account getAccount(){
        return account;
    }

    public void setAccount(Account account){
        this.account = account;
    }
}
