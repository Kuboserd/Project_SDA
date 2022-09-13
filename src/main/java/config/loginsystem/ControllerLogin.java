package config.loginsystem;

import users.Account;

import java.util.Scanner;

public class ControllerLogin {
    private static Scanner scanner = new Scanner(System.in);
    private static Login login = new Login();
    private Account account;
    private String email;
    private String password;

    public void checkLogin(){
        System.out.println("What's your e-mail address?");
        email = print();
        account = filterEmailByAccount();
        System.out.println("What's your password?");
        password = print();
        System.out.println(login.isValidPassword(password, account));
    }

    private String print(){
        return scanner.nextLine();
    }

    private Account filterEmailByAccount(){
        return login.filterEmailByAccount(email);
    }
}
