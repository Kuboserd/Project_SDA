package gui;

import gui.mediator.Component;
import gui.mediator.Mediator;
import repository.Repository;
import users.Account;
import users.User;
import util.ValidationUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class RegisterPanel extends JPanel implements Component {
    private JLabel firstNameJL = new JLabel("First name");
    private JTextField firstNameJTF = new JTextField();
    private JLabel lastNameJL = new JLabel("Last name");
    private JTextField lastNameJTF = new JTextField();
    private JLabel emailJL = new JLabel("Email");
    private JLabel incorrectEmailJL = new JLabel("Invalid e-mail");
    private JTextField emailJTF = new JTextField();
    private JLabel pswdJL = new JLabel("Password");
    private JPasswordField pswdJTF = new JPasswordField();
    private JLabel confirmPswdJL = new JLabel("Confirm password");
    private JPasswordField confirmPSWDJTF = new JPasswordField();
    private JLabel phoneJL = new JLabel("Phone number");
    private JLabel incorrectPhoneJL = new JLabel("Invalid phone number");
    private JTextField phoneJTF = new JTextField();
    private JButton reg = new JButton("Register");
    private JButton cancel = new JButton("Cancel");
    private Mediator mediator;
    private Account account;
    private boolean addAccount = false;

    public RegisterPanel() {
        setAllBounds();
        addKeyLisToEmailJTF();
        addKeyLisToPhoneJTF();
        addAllToPanel();
        setLayout(null);
        setVisible(true);
        checkField();
        addActionToRegButton();
        addActionCancelButton();
    }

    public void addAllToPanel(){
        add(firstNameJL);
        add(firstNameJTF);
        add(lastNameJL);
        add(lastNameJTF);
        add(emailJL);
        add(incorrectEmailJL);
        add(emailJTF);
        add(pswdJL);
        add(pswdJTF);
        add(confirmPswdJL);
        add(confirmPSWDJTF);
        add(phoneJL);
        add(incorrectPhoneJL);
        add(phoneJTF);
        add(reg);
        add(cancel);
    }

    public void setAllBounds(){
        firstNameJL.setBounds(70, 8, 70, 20);
        firstNameJTF.setBounds(70, 27, 193, 28);
        lastNameJL.setBounds(70, 55, 70, 20);
        lastNameJTF.setBounds(70, 74, 193, 28);
        emailJL.setBounds(70, 102, 70, 20);
        incorrectEmailJL.setBounds(170, 102, 100, 20);
        emailJTF.setBounds(70, 121, 193, 28);
        pswdJL.setBounds(70, 196, 70, 20);
        pswdJTF.setBounds(70, 215, 190, 28);
        confirmPswdJL.setBounds(70, 243, 120, 20);
        confirmPSWDJTF.setBounds(70, 262, 190, 28);
        phoneJL.setBounds(70, 149, 150, 20);
        incorrectPhoneJL.setBounds(170, 149, 150, 20);
        phoneJTF.setBounds(70, 168, 193, 28);
        reg.setBounds(70, 320, 90, 25);
        cancel.setBounds(170,320,90,25);
    }

    public void addKeyLisToEmailJTF() {
        incorrectEmailJL.setForeground(Color.RED);
        incorrectEmailJL.setVisible(false);
        emailJTF.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if (ValidationUtil.isValidEmailAddress(emailJTF.getText())) {
                    incorrectEmailJL.setVisible(false);
                    addAccount = true;
                } else {
                    incorrectEmailJL.setVisible(true);
                    addAccount = false;
                }
            }
        });
    }

    public void addKeyLisToPhoneJTF(){
        incorrectPhoneJL.setForeground(Color.RED);
        incorrectPhoneJL.setVisible(false);
        phoneJTF.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if (ValidationUtil.isValidPhoneNumber(phoneJTF.getText())) {
                    incorrectPhoneJL.setVisible(false);
                    addAccount = true;
                } else {
                    incorrectPhoneJL.setVisible(true);
                    addAccount = false;
                }
            }
        });
    }
    public void setDateToAccount(){
        String name = firstNameJTF.getText();
        String lastName = lastNameJTF.getText();
        String email = emailJTF.getText();
        String password = pswdJTF.getPassword().toString();
        String phone = phoneJTF.getText();
        account = new User(name,lastName,email,password,phone);
    }

    public void addActionToRegButton(){
        reg.addActionListener(e -> {
            if (checkField()) {
                setDateToAccount();
                Repository.addAccount(account);
                System.out.println(addAccount);
                System.out.println("Success");
            } else {
                System.out.println("valid");
            }
        });
    }

    public boolean checkField(){
        return !firstNameJTF.getText().isEmpty()
            &&!lastNameJTF.getText().isEmpty()
            &&!phoneJTF.getText().isEmpty()
            &&addAccount;
    }

    public void addActionCancelButton(){
        cancel.addActionListener(e ->
                mediator.offVisibleRegPanel());
    }

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public String getName(){
        return "regPanel";
    }
}
