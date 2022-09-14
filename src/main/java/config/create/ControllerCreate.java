package config.create;

import config.MenuException;

import java.awt.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ControllerCreate {
    private static Scanner scanner = new Scanner(System.in);
    private CreateAccount createAccount = new CreateAccount();
    private String email;
    private String password;
    private String name;
    private String surname;
    private String phone;

    public void startCreateAccount() {
        getMenu();
        createUser();
        createAccount.addUserToDB();
    }

    private void getMenu() {
        printEmail();
        System.out.println("What password do you want?");
        password = print();
        System.out.println("What's your name?");
        name = print();
        System.out.println("What's your surname?");
        surname = print();
        printPhoneNumber();
    }

    private void printEmail() {
        try {
            System.out.println("What's your e-mail address?");
            email = print();
            createAccount.checkEmail(email);
        } catch (MenuException e) {
            System.out.println(e.getMessage());
            printEmail();
        }
    }

    private void printPhoneNumber() {
        System.out.println("What's your phone number?");
        phone = print();
        checkPhoneNumber();
    }

    private void checkPhoneNumber() {
        try {
            Pattern pattern = Pattern.compile("\\d{9}");
            Matcher matcher = pattern.matcher(phone);
            if (!matcher.find()) {
                throw new MenuException("You entered wrong phone number");
            }
        } catch (MenuException e) {
            System.out.println(e.getMessage());
            printPhoneNumber();
        }
    }

    private String print() {
        return scanner.nextLine();
    }

    private void createUser() {
        createAccount.createUser(name, surname, email, password, phone);
    }
}
