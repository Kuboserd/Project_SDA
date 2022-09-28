package gui.panels;

import gui.MenuException;
import gui.designpatterns.Component;
import gui.designpatterns.Mediator;
import util.repository.Repository;
import entity.users.Account;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class LoginPanel extends JPanel implements Component {
    private JLabel emailJL = new JLabel("Email");
    private JTextField emailJTF = new JTextField();
    private JLabel pswdJL = new JLabel("Password");
    private JPasswordField pswdJFT = new JPasswordField();
    private JButton login = new JButton("Login");
    private JButton reg = new JButton("Register");
    private Account account;
    private Mediator mediator;

    public LoginPanel() {
        createLoginButton();
        createRegButton();
        setAllBounds();
        addAllToPanel();
        setLayout(null);
        setVisible(true);
    }

    private void addAllToPanel(){
        add(emailJL);
        add(emailJTF);
        add(pswdJL);
        add(pswdJFT);
        add(login);
        add(reg);
    }

    private void setAllBounds(){
        emailJL.setBounds(70, 8, 70, 20);
        emailJTF.setBounds(70, 27, 193, 28);
        pswdJL.setBounds(70, 55, 70, 20);
        pswdJFT.setBounds(70, 75, 190, 28);
        login.setBounds(70, 110, 90, 25);
        reg.setBounds(170, 110, 90, 25);
    }

    private void createLoginButton(){
        login.setForeground(Color.WHITE);
        login.setBackground(Color.BLACK);
        login.addActionListener(e -> {
            String mail = emailJTF.getText();
            try {
                account = Repository.getAccountByMail(mail);
            } catch (MenuException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
                return;
            }
            String password = String.valueOf(pswdJFT.getPassword());
            if(!account.getPassword().equals(password)){
                JOptionPane.showMessageDialog(null,"Invalid password");
                return;
            }
            mediator.setAccount(account);
            mediator.choicePanel();
        });
    }

    private void createRegButton(){
        reg.setBounds(200, 110, 90, 25);
        reg.setForeground(Color.WHITE);
        reg.setBackground(Color.BLACK);
        reg.addActionListener(e -> {
            mediator.setAccountType("user");
            mediator.setBackAndInfoRegPanel("login");
            mediator.offPanel(this);
            mediator.setSizeFrame(350,460);
            mediator.onPanel(mediator.getRegisterPanel());
        });
    }

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public String getName(){
        return "loginPanel";
    }
}
