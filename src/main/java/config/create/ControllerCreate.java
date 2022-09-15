package config.create;

import config.MenuException;

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
        inputEmail();
        System.out.println("What password do you want?");
        password = input();
        System.out.println("What's your name?");
        name = input();
        System.out.println("What's your surname?");
        surname = input();
        inputPhoneNumber();
    }

    private void inputEmail() {
        try {
            System.out.println("What's your e-mail address?");
            email = input();
            createAccount.checkEmail(email);
        } catch (MenuException e) {
            System.out.println(e.getMessage());
            inputEmail();
        }
    }

    private void inputPhoneNumber() {
        System.out.println("What's your phone number?");
        phone = input();
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
            inputPhoneNumber();
        }
    }

    private String input() {
        return scanner.nextLine();
    }

    private void createUser() {
        createAccount.createUser(name, surname, email, password, phone);
    }
}
