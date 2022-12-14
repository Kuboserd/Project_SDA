package gui.panels;

import entity.users.Account;
import gui.designpatterns.Component;
import gui.designpatterns.Mediator;
import util.ValidationUtil;
import util.repository.Repository;


import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ChangeDataPanel extends JPanel implements Component {
    private JLabel firstNameJL = new JLabel("First name");
    private JTextField firstNameJTF = new JTextField();
    private JButton acceptFirstNameJB = new JButton("Save");
    private JLabel lastNameJL = new JLabel("Last name");
    private JTextField lastNameJTF = new JTextField();
    private JButton acceptLastNameJB = new JButton("Save");
    private JLabel emailJL = new JLabel("Email");
    private JLabel incorrectEmailJL = new JLabel("Invalid e-mail");
    private JTextField emailJTF = new JTextField();
    private JButton acceptEmailJB = new JButton("Save");
    private JLabel pswdJL = new JLabel("Password");
    private JPasswordField pswdJTF = new JPasswordField();
    private JLabel confirmPswdJL = new JLabel("Confirm password");
    private JPasswordField confirmPSWDJTF = new JPasswordField();
    private JButton acceptPasswordJB = new JButton("Save");
    private JLabel phoneJL = new JLabel("Phone number");
    private JLabel incorrectPhoneJL = new JLabel("Invalid phone number");
    private JTextField phoneJTF = new JTextField();
    private JButton acceptPhoneJB = new JButton("Save");
    private Mediator mediator;
    private Account account;

    public ChangeDataPanel() {
        setAllBounds();
        addKeyLisToPhoneJTF();
        addKeyLisToEmailJTF();
        createAcceptFirstName();
        createAcceptLastName();
        createAcceptEmailName();
        createAcceptPassword();
        createAcceptPhoneNumber();
        addAllToPanel();
        setLayout(null);
        setVisible(true);
    }

    private void addAllToPanel() {
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
    }

    private void setAllBounds() {
        firstNameJL.setBounds(30, 38, 80, 20);
        firstNameJTF.setBounds(30, 57, 193, 28);
        acceptFirstNameJB.setBounds(230, 57, 80, 25);
        lastNameJL.setBounds(30, 85, 70, 20);
        lastNameJTF.setBounds(30, 104, 193, 28);
        acceptLastNameJB.setBounds(230, 104, 80, 25);
        emailJL.setBounds(30, 132, 70, 20);
        incorrectEmailJL.setBounds(140, 132, 100, 20);
        emailJTF.setBounds(30, 151, 193, 28);
        acceptEmailJB.setBounds(230, 151, 80, 25);
        pswdJL.setBounds(30, 226, 70, 20);
        pswdJTF.setBounds(30, 245, 190, 28);
        confirmPswdJL.setBounds(30, 273, 120, 20);
        confirmPSWDJTF.setBounds(30, 292, 190, 28);
        acceptPasswordJB.setBounds(230, 292, 80, 25);
        phoneJL.setBounds(30, 179, 150, 20);
        incorrectPhoneJL.setBounds(140, 179, 150, 20);
        phoneJTF.setBounds(30, 198, 193, 28);
        acceptPhoneJB.setBounds(230, 198, 80, 25);
    }

    private void addKeyLisToEmailJTF() {
        incorrectEmailJL.setForeground(Color.RED);
        incorrectEmailJL.setVisible(false);
        emailJTF.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if (ValidationUtil.isValidEmailAddress(emailJTF.getText())) {
                    incorrectEmailJL.setVisible(false);
                } else {
                    incorrectEmailJL.setVisible(true);
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
                } else {
                    incorrectPhoneJL.setVisible(true);
                }
            }
        });
    }

    private void createAcceptFirstName() {
        add(acceptFirstNameJB);
        acceptFirstNameJB.addActionListener(e -> {
            if (!firstNameJTF.getText().isEmpty()) {
                account.setName(firstNameJTF.getText());
                Repository.updateAccount(account);
            }
        });
    }

    private void createAcceptLastName() {
        add(acceptLastNameJB);
        acceptLastNameJB.addActionListener(e -> {
            if (!lastNameJTF.getText().isEmpty()) {
                account.setSurname(lastNameJTF.getText());
                Repository.updateAccount(account);
            }
        });
    }

    private void createAcceptEmailName() {
        add(acceptEmailJB);
        acceptEmailJB.addActionListener(e -> {
            if (ValidationUtil.isValidEmailAddress(emailJTF.getText())) {
                account.setEmail(emailJTF.getText());
                Repository.updateAccount(account);
            }
        });
    }

    public void createAcceptPassword() {
        add(acceptPasswordJB);
        acceptPasswordJB.addActionListener(e -> {
            if (!String.valueOf(pswdJTF.getPassword()).isEmpty()) {
                account.setPassword(String.valueOf(pswdJTF.getPassword()));
                Repository.updateAccount(account);
            }
        });
    }

    public void createAcceptPhoneNumber() {
        add(acceptPhoneJB);
        acceptPhoneJB.addActionListener(e -> {
            if (ValidationUtil.isValidPhoneNumber(phoneJTF.getText())) {
                account.setPhone(phoneJTF.getText());
                Repository.updateAccount(account);
            }
        });
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public String getName() {
        return "changeDataPanel";
    }
}
