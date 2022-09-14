package config.loginsystem;

import config.MenuException;
import users.Account;

import java.util.Scanner;

public class ControllerLogin {
    private static Scanner scanner = new Scanner(System.in);
    private static Login login = new Login();
    private Account account;
    private String email;
    private String password;

    public void checkLogin(){
        printEmail();
        account = checkEmailByAccount();
        checkPassword();
    }

    private void printEmail(){
        System.out.println("What's your e-mail address?");
        email = scanner.nextLine();
    }

    private Account checkEmailByAccount(){
        try {
            return login.filterEmailByAccount(email);
        } catch (MenuException e) {
            System.out.println(e.getMessage());
            printEmail();
            checkEmailByAccount();
        }
        return null;
    }

    private void checkPassword(){
        try {
            System.out.println("What's your password?");
            password = scanner.nextLine();
            login.isValidPassword(password, account);
        } catch (MenuException e) {
            System.out.println(e.getMessage());
            checkPassword();
        }
    }
}
