package gui;

import config.MenuException;
import config.loginsystem.Login;
import repository.Repository;
import users.Account;

import javax.swing.*;
import java.util.List;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI {

    public static void main(String[] args) {

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Flybook - Login Page");
        frame.setLocation(new Point(500, 300));


        JPanel panel = new JPanel(new BorderLayout());
        panel.setLayout(null);



        JLabel label = new JLabel("E-mail");
        panel.add(label);
        label.setBounds(100, 8, 70, 20);


        JTextField email = new JTextField();
        panel.add(email);
        email.setBounds(100, 27, 193, 28);

        JLabel pswdLabel = new JLabel("Password");
        panel.add(pswdLabel);
        pswdLabel.setBounds(100, 55, 70, 20);

        JPasswordField pswdField = new JPasswordField();
        panel.add(pswdField);
        pswdField.setBounds(100, 75, 190, 28);

        JButton but = new JButton("Login");
        but.setForeground(Color.WHITE);
        but.setBackground(Color.BLACK);
        but.setBounds(100, 110, 90, 25);

        JButton reg = new JButton("Register");
        reg.setForeground(Color.WHITE);
        reg.setBackground(Color.BLACK);
        reg.setBounds(200, 110, 90, 25);


        reg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                new RegisterPage(frame);

            }
        });


        but.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String mail = email.getText();
                List<Account> accountsQueried = Repository.getByMail(mail);
                if(accountsQueried.size() <= 0) {
                    JOptionPane.showMessageDialog(null , "Invalid email!");
                    return;
                }
                String password = String.valueOf(pswdField.getPassword());
                Account account = accountsQueried.get(0);

                if(!account.getPassword().equals(password)) {
                    JOptionPane.showMessageDialog(null, "Invalid password!");
                    return;
                }
                FrontPage page = new FrontPage(account);
                page.setLocationRelativeTo(frame);
                frame.setVisible(false);
            }
        });

        panel.add(reg);
        panel.add(but);
        frame.pack();
        frame.add(panel);
        frame.setSize(new Dimension(700, 300));

        frame.setVisible(true);

    }


}