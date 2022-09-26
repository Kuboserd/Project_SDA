package gui.panels;

import gui.designpatterns.AccountStrategy;
import gui.designpatterns.Component;
import gui.designpatterns.Mediator;
import util.repository.Repository;
import entity.users.Account;
import util.ValidationUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class RegisterPanel extends JPanel implements Component {
    private JLabel info = new JLabel("Register user", SwingConstants.CENTER);
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
    private JButton backJB = new JButton("Back");
    private Mediator mediator;
    private Account account;
    private boolean emailValid = false;
    private boolean phoneValid = false;

    public RegisterPanel() {
        setAllBounds();
        addKeyLisToEmailJTF();
        addKeyLisToPhoneJTF();
        addAllToPanel();
        setLayout(null);
        setVisible(true);
        addActionToRegButton();
        addActionBackButton();
    }

    private void addAllToPanel() {
        add(info);
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
        add(backJB);
    }

    private void setAllBounds() {
        info.setBounds(90, 30, 150, 35);
        firstNameJL.setBounds(70, 68, 70, 20);
        firstNameJTF.setBounds(70, 87, 193, 28);
        lastNameJL.setBounds(70, 115, 70, 20);
        lastNameJTF.setBounds(70, 134, 193, 28);
        emailJL.setBounds(70, 162, 70, 20);
        incorrectEmailJL.setBounds(170, 162, 100, 20);
        emailJTF.setBounds(70, 181, 193, 28);
        pswdJL.setBounds(70, 256, 70, 20);
        pswdJTF.setBounds(70, 275, 190, 28);
        confirmPswdJL.setBounds(70, 303, 120, 20);
        confirmPSWDJTF.setBounds(70, 322, 190, 28);
        phoneJL.setBounds(70, 209, 150, 20);
        incorrectPhoneJL.setBounds(170, 209, 150, 20);
        phoneJTF.setBounds(70, 228, 193, 28);
        reg.setBounds(70, 380, 90, 25);
        backJB.setBounds(170, 380, 90, 25);
    }

    private void addKeyLisToEmailJTF() {
        incorrectEmailJL.setForeground(Color.RED);
        incorrectEmailJL.setVisible(false);
        emailJTF.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if (ValidationUtil.isValidEmailAddress(emailJTF.getText())) {
                    incorrectEmailJL.setVisible(false);
                    emailValid = true;
                } else {
                    incorrectEmailJL.setVisible(true);
                    emailValid = false;
                }
            }
        });
    }

    private void addKeyLisToPhoneJTF() {
        incorrectPhoneJL.setForeground(Color.RED);
        incorrectPhoneJL.setVisible(false);
        phoneJTF.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if (ValidationUtil.isValidPhoneNumber(phoneJTF.getText())) {
                    incorrectPhoneJL.setVisible(false);
                    phoneValid = true;
                } else {
                    incorrectPhoneJL.setVisible(true);
                    phoneValid = false;
                }
            }
        });
    }

    private void setDateToAccount() {
        account = mediator.getAccountStrategy();
        account.setName(firstNameJTF.getText());
        account.setSurname(lastNameJTF.getText());
        account.setEmail(emailJTF.getText());
        account.setPassword(String.valueOf(pswdJTF.getPassword()));
        account.setPhone(phoneJTF.getText());
    }

    private void addActionToRegButton() {
        reg.setForeground(Color.WHITE);
        reg.setBackground(Color.BLACK);
        reg.addActionListener(e -> {
            if (checkField()) {
                setDateToAccount();
                Repository.addAccount(account);
                JOptionPane.showMessageDialog(null, "Success");
            } else {
                JOptionPane.showMessageDialog(null, "Error");
            }
        });
    }

    private boolean checkField() {
        return !firstNameJTF.getText().isEmpty()
                && !lastNameJTF.getText().isEmpty()
                && !phoneJTF.getText().isEmpty()
                && phoneValid
                && emailValid;
    }

    //TODO
    private void addActionBackButton() {
        backJB.setForeground(Color.WHITE);
        backJB.setBackground(Color.BLACK);
    }

    public JButton getBackJB() {
        return backJB;
    }

    public JLabel getInfoJL() {
        return info;
    }

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public String getName() {
        return "regPanel";
    }
}
