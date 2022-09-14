package config.loginsystem;

import config.MenuException;
import users.Account;

import java.util.Scanner;

public class ControllerLogin {
    private static Scanner scanner = new Scanner(System.in);
    private static Login login = new Login();
    private String email;
    private String password;


    public void checkLogin(){
        checkEmailByAccount();
        checkPassword();
        System.out.println("Login successful");
        login.setAccount(email);
    }

    private void printEmail(){
        System.out.println("What's your e-mail address?");
        email = scanner.nextLine();
    }

    private void checkEmailByAccount(){
        try {
            printEmail();
            login.filterEmailByAccount(email);
        } catch (MenuException e) {
            System.out.println(e.getMessage());
            checkEmailByAccount();
        }
    }

    private void checkPassword(){
        try {
            System.out.println("What's your password?");
            password = scanner.nextLine();
            login.isValidPassword(password);
        } catch (MenuException e) {
            System.out.println(e.getMessage());
            checkPassword();
        }
    }


}
