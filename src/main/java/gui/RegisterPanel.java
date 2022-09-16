package gui;

import gui.mediator.Component;
import gui.mediator.Mediator;

import javax.swing.*;

public class RegisterPanel extends JPanel implements Component {
    private JLabel firstNameJL = new JLabel("First name");
    private JTextField firstNameJTF = new JTextField();
    private JLabel lastNameJL = new JLabel("Last name");
    private JTextField lastNameJTF = new JTextField();
    private JLabel emailJL = new JLabel("Email");
    private JLabel incorrectEmail = new JLabel("Invalid e-mail");
    private JTextField emailJTF = new JTextField();
    private JLabel pswdJL = new JLabel("Password");
    private JPasswordField pswdJTF = new JPasswordField();
    private JLabel confirmPswdJL = new JLabel("Confirm password");
    private JPasswordField confirmPSWDJTF = new JPasswordField();
    private JLabel phoneJL = new JLabel("Phone number");
    private JLabel incorrectPhoneJL = new JLabel("Invalid phone number");
    private JTextField phoneJTF = new JTextField();
    private JButton reg = new JButton("Register");
    private Mediator mediator;

    public RegisterPanel() {
        setAllBounds();
        addAllToPanel();
        setLayout(null);
        setVisible(true);
    }

    public void addAllToPanel(){
        add(firstNameJL);
        add(firstNameJTF);
        add(lastNameJL);
        add(lastNameJTF);
        add(emailJL);
        add(incorrectEmail);
        add(emailJTF);
        add(pswdJL);
        add(pswdJTF);
        add(confirmPswdJL);
        add(confirmPSWDJTF);
        add(phoneJL);
        add(incorrectPhoneJL);
        add(phoneJTF);
    }

    public void setAllBounds(){
        firstNameJL.setBounds(70, 8, 70, 20);
        firstNameJTF.setBounds(70, 27, 193, 28);
        lastNameJL.setBounds(70, 55, 70, 20);
        lastNameJTF.setBounds(70, 74, 193, 28);
        emailJL.setBounds(70, 102, 70, 20);
        incorrectEmail.setBounds(170, 102, 100, 20);
        emailJTF.setBounds(70, 121, 193, 28);
        pswdJL.setBounds(70, 196, 70, 20);
        pswdJTF.setBounds(70, 215, 190, 28);
        confirmPswdJL.setBounds(70, 243, 120, 20);
        confirmPSWDJTF.setBounds(70, 262, 190, 28);
        phoneJL.setBounds(70, 149, 150, 20);
        incorrectPhoneJL.setBounds(170, 149, 150, 20);
        phoneJTF.setBounds(70, 168, 193, 28);
        reg.setBounds(100, 320, 90, 25);
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
