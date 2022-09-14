package config.create;

import config.MenuException;
import repository.Repository;
import users.Account;
import users.User;

import javax.persistence.EntityManager;

public class CreateAccount {
    private User user;

    public void createUser(String name, String surname, String email, String password, String phone) {
        user = new User(name, surname, email, password, phone);
    }

    public void checkEmail(String email) throws MenuException {
        int i = (int) Repository.getByMail(email).size();
        if (i == 1) {
            throw new MenuException("Error, this e-mail address has been used");
        }
    }

    public void addUserToDB() {
        Repository.add(user);
    }
}
