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
    private AccountStrategy accountStrategy;
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
        info.setBounds(90, 0, 150, 35);
        firstNameJL.setBounds(70, 38, 70, 20);
        firstNameJTF.setBounds(70, 57, 193, 28);
        lastNameJL.setBounds(70, 85, 70, 20);
        lastNameJTF.setBounds(70, 104, 193, 28);
        emailJL.setBounds(70, 132, 70, 20);
        incorrectEmailJL.setBounds(170, 132, 100, 20);
        emailJTF.setBounds(70, 151, 193, 28);
        pswdJL.setBounds(70, 226, 70, 20);
        pswdJTF.setBounds(70, 245, 190, 28);
        confirmPswdJL.setBounds(70, 273, 120, 20);
        confirmPSWDJTF.setBounds(70, 292, 190, 28);
        phoneJL.setBounds(70, 179, 150, 20);
        incorrectPhoneJL.setBounds(170, 179, 150, 20);
        phoneJTF.setBounds(70, 198, 193, 28);
        reg.setBounds(70, 350, 90, 25);
        backJB.setBounds(170, 350, 90, 25);
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
        account = accountStrategy.setAccountRegister();
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

    private void addActionBackButton() {
        backJB.setForeground(Color.WHITE);
        backJB.setBackground(Color.BLACK);
        backJB.addActionListener(e -> {
            mediator.setSizePanel(350, 200, mediator.getLoginPanel());
            mediator.offPanelOnLoginPanel(this);
            mediator.onPanel(mediator.getLoginPanel());
        });
    }

    public JButton getBackJB() {
        return backJB;
    }

    public void setAccountStrategy(AccountStrategy accountStrategy) {
        this.accountStrategy = accountStrategy;
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
