package gui;

import repository.Repository;
import users.User;
import util.ValidationUtil;


import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.*;

public class RegisterPage extends JFrame {
    private JFrame _prevFrame;

    public RegisterPage(JFrame prevFrame) throws HeadlessException {
        this._prevFrame = prevFrame;
        this.main();
    }

    public void main() {

        JPanel panel = new JPanel();
        panel.setLayout(null);


        JLabel firstName = new JLabel("First Name");
        firstName.setBounds(100, 8, 70, 20);
        panel.add(firstName);

        JTextField firstNameField = new JTextField();
        firstNameField.setBounds(100, 27, 193, 28);
        panel.add(firstNameField);

        JLabel lastName = new JLabel("Last Name");
        lastName.setBounds(100, 55, 70, 20);
        panel.add(lastName);

        JTextField lastNameField = new JTextField();
        lastNameField.setBounds(100, 74, 193, 28);
        panel.add(lastNameField);


        JLabel emailLabel = new JLabel("E-mail");
        emailLabel.setBounds(100, 102, 70, 20);
        panel.add(emailLabel);

        JLabel isIncorrectEmail = new JLabel("Invalid E-Mail");
        isIncorrectEmail.setBounds(200, 102, 100, 20);
        isIncorrectEmail.setForeground(Color.RED);  //TODO
        isIncorrectEmail.setVisible(false);         //TODO
        panel.add(isIncorrectEmail);


        JTextField emailField = new JTextField();
        emailField.setBounds(100, 121, 193, 28);
        emailField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if (ValidationUtil.isValidEmailAddress(emailField.getText())) {
                    isIncorrectEmail.setVisible(false);
                } else {
                    isIncorrectEmail.setVisible(true);
                }
            }
        });

        panel.add(emailField);


        JLabel phoneNumber = new JLabel("Phone Number");
        phoneNumber.setBounds(100, 149, 150, 20);

        panel.add(phoneNumber);


        JLabel isIncorrectPhone = new JLabel("Invalid Phone Number");
        isIncorrectPhone.setBounds(200, 149, 150, 20);
        isIncorrectPhone.setForeground(Color.RED);
        isIncorrectPhone.setVisible(false);
        panel.add(isIncorrectPhone);


        JTextField phoneNumberField = new JTextField();
        phoneNumberField.setBounds(100, 168, 193, 28);
        panel.add(phoneNumberField);

        phoneNumberField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if (ValidationUtil.isValidPhoneNumber(phoneNumberField.getText())) {
                    isIncorrectPhone.setVisible(false);
                } else {
                    isIncorrectPhone.setVisible(true);
                }
            }
        });


        JLabel pswdLabel = new JLabel("Password");
        pswdLabel.setBounds(100, 196, 70, 20);
        panel.add(pswdLabel);

        JPasswordField pswdField = new JPasswordField();
        pswdField.setBounds(100, 215, 190, 28);
        panel.add(pswdField);


        JLabel confirmPswdLabel = new JLabel("Confirm Password");
        confirmPswdLabel.setBounds(100, 243, 120, 20);
        panel.add(confirmPswdLabel);

        JPasswordField confirmPswdField = new JPasswordField();
        confirmPswdField.setBounds(100, 262, 190, 28);
        panel.add(confirmPswdField);


        JButton reg = new JButton("Register");
        reg.setBounds(100, 320, 90, 25);
        reg.setForeground(Color.WHITE);
        reg.setBackground(Color.BLACK);
        panel.add(reg);


        this.setTitle("Flybook - Register");
        this.add(panel);
        this.setLocation(new Point(500, 300));
        this.setSize(new Dimension(500, 500));
        this.setVisible(true);
        this.setResizable(false);


        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                _prevFrame.setVisible(true);
                super.windowClosing(e);
            }
        });


    }

}