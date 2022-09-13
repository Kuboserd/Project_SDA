package config.create;

import java.util.Scanner;

public class ControllerCreate {
    private static Scanner scanner = new Scanner(System.in);
    private CreateAccount createAccount = new CreateAccount();
    private String email;
    private String password;
    private String name;
    private String surname;
    private String phone;

    public void startCreateAccount(){
        getMenu();
        createUser();
        createAccount.addUserToDB();
    }

    private void getMenu(){
        askEmail();
        email = print();
        askPassword();
        password = print();
        askName();
        name = print();
        askSurname();
        surname = print();
        askPhone();
        phone = print();
    }

    private void askEmail(){
        System.out.println("What's your e-mail address?");
    }

    private void askPassword(){
        System.out.println("What password do you want?");
    }

    private void askName(){
        System.out.println("What's your name?");
    }

    private void askSurname(){
        System.out.println("What's your surname?");
    }

    private void askPhone(){
        System.out.println("What's your phone number?");
    }

    private String print(){
        return scanner.nextLine();
    }

    private void createUser(){
        createAccount.createUser(name,surname,email,password,phone);
    }
}
