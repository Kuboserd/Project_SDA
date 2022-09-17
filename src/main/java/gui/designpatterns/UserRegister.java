package gui.designpatterns;

import entity.users.Account;
import entity.users.User;

public class UserRegister implements AccountStrategy{
    private Account account = new User();
    @Override
    public Account setAccountRegister() {
        return account;
    }
}
