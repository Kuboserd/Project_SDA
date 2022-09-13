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
        System.out.println("What's your e-mail address?");
        email = print();
        System.out.println("What password do you want?");
        password = print();
        System.out.println("What password do you want?");
        name = print();
        System.out.println("What's your surname?");
        surname = print();
        System.out.println("What's your phone number?");
        phone = print();
    }

    private String print(){
        return scanner.nextLine();
    }

    private void createUser(){
        createAccount.createUser(name,surname,email,password,phone);
    }
}
